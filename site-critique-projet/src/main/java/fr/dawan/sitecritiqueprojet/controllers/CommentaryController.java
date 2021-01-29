package fr.dawan.sitecritiqueprojet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.sitecritiqueprojet.beans.Commentary;
import fr.dawan.sitecritiqueprojet.services.CommentaryService;

@RestController
@RequestMapping("/api/comments")
public class CommentaryController {

	@Autowired
	private CommentaryService commentaryService;

	@GetMapping(value = "/commentary/{id}", produces = "application/json")
	public Commentary getCommentary(@PathVariable("id") long id) {
		Commentary commentary = commentaryService.findById(id);
		return commentary;
	}

	@GetMapping(value = "/user/{id}" , produces = "application/json")
	public List<Commentary> getCommentsByUserId(@PathVariable("id") long id){
		return commentaryService.findCommentaryByUserId(id);
	}
	
	@GetMapping(value = "/review/{id}", produces = "application/json")
	public List<Commentary> getCommentsByReviewId(@PathVariable("id") long id){
		return commentaryService.findCommentaryByReviewId(id);
	}
}
