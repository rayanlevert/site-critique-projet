package fr.dawan.sitecritiqueprojet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.dawan.sitecritiqueprojet.beans.Game;


public interface GameRepository extends JpaRepository<Game, Long> {
    
    
    //simple search
    @Query("SELECT g from Game g where g.title LIKE %:search%")
    List<Game> searchByAll(String search);
    
    //search with filters
    
    @Query("SELECT g from Game g where g.title LIKE %:search% AND g.genre = :filterValue")
    List<Game> searchByGenre(String search, String filterValue);
    @Query("SELECT g from Game g where g.title LIKE %:search% AND g.developer = :filterValue")
    List<Game> searchByDev(String search, String filterValue);
    @Query("SELECT g from Game g where g.title LIKE %:search% AND g.publisher LIKE %:filterValue%")
    List<Game> searchByPublisher(String search, String filterValue);
    @Query("SELECT g from Game g where g.title LIKE %:search% AND g.platform = :filterValue")
    List<Game> searchByPlatform(String search, String filterValue);
    @Query("SELECT g From Game g where g.title LIKE %:search% AND g.valid = :filterValue")
    List<Game> searchByValid(String search, String filterValue);
    
    //custom find requests
    
    @Query("SELECT g from Game g where g.genre = :filterValue")
    List<Game> findByGenre(String filterValue);
    @Query("SELECT g from Game g where g.developer = :filterValue")
    List<Game> findByDev(String filterValue);
    @Query("SELECT g from Game g where g.publisher LIKE %:filterValue%")
    List<Game> findByPublisher(String filterValue);
    @Query("SELECT g from Game g where g.platform = :filterValue")
    List<Game> findByPlatform(String filterValue);

}
