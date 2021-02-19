package fr.dawan.sitecritiqueprojet.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dawan.sitecritiqueprojet.beans.Movie;
import fr.dawan.sitecritiqueprojet.repositories.MovieRepository;
@Service
@Transactional
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;
    @Override
    public List<Movie> findAll() {
        try {
            List<Movie> movies = movieRepository.findAll();
            if(movies.isEmpty())
            {
                System.out.println("Aucun film disponible");
                return null;
            }
            else {
                return movies; 
            }       
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la récupération des films");
            return null;
        }   
    }
    @Override
    public Movie findOneById(long id)
    {
        Movie movie;
        
        try {
            Optional<Movie> movieOpt = movieRepository.findById(id);
            movie = movieOpt.get();
        } catch (Exception e) {
            e.printStackTrace();
            movie = null;
        }
        return movie;
    }
    @Override
    public Movie saveOrUpdate(Movie movie) {
        System.out.println(movie);
        movieRepository.saveAndFlush(movie);
        return movie;
    }
    @Override
    public boolean deleteById(long id) {
        try {
           movieRepository.deleteById(id);
           return true; 
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    @Override
    public boolean deleteAllById(List<Long> id) {
        boolean res = false;
        try {
            for (long l : id) {
                movieRepository.deleteById(l);                
            }
            res = true;   
        }
        catch (Exception e) {
            e.printStackTrace();
            res = false;
        }
        return res;
    }
    
    public List<Movie> findBySearchFiltered(String search,String filter, String filterValue) {
        List<Movie> movies = null;
        try {
            switch (filter) {
            case "genre": movies = movieRepository.searchByGenre(search, filterValue);
                break;
            case "realisator": movies = movieRepository.searchByReal(search, filterValue);
                break;
            case "actor": movies = movieRepository.searchByActor(search, filterValue);
                break;
            case "duration": movies = movieRepository.searchByDuration(search, filterValue);
                break;
            case "nationality": movies = movieRepository.searchByNationality(search, filterValue);
                break;
            default:
                movies = movieRepository.searchByAll(search);
                break;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return movies;
    }
    @Override
    public List<Movie> findByFilter(String filter, String filterValue) {
        List<Movie> movies = null;
        try {
            switch (filter) {
            case "genre": movies = movieRepository.findByGenre(filterValue);
                break;
            case "realisator": movies = movieRepository.findByReal(filterValue);
                break;
            case "actor": movies = movieRepository.findByActor(filterValue);
                break;
            case "duration": movies = movieRepository.findByDuration(filterValue);
                break;
            case "nationality": movies = movieRepository.findByNationality(filterValue);
                break;
            default:
                movies = movieRepository.findAll();
                break;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return movies;
    }
    @Override
    public List<Movie> findBySearch(String search) {
        List<Movie> movies = null;
        try {
            movies = movieRepository.searchByAll(search);
            }
        catch (Exception e) {
            e.printStackTrace();
        }
        return movies;
    }
    @Override
    public List<Movie> findAll(int page, int i) {
        List<Movie> movies = null;
        try {
            movies = movieRepository.findAll(PageRequest.of(page, i)).get().collect(Collectors.toList());
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        return movies;
    }
    
}
