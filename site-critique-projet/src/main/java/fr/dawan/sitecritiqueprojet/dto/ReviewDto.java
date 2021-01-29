package fr.dawan.sitecritiqueprojet.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import fr.dawan.sitecritiqueprojet.beans.Article;
import fr.dawan.sitecritiqueprojet.beans.User;

public class ReviewDto implements Serializable{

	private static final long serialVersionUID = 1L;
	private long idReview;
	private String titleReview;
	private String contentReview;
	private int noteReview;
	private Date publishDate;
	private long userId;
	private long articleId;

	public long getIdReview() {
		return idReview;
	}

	public void setIdReview(long idReview) {
		this.idReview = idReview;
	}

	public String getTitleReview() {
		return titleReview;
	}

	public void setTitleReview(String titleReview) {
		this.titleReview = titleReview;
	}

	public String getContentReview() {
		return contentReview;
	}

	public void setContentReview(String contentReview) {
		this.contentReview = contentReview;
	}

	public int getNoteReview() {
		return noteReview;
	}

	public void setNoteReview(int noteReview) {
		this.noteReview = noteReview;
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

	public long getArticleId() {
		return articleId;
	}

	public void setArticleId(long articleId) {
		this.articleId = articleId;
	}

}
