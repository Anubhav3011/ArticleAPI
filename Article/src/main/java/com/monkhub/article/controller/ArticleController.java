package com.monkhub.article.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.monkhub.article.entity.Article;
import com.monkhub.article.service.ArticleService;

@RestController
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	@GetMapping("getArticles")
	public List<Article> getArticles() {
		return articleService.getArticles();
	}

	@GetMapping("getArticleById/{articleId}")
	public Article getArticleById(@PathVariable int articleId) {
		try {
			return articleService.getArticleById(articleId);
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No article found with id - " + articleId);
		}
	}

	@PostMapping("saveArticle")
	public Article saveArticle(@RequestBody Article article) {
		articleService.saveArticle(article);
		return article;
	}

}
