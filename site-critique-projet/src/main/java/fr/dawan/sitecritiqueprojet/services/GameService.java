package fr.dawan.sitecritiqueprojet.services;

import java.util.List;

import fr.dawan.sitecritiqueprojet.beans.Game;
public interface GameService {
    
    public List<Game> findAll();
    public Game findOneById(long id);
    
    /* CRUD */
    public Game saveOrUpdate(Game game);
    public boolean deleteById(long id);
    public boolean deleteAllById(List<Long> id);
       
    //search
    public List<Game> findBySearchFiltered(String search, String filter,String FilterValue);
    public List<Game> findByFilter(String filter, String filterValue);
    public List<Game> findBySearch(String search);
}
