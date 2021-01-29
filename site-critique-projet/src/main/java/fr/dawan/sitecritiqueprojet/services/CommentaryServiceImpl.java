package fr.dawan.sitecritiqueprojet.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.sitecritiqueprojet.beans.Commentary;
import fr.dawan.sitecritiqueprojet.repositories.CommentaryRepository;

@Service
@Transactional
public class CommentaryServiceImpl implements CommentaryService {
	
	@Autowired
	private CommentaryRepository commentaryRepository;

	@Override
	public Commentary findById(long id) {
		Commentary commentary;

		try {
			Optional<Commentary> commentaryOpt = commentaryRepository.findById(id);
			commentary = commentaryOpt.get();
		} catch (Exception e) {
			e.printStackTrace();
			commentary = null;
		}
		return commentary;
	}

	@Override
	public List<Commentary> findCommentaryByUserId(long id) {
		try {
			Iterable<Commentary> comments = commentaryRepository.findCommentaryByUserId(id);
			if(((List<Commentary>) comments).isEmpty()) {
				System.out.println("Aucun commentaire disponible");
				return null;
			}else {
				return (List<Commentary>) comments;
			}
		} catch (Exception e) {
			e.printStackTrace();
            System.out.println("Erreur lors de la récupération des films");
            return null;
		}
	}

	@Override
	public List<Commentary> findCommentaryByReviewId(long id) {
		try {
			Iterable<Commentary> comments = commentaryRepository.findCommentaryByReviewId(id);
			if(((List<Commentary>) comments).isEmpty()) {
				System.out.println("Aucune critique disponible");
				return null;
			}else {
				return (List<Commentary>) comments;
			}
		} catch (Exception e) {
			e.printStackTrace();
            System.out.println("Erreur lors de la récupération des films");
            return null;
		}
	}

	@Override
	public Commentary saveOrUpdate(Commentary c) {
		return commentaryRepository.saveAndFlush(c);
	}

	@Override
	public void deleteById(long id) {
		commentaryRepository.deleteById(id);
	}
}
