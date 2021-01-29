package fr.dawan.sitecritiqueprojet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.dawan.sitecritiqueprojet.beans.Commentary;
@Repository
public interface CommentaryRepository extends JpaRepository<Commentary, Long> {

	@Query(value = "FROM Commentary c WHERE c.user.id = :idUser")
	List<Commentary> findCommentaryByUserId(@Param("idUser")long id);
	
	@Query(value = "FROM Commentary c WHERE c.review.idReview = :idReview")
	List<Commentary> findCommentaryByReviewId(@Param("idReview")long id);
}
