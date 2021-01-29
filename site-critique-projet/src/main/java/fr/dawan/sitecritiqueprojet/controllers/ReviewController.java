package fr.dawan.sitecritiqueprojet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.sitecritiqueprojet.beans.Review;
import fr.dawan.sitecritiqueprojet.services.ReviewService;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	@GetMapping(value = "/review/{id}", produces = "application/json")
	public Review getReview(@PathVariable("id") long id){
		Review review = reviewService.findById(id);
		return review;
	}
	
	@GetMapping(value = "/user/{id}", produces ="application/json")
	public List<Review> getReviewsByUserId(@PathVariable("id") long id){
		return reviewService.findReviewByUserId(id);
	}
	
	@GetMapping(value = "/article/{id}", produces ="application/json")
	public List<Review> getReviewsByArticleId(@PathVariable("id") long id){
		return reviewService.findReviewByArticleId(id);
	}
}

