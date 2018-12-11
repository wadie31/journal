package com.wall.dto;

import java.util.List;

import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wall.entities.Article;
import com.wall.entities.Commentaire;
import com.wall.entities.User;

public class CommentDto {

	
String commentaire;
	
	
	User user;
	

	Article article;


	public String getCommentaire() {
		return commentaire;
	}


	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
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
