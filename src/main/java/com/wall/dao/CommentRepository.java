package com.wall.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wall.entities.Commentaire;


public interface CommentRepository extends JpaRepository<Commentaire, Integer> {
public List<Commentaire> findByArticle(int idarticle);
public Commentaire findById(Integer idCommentaire);
}