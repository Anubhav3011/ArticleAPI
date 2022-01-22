package com.monkhub.article.service;

import com.monkhub.article.entity.Comment;

import java.util.List;

public interface CommentService {

	public List<Comment> getComments();

	public List<Comment> getCommentsByArticleId(int articleId);

	public void saveComment(Comment comment);

}
