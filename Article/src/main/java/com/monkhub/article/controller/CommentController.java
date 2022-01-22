package com.monkhub.article.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.monkhub.article.entity.Article;
import com.monkhub.article.entity.Comment;
import com.monkhub.article.service.ArticleService;
import com.monkhub.article.service.CommentService;

@RestController
public class CommentController {

	@Autowired
	private CommentService commentService;

	@Autowired
	private ArticleService articleService;

	@GetMapping("getComments")
	public List<Comment> getComments() {
		return commentService.getComments();
	}

	@GetMapping("getCommentsByArticleId/{articleId}")
	public List<Comment> getCommentsByArticleId(@PathVariable int articleId) {
		if (articleService.articleExistsById(articleId)) {
			return commentService.getCommentsByArticleId(articleId);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No article found with id - " + articleId);
		}
	}

	@PostMapping("/{articleId}/saveComment")
	public Comment saveComment(@PathVariable int articleId, @RequestBody Comment comment) {
		if (articleService.articleExistsById(articleId)) {
			Article article = articleService.getArticleById(articleId);
			comment.setArticle(article);
			comment.setArticleId(article.getId());
			comment.setArticleTitle(article.getTitle());
			commentService.saveComment(comment);
			return comment;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No article found with id - " + articleId);
		}
	}

}
