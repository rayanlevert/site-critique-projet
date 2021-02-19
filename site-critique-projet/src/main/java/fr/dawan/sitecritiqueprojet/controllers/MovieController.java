package fr.dawan.sitecritiqueprojet.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.JsonViewResponseBodyAdvice;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer;

import fr.dawan.sitecritiqueprojet.beans.Movie;
import fr.dawan.sitecritiqueprojet.services.MovieService;
@RestController
@RequestMapping("/api/movies")
@CrossOrigin(origins="http://localhost:3000")
public class MovieController {

    @Autowired
    private MovieService iMovieService;
    
    @GetMapping(value="/", produces = "application/json")
    public List<Movie> getMovies()
    {
        List<Movie> movies = iMovieService.findAll();
        return movies;
    }
    
    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable("id") long id)
    {
        Movie movie = iMovieService.findOneById(id);
        return movie;
    }
    
    
    /*
     * [search,filter,filterValue] recherche avec filtre -->findBySearchFiltered
     * [search,"",""] recherche sans filtres -->findBySearch
     * ["",filter,filterValue] filtrage des films sur une propriété -->findByFilter
     * filter & filterValue doivent être avoir tout deux une valeur ou être null
     * */
    @PostMapping(value = "/search", consumes="application/json", produces="application/json")
    public List<Movie> getSearchMovies(@RequestBody List<String> data)
    {
        List<Movie> movies = null;
        String search = data.get(0);
        String filter = data.get(1);
        String filterValue = data.get(2);
        if(search != "" && filter != "" && filterValue != "")
        {
            movies = iMovieService.findBySearchFiltered(search,filter, filterValue);
        }
        else if(search == "" && filter != "" && filterValue != "")
        {
            movies = iMovieService.findByFilter(filter, filterValue);
        }
        else if(search != "" && filter == "" && filterValue == "")
        {
            movies = iMovieService.findBySearch(search);
        }
        else {
            movies = iMovieService.findAll();
        }
        return movies;        
    }
    
    @PostMapping(consumes = "application/json", produces = "application/json")
    public Movie createMovie( @RequestBody Movie movie )
    {
        System.out.println(movie);
        Movie createdMovie = iMovieService.saveOrUpdate(movie);
        return createdMovie;
    }
    
    @PutMapping(consumes="application/json", produces="application/json")
    public Movie updateMovie( @RequestBody Movie movie )
    {
        Movie updatedMovie = iMovieService.saveOrUpdate(movie);
        return updatedMovie;
    }
    
    @DeleteMapping(value="/{id}")
    public void deleteMovie( @PathVariable long id )
    {
        iMovieService.deleteById(id);
    }
    
    @PostMapping(value = "/multiple",consumes = "application/json", produces = "application/json")
    public void deleteMultipleMovies( @RequestBody List<Long> id )
    {
        iMovieService.deleteAllById(id);
    }
}
