package fr.dawan.sitecritiqueprojet.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import fr.dawan.sitecritiqueprojet.beans.Movie;
import fr.dawan.sitecritiqueprojet.services.IMovieService;
@Controller
public class MovieController {

    @Autowired
    private IMovieService iMovieService;
    
    @GetMapping("/movies")
    @ResponseBody
    @JsonSerialize
    public List<Movie> getMovies()
    {
        List<Movie> movies = iMovieService.findAll();
        /*
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("movies", movies);

        return new ModelAndView("Movies", params);
        */
        return movies;
    }
    
    @RequestMapping("/movie/{id}")
    @ResponseBody
    @JsonSerialize
    public Movie getMovie(@PathVariable("id") long id)
    {
        Movie movie = iMovieService.findOneById(id);
        return movie;
    }
}
