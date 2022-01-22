package com.monkhub.article.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monkhub.article.entity.Comment;
import com.monkhub.article.repository.CommentRepository;
import com.monkhub.article.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;

	@Override
	public List<Comment> getComments() {
		return commentRepository.findAll();
	}

	@Override
	public List<Comment> getCommentsByArticleId(int articleId) {
		return commentRepository.getCommentsByArticleId(articleId);
	}

	@Override
	public void saveComment(Comment comment) {
		commentRepository.save(comment);
	}

}
