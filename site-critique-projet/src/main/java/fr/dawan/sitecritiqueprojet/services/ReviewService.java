package fr.dawan.sitecritiqueprojet.services;

import java.util.List;

import fr.dawan.sitecritiqueprojet.beans.Review;

public interface ReviewService {

	Review findById(long id);
	List<Review> findReviewByUserId(long id);
	List<Review> findReviewByArticleId(long id);
	Review saveOrUpdate(Review r);
    void deleteById(long id);
}
