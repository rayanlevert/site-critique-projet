package fr.dawan.sitecritiqueprojet.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.sitecritiqueprojet.beans.Review;
import fr.dawan.sitecritiqueprojet.repositories.ReviewRepository;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	@Override
	public Review findById(long id) {
		Review review;

		try {
			Optional<Review> reviewOpt = reviewRepository.findById(id);
			review = reviewOpt.get();
		} catch (Exception e) {
			e.printStackTrace();
			review = null;
		}
		return review;
	}

	@Override
	public List<Review> findReviewByUserId(long id) {
		try {
			Iterable<Review> reviews = reviewRepository.findReviewByUserId(id);
			if(((List<Review>) reviews).isEmpty()) {
				System.out.println("Aucune critique disponible");
				return null;
			}else {
				return (List<Review>) reviews;
			}
		} catch (Exception e) {
			e.printStackTrace();
            System.out.println("Erreur lors de la récupération des films");
            return null;
		}
	}

	@Override
	public List<Review> findReviewByArticleId(long id) {
		try {
			Iterable<Review> reviews = reviewRepository.findReviewByArticleId(id);
			if(((List<Review>) reviews).isEmpty()) {
				System.out.println("Aucune critique disponible");
				return null;
			}else {
				return (List<Review>) reviews;
			}
		} catch (Exception e) {
			e.printStackTrace();
            System.out.println("Erreur lors de la récupération des films");
            return null;
		}
	}

}
