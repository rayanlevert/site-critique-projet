package fr.dawan.sitecritiqueprojet.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Review {

	private long idReview;
	private String titleReview;
	private String contentReview;
	private int noteReview;
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	@ManyToOne(cascade = CascadeType.ALL)
	private Article article;

	public Review() {
	}

	public Review(long idReview, String titleReview, String contentReview, int noteReview, User user, Article article) {
		this.idReview = idReview;
		this.titleReview = titleReview;
		this.contentReview = contentReview;
		this.noteReview = noteReview;
		this.user = user;
		this.article = article;
	}

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

}
