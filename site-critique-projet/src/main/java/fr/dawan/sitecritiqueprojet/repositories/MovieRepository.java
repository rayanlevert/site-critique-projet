package fr.dawan.sitecritiqueprojet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import fr.dawan.sitecritiqueprojet.beans.Movie;

public interface MovieRepository extends CrudRepository<Movie, Long> {
    
    

}
