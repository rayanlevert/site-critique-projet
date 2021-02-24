package fr.dawan.sitecritiqueprojet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import fr.dawan.sitecritiqueprojet.beans.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    
    //simple search
    @Query("SELECT m from Movie m where m.title LIKE %:search%")
    List<Movie> searchByAll(String search);
    
    //search with filters
    
    @Query("SELECT m from Movie m where m.title LIKE %:search% AND m.genre LIKE %:filterValue% ORDER BY id DESC")
    List<Movie> searchByGenre(String search, String filterValue);

    @Query("SELECT m from Movie m where m.title LIKE %:search% AND m.realisator = :filterValue ORDER BY id DESC")
    List<Movie> searchByReal(String search, String filterValue);

    @Query("SELECT m from Movie m where m.title LIKE %:search% AND m.genre LIKE %:filterValue% ORDER BY id DESC")
    List<Movie> searchByActor(String search, String filterValue);

    @Query("SELECT m from Movie m where m.title LIKE %:search% AND m.duration = :filterValue ORDER BY id DESC")
    List<Movie> searchByDuration(String search, String filterValue);

    @Query("SELECT m from Movie m where m.title LIKE %:search% AND m.nationality LIKE %:filterValue% ORDER BY id DESC")
    List<Movie> searchByNationality(String search, String filterValue);
    
    
    //custom finds requests

    @Query("SELECT m from Movie m where m.genre = :filterValue ORDER BY id DESC")
    List<Movie> findByGenre(String filterValue);

    @Query("SELECT m from Movie m where m.realisator = :filterValue ORDER BY id DESC")
    List<Movie> findByReal(String filterValue);

    @Query("SELECT m from Movie m where m.genre LIKE %:filterValue% ORDER BY id DESC")
    List<Movie> findByActor(String filterValue);

    @Query("SELECT m from Movie m where m.duration = :filterValue ORDER BY id DESC")
    List<Movie> findByDuration(String filterValue);

    @Query("SELECT m from Movie m where m.nationality LIKE %:filterValue% ORDER BY id DESC")
    List<Movie> findByNationality(String filterValue);

}
