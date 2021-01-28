package fr.dawan.sitecritiqueprojet.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "review")
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idReview;
	@Column(name = "titleReview", length = 255, nullable = false)
	private String titleReview;
	@Column(name = "contentReview", nullable = false, columnDefinition = "TEXT")
	private String contentReview;
	@Column(name = "noteReview", nullable = false)
	private int noteReview;
	@Column(name = "publishDate")
	private Date publishDate;
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	@ManyToOne(cascade = CascadeType.ALL)
	private Article article;

	public Review() {
	}

	public Review(long idReview, String titleReview, String contentReview, int noteReview, Date publishDate, User user,
			Article article) {
		this.idReview = idReview;
		this.titleReview = titleReview;
		this.contentReview = contentReview;
		this.noteReview = noteReview;
		this.publishDate = publishDate;
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

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

}
