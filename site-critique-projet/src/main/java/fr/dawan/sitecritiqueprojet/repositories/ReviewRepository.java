package fr.dawan.sitecritiqueprojet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.dawan.sitecritiqueprojet.beans.Review;
@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
	
	@Query(value = "FROM Review r WHERE r.idReview = :idReview")
	Review findById(@Param("idReview")long id);
	
	@Query(value = "FROM Review r WHERE r.user.id = :idUser")
	List<Review> findByUserId(@Param("idUser")long id);
	
	@Query(value = "FROM Review r FROM r.article.id = :idArticle")
	List<Review> findByArticleId(@Param("idArticle")long id);
}
