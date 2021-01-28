package fr.dawan.sitecritiqueprojet.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.sitecritiqueprojet.repositories.CommentaryRepository;

@Service
@Transactional
public class CommentaryServiceImpl implements CommentaryService {
	
	@Autowired
	private CommentaryRepository CommentaryRepository;
}
