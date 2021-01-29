package fr.dawan.sitecritiqueprojet.services;

import java.util.List;

import fr.dawan.sitecritiqueprojet.beans.Commentary;

public interface CommentaryService {
	
	Commentary findById(long id);
	List<Commentary> findCommentaryByUserId(long id);
	List<Commentary> findCommentaryByReviewId(long id);
	Commentary saveOrUpdate(Commentary c);
    void deleteById(long id);
}
