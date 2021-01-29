package fr.dawan.sitecritiqueprojet.services;

import fr.dawan.sitecritiqueprojet.beans.Review;

public interface ReviewService {

	Review findById(long id);
	Review findByUserId(long id);
	Review findByArticleId(long id);
}
