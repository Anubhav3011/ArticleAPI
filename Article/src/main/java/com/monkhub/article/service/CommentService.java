package com.monkhub.article.service;

import com.monkhub.article.entity.Comment;

import java.util.List;

public interface CommentService {

	public List<Comment> getComments();

	public List<Comment> getCommentsByArticleId(Long articleId);

	public void saveComment(Comment comment);

	public Object getCommentsDTO(List<Comment> comments);

}
