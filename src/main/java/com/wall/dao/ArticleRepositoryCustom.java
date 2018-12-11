package com.wall.dao;

import java.util.List;

import com.wall.dto.PageRequest;
import com.wall.entities.Article;

public interface ArticleRepositoryCustom {

	List<Article> getPagedList(PageRequest pageRequest);
}
