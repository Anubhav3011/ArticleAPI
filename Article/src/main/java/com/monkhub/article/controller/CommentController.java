package com.monkhub.article.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
	public Object getComments() {
		return commentService.getCommentsDTO(commentService.getComments());
	}

	@GetMapping("getCommentsByArticleId/{articleId}")
	public Object getCommentsByArticleId(@PathVariable Long articleId) {
		if (articleService.articleExistsById(articleId)) {
			return commentService.getCommentsDTO(commentService.getCommentsByArticleId(articleId));
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No article found with id - " + articleId);
		}
	}

	@PostMapping("/saveComment/{articleId}")
	public Comment saveComment(@PathVariable Long articleId, @RequestBody Comment comment) {
		if (articleService.articleExistsById(articleId)) {
			comment.setArticle(articleService.getArticleById(articleId));
			commentService.saveComment(comment);
			return comment;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No article found with id - " + articleId);
		}
	}

}
