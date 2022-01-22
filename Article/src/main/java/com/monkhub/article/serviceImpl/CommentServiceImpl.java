package com.monkhub.article.serviceImpl;

import java.util.ArrayList;
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
	public List<Comment> getCommentsByArticleId(Long articleId) {
		return commentRepository.getCommentsByArticleId(articleId);
	}

	@Override
	public void saveComment(Comment comment) {
		commentRepository.save(comment);
	}

	@Override
	public Object getCommentsDTO(List<Comment> comments) {
		List<Object> commentsDTO = new ArrayList<>();
		for (Comment comment : comments) {
			commentsDTO.add(comment.getCommentDTO());
		}
		return commentsDTO;
	}

}
