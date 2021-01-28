package fr.dawan.sitecritiqueprojet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.dawan.sitecritiqueprojet.beans.Review;
@Repository
public interface CommentaryRepository extends JpaRepository<Review, Long> {

}
