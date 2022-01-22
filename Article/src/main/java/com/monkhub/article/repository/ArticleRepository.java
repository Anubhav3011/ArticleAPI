package com.monkhub.article.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monkhub.article.entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

}
