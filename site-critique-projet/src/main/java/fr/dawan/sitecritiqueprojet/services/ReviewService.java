package fr.dawan.sitecritiqueprojet.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import fr.dawan.sitecritiqueprojet.beans.Review;
import fr.dawan.sitecritiqueprojet.dto.ReviewDto;

public interface ReviewService {

	ReviewDto findById(long id);
	List<ReviewDto> findReviewByUserId(long id);
	List<ReviewDto> findReviewByArticleId(long id);
	Review saveOrUpdate(Review r);
    void deleteById(long id);
    ResponseEntity<Review> update(Review r,long id);
}
