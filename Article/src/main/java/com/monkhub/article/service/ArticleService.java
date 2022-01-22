package com.monkhub.article.service;

import com.monkhub.article.entity.Article;

import java.util.List;

public interface ArticleService {

	public boolean articleExistsById(Long articleId);

	public List<Article> getArticles();

	public Article getArticleById(Long articleId);

	public void saveArticle(Article article);

}
