package fr.dawan.sitecritiqueprojet.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Commentary {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idComment;
	@Column(name = "contentComment",  nullable = false, columnDefinition = "TEXT")
	private String contentComment;
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	@ManyToOne(cascade = CascadeType.ALL)
	private Review review;

	public Commentary() {
	}

	public Commentary(long idComment, String contentComment, User user, Review review) {
		this.idComment = idComment;
		this.contentComment = contentComment;
		this.user = user;
		this.review = review;
	}

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}

}
