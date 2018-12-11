package com.wall.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Timed;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wall.dao.ArticleRepository;
import com.wall.dao.ArticleRepositoryCustom;
import com.wall.dao.CommentRepository;
import com.wall.dao.UserRepository;
import com.wall.dto.CommentDto;
import com.wall.dto.PageRequest;
import com.wall.entities.Article;
import com.wall.entities.Commentaire;
import com.wall.entities.User;
import com.wall.mapper.PaginationUtil;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class JournalRestController {
	
	@Autowired private UserRepository userRepository;
	
	@Autowired private ArticleRepository articleRepository;
	
	@Autowired private CommentRepository commentaireRepository;
	
	@Autowired private ArticleRepositoryCustom articleRepositoryCustom;
	
	 @RequestMapping(produces = {"application/json"},consumes={MediaType.MULTIPART_FORM_DATA_VALUE,MediaType.APPLICATION_JSON_VALUE} ,value = "/addArticle", method = RequestMethod.POST)
	 public void addArticle(@RequestParam("file") MultipartFile filedata ,@RequestParam("user") String user, @RequestParam("title") String title, @RequestParam("text") String text) throws IOException  {
		 User u = new User();
		 byte[] bytes = filedata.getBytes();
		 Article article = new Article();
		 article.setPicture(bytes);
		 article.setText(text);
		 article.setTitle(title);
		 u.setIdUser(Integer.parseInt(user));
		 article.setUser(u);;
		 
		 Article a = articleRepository.save(article);
	 }
	
	
	 @RequestMapping(value = "/allArticles", method = RequestMethod.GET)
	    public List<Article> allArticles()  {
        List<Article> listArticles = articleRepository.findAll();
        return listArticles;		  
		
	 }
	 
	 @RequestMapping(value = "/articles", method = RequestMethod.GET)
	 public ResponseEntity<List<Article>> getAllRepos(Pageable pageable)
	     throws URISyntaxException {
	     Slice<Article> slice = articleRepository.findSliceBy(pageable);
	     HttpHeaders headers = PaginationUtil.generateSliceHttpHeaders(slice);
	     return new ResponseEntity<>(slice.getContent(), headers, HttpStatus.OK);
	 }
	 
	 @RequestMapping(value = "/comment", method = RequestMethod.POST)
	    public boolean comment(@RequestBody CommentDto commentDto)  {
		 Commentaire com = new Commentaire();
		 com.setArticle(commentDto.getArticle());
		 com.setUser(commentDto.getUser());
		 com.setCommentaire(commentDto.getCommentaire());
		 Commentaire comment = commentaireRepository.save(com);
         if(comment!=null) 
		 return true;
         else
        	 return false;
	 }
	 
	 @RequestMapping(value = "/paginate", method = RequestMethod.POST)
	    public List<Article> paginate(@RequestBody PageRequest pg)  {
		 List<Article> listArticles = articleRepositoryCustom.getPagedList(pg);
         return listArticles;		  
	 }
}
