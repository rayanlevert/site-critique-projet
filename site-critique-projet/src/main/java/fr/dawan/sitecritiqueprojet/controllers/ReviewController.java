package fr.dawan.sitecritiqueprojet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.sitecritiqueprojet.beans.Review;
import fr.dawan.sitecritiqueprojet.dto.ReviewDto;
import fr.dawan.sitecritiqueprojet.services.ReviewService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	@GetMapping(value = "/review/{id}", produces = "application/json")
	public ReviewDto getReview(@PathVariable("id") long id){
		ReviewDto review = reviewService.findById(id);
		return review;
	}
	
	@GetMapping(value = "/user/{id}", produces ="application/json")
	public List<ReviewDto> getReviewsByUserId(@PathVariable("id") long id){
		return reviewService.findReviewByUserId(id);
	}
	
	@GetMapping(value = "/article/{id}", produces ="application/json")
	public List<ReviewDto> getReviewsByArticleId(@PathVariable("id") long id){
		return reviewService.findReviewByArticleId(id);
	}
	
	//@PostMapping(consumes = "application/json", produces = "application/json")
	//@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/create")
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
	public Review createReview(@RequestBody Review r) {
		System.out.println("create -------------------------------");
		return reviewService.saveOrUpdate(r);
	}
	
	//@PutMapping(consumes = "application/json", produces = "application/json")
	@RequestMapping(value = "/update/{id}",consumes = "application/json", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Review> updateReview(@RequestBody Review r,@PathVariable long id) {
		return reviewService.update(r, id);
	}
	
	@DeleteMapping(value = "/review/{id}", produces = "text/plain")
	public String deleteReviewById(@PathVariable("id") long id) {
		try {
			reviewService.deleteById(id);
			return "Suppr ok";
		}catch(Exception e) {
			e.printStackTrace();
			return "Erreur : " + e.getMessage();
		}
	}
}

