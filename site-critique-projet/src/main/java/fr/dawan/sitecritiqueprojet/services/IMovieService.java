package fr.dawan.sitecritiqueprojet.services;

import java.util.List;

import fr.dawan.sitecritiqueprojet.beans.Movie;

public interface IMovieService {

    public List<Movie> findAll();
    public Movie findOneById(long id);
}
