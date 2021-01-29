package fr.dawan.sitecritiqueprojet.services;

import java.util.List;

import fr.dawan.sitecritiqueprojet.beans.Review;

public interface ReviewService {

	public Review findById(long id);
	public List<Review> findReviewByUserId(long id);
	public List<Review> findReviewByArticleId(long id);
}
