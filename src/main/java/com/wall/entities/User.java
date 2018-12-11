package com.wall.entities;



import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "user")
public class User implements Serializable {
	
	@Id
    @GeneratedValue
    private Integer id;
    private String login;
    private String nom;
    private String prenom;
    private String password;
   
    
    
	public Integer getIdUser() {
		return id;
	}
	public void setIdUser(Integer idUser) {
		this.id = idUser;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
   
}