package com.wall.dao;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

import com.wall.entities.Article;
import com.wall.entities.User;


public interface ArticleRepository extends JpaRepository<Article, Integer> {
public List<Article> findAll();
  public Article findByTitle(String title);
  Slice<Article> findSliceBy(Pageable pageable);
}