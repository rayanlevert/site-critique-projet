package fr.dawan.sitecritiqueprojet.services;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.dawan.sitecritiqueprojet.beans.Movie;
import fr.dawan.sitecritiqueprojet.repositories.MovieRepository;
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;
    @Override
    public List<Movie> findAll() {
        try {
            Iterable<Movie> movies = movieRepository.findAll();
            if(((List<Movie>) movies).isEmpty())
            {
                System.out.println("Aucun film disponible");
                return null;
            }
            else {
                return (List<Movie>) movies; 
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
}
