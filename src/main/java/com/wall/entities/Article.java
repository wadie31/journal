package com.wall.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "article")
public class Article implements Serializable {
	@Id
    @GeneratedValue
	Integer id;
	String title;
	String text;
	byte[] picture;
	@ManyToOne
	@JsonProperty
	User user;
	
	@OneToMany(targetEntity=Commentaire.class, mappedBy="article", fetch=FetchType.EAGER)
	List<Commentaire> commentaires;
	
	
	
	public Integer getId() {
		return id;
	}
	
	

	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public void setId(Integer id) {
		this.id = id;
	}
	
	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommenaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	
	public Integer getIdArticle() {
		return id;
	}
	public void setIdArticle(Integer idArticle) {
		this.id = idArticle;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public byte[] getPicture() {
		return picture;
	}
	public void setPicture(byte[] image) {
		this.picture = image;
	}
	
	
	

}
