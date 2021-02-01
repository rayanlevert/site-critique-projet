package fr.dawan.sitecritiqueprojet.services;

import java.util.List;

import fr.dawan.sitecritiqueprojet.beans.Movie;

public interface MovieService {

    //basic find JPA
    public List<Movie> findAll();
    public Movie findOneById(long id);
    
    /* CRUD */
    public Movie saveOrUpdate(Movie movie);
    public boolean deleteById(long id);
    public boolean deleteAllById(List<Long> id);
    
    //search
    public List<Movie> findBySearchFiltered(String search, String filter,String FilterValue);
    public List<Movie> findByFilter(String filter, String filterValue);
    public List<Movie> findBySearch(String search);
}
