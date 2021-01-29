package fr.dawan.sitecritiqueprojet.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.sitecritiqueprojet.beans.Commentary;
import fr.dawan.sitecritiqueprojet.dto.CommentaryDto;
import fr.dawan.sitecritiqueprojet.repositories.CommentaryRepository;

@Service
@Transactional
public class CommentaryServiceImpl implements CommentaryService {

	@Autowired
	private CommentaryRepository commentaryRepository;

	@Override
	public CommentaryDto findById(long id) {
		Optional<Commentary> commentaryOpt = commentaryRepository.findById(id);
		ModelMapper m = new ModelMapper();
		if (commentaryOpt.isPresent()) {
			return m.map(commentaryOpt.get(), CommentaryDto.class);
		} else {
			return null;
		}

	}

	@Override
	public List<CommentaryDto> findCommentaryByUserId(long id) {
		try {
			List<Commentary> listComments = commentaryRepository.findCommentaryByUserId(id);
			List<CommentaryDto> cDto = new ArrayList<CommentaryDto>();
			ModelMapper m = new ModelMapper();
			for (Commentary c : listComments) {
				cDto.add(m.map(c, CommentaryDto.class));
			}
			return cDto;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erreur lors de la récupération des films");
			return null;
		}
	}

	@Override
	public List<CommentaryDto> findCommentaryByReviewId(long id) {
		try {
			List<Commentary> listComments = commentaryRepository.findCommentaryByReviewId(id);
			List<CommentaryDto> cDto = new ArrayList<CommentaryDto>();
			ModelMapper m = new ModelMapper();
			for (Commentary c : listComments) {
				cDto.add(m.map(c, CommentaryDto.class));
			}
			return cDto;
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
