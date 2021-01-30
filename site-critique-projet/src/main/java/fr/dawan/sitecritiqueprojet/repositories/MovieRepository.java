package fr.dawan.sitecritiqueprojet.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import fr.dawan.sitecritiqueprojet.beans.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT m from Movie m where m.title LIKE %:search% AND m.genre = :filterValue")
    List<Movie> searchByGenre(String search, String filterValue);
    
    
    @Query("SELECT m from Movie m where m.title LIKE %:search%")
    List<Movie> searchByAll(String search);

    @Query("SELECT m from Movie m where m.title LIKE %:search% AND m.realisator = :filterValue")
    List<Movie> searchByReal(String search, String filterValue);

    @Query("SELECT m from Movie m where m.title LIKE %:search% AND m.genre LIKE %:filterValue%")
    List<Movie> searchByActor(String search, String filterValue);

    @Query("SELECT m from Movie m where m.title LIKE %:search% AND m.duration = :filterValue")
    List<Movie> searchByDuration(String search, String filterValue);

    @Query("SELECT m from Movie m where m.title LIKE %:search% AND m.nationality LIKE %:filterValue%")
    List<Movie> searchByNationality(String search, String filterValue);

    @Query("SELECT m from Movie m where m.genre = :filterValue")
    List<Movie> findByGenre(String filterValue);

    @Query("SELECT m from Movie m where m.realisator = :filterValue")
    List<Movie> findByReal(String filterValue);

    @Query("SELECT m from Movie m where m.genre LIKE %:filterValue%")
    List<Movie> findByActor(String filterValue);

    @Query("SELECT m from Movie m where m.duration = :filterValue")
    List<Movie> findByDuration(String filterValue);

    @Query("SELECT m from Movie m where m.nationality LIKE %:filterValue%")
    List<Movie> findByNationality(String filterValue);
}
