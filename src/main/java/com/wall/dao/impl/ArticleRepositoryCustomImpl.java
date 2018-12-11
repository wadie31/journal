package com.wall.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wall.dao.ArticleRepositoryCustom;
import com.wall.dto.PageRequest;
import com.wall.entities.Article;


@Repository
@Transactional
public class ArticleRepositoryCustomImpl implements ArticleRepositoryCustom {

	@Autowired EntityManager em;
	
	@Override
	public List<Article> getPagedList(PageRequest pageRequest) {
		final Query query = em.createQuery("From Article");
	    query.setFirstResult((pageRequest.getPage()-1) * pageRequest.getTotalItems()); 
	    query.setMaxResults(pageRequest.getTotalItems());
		final List <Article> articles = query.getResultList();
		return articles;
	}

}
