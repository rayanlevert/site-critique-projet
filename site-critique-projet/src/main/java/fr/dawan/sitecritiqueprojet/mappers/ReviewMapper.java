package fr.dawan.sitecritiqueprojet.mappers;
import org.modelmapper.ModelMapper;
import fr.dawan.sitecritiqueprojet.beans.Review;
import fr.dawan.sitecritiqueprojet.dto.ReviewDto;

public class ReviewMapper {
	private ModelMapper mapper;
	
	public ReviewMapper() {
		mapper = new ModelMapper();
	}
	
	public  ReviewDto toDto(Review r) {
		mapper.typeMap(Review.class, ReviewDto.class).addMappings(mapper -> {
			mapper.map(src->src.getIdReview(),ReviewDto::setIdReview);
			mapper.map(src->src.getTitleReview(), ReviewDto::setTitleReview);
			mapper.map(src->src.getContentReview(), ReviewDto::setContentReview);
			mapper.map(src->src.getNoteReview(), ReviewDto::setNoteReview);
			mapper.map(src->src.getUser().getId(), ReviewDto::setUserId);
			mapper.map(src->src.getArticle().getId(), ReviewDto::setArticleId);
		});
		return mapper.map(r, ReviewDto.class);
	}
	
	public  Review fromDto(ReviewDto rDto) {
		mapper.typeMap(ReviewDto.class, Review.class).addMappings(mapper -> {
			mapper.map(src->src.getIdReview(), Review::setIdReview);
			mapper.map(src->src.getTitleReview(), Review::setTitleReview);
			mapper.map(src->src.getContentReview(), Review::setContentReview);
			mapper.map(src->src.getNoteReview(), Review::setNoteReview);
			mapper.map(src->src.getUserId(), Review::setUser);
			mapper.map(src->src.getArticleId(), Review::setArticle);
		});
		return mapper.map(rDto, Review.class);
	}
}
