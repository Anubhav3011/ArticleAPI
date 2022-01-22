package com.monkhub.article.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.monkhub.article.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

	@Query(value = "SELECT * FROM Comments c WHERE c.article_id = :articleId", nativeQuery = true)
	public List<Comment> getCommentsByArticleId(int articleId);

}
