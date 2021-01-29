package fr.dawan.sitecritiqueprojet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.dawan.sitecritiqueprojet.beans.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

    
    
    
    
}
