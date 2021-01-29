package fr.dawan.sitecritiqueprojet.dto;

import java.util.Date;

public class CommentaryDto {

	private long idComment;
	private String contentComment;
	private Date publishDate;
	private long userId;
	private long reviewIdReview;

	public long getIdComment() {
		return idComment;
	}

	public void setIdComment(long idComment) {
		this.idComment = idComment;
	}

	public String getContentComment() {
		return contentComment;
	}

	public void setContentComment(String contentComment) {
		this.contentComment = contentComment;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getReviewIdReview() {
		return reviewIdReview;
	}

	public void setReviewIdReview(long reviewIdReview) {
		this.reviewIdReview = reviewIdReview;
	}

}
