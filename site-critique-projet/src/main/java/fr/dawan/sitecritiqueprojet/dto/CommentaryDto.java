package fr.dawan.sitecritiqueprojet.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "commentary")
@XmlAccessorType(XmlAccessType.FIELD)
public class CommentaryDto {
	
	@XmlAttribute
	private long idComment;
	@XmlElement
	private String contentComment;
	@XmlElement
	private Date publishDate;
	@XmlElement
	private String userUsername;
	@XmlElement
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
	public String getUserUsername() {
		return userUsername;
	}
	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}
	public long getReviewIdReview() {
		return reviewIdReview;
	}
	public void setReviewIdReview(long reviewIdReview) {
		this.reviewIdReview = reviewIdReview;
	}
	
	
}
