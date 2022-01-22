package com.monkhub.article.service;

import com.monkhub.article.entity.Article;

import java.util.List;

public interface ArticleService {

	public boolean articleExistsById(int articleId);

	public List<Article> getArticles();

	public Article getArticleById(int articleId);

	public void saveArticle(Article article);

}
