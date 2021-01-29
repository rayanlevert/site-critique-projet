package fr.dawan.sitecritiqueprojet.services;

import java.util.List;

import fr.dawan.sitecritiqueprojet.beans.Commentary;
import fr.dawan.sitecritiqueprojet.dto.CommentaryDto;

public interface CommentaryService {
	
	CommentaryDto findById(long id);
	List<CommentaryDto> findCommentaryByUserId(long id);
	List<CommentaryDto> findCommentaryByReviewId(long id);
	Commentary saveOrUpdate(Commentary c);
    void deleteById(long id);
}
