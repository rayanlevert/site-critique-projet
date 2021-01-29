package fr.dawan.sitecritiqueprojet.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.sitecritiqueprojet.beans.Review;
import fr.dawan.sitecritiqueprojet.dto.ReviewDto;
import fr.dawan.sitecritiqueprojet.repositories.ReviewRepository;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	@Override
	public ReviewDto findById(long id) {
		Optional<Review> reviewOpt = reviewRepository.findById(id);
		ModelMapper m = new ModelMapper();
		if (reviewOpt.isPresent()) {
			return m.map(reviewOpt.get(), ReviewDto.class);
		} else {
			return null;
		}

	}

	@Override
	public List<ReviewDto> findReviewByUserId(long id) {
		try {
			List<Review> listReviews = reviewRepository.findReviewByUserId(id);
			List<ReviewDto> rd = new ArrayList<ReviewDto>();
			ModelMapper m = new ModelMapper();
			for (Review r : listReviews) {
				rd.add(m.map(r, ReviewDto.class));
			}
			return rd;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erreur lors de la récupération des films");
			return null;
		}
	}

	@Override
	public List<ReviewDto> findReviewByArticleId(long id) {
		try {
			List<Review> listReviews = reviewRepository.findReviewByArticleId(id);
			List<ReviewDto> rd = new ArrayList<ReviewDto>();
			ModelMapper m = new ModelMapper();
			for (Review r : listReviews) {
				rd.add(m.map(r, ReviewDto.class));
			}
			return rd;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erreur lors de la récupération des films");
			return null;
		}
	}

	@Override
	public Review saveOrUpdate(Review r) {
		return reviewRepository.saveAndFlush(r);
	}

	@Override
	public void deleteById(long id) {
		reviewRepository.deleteById(id);
	}

}
