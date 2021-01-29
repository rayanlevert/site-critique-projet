package fr.dawan.sitecritiqueprojet.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.sitecritiqueprojet.beans.Review;
import fr.dawan.sitecritiqueprojet.repositories.ReviewRepository;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	private ReviewRepository ReviewRepository;

	@Override
	public Review findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Review findByUserId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Review findByArticleId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
