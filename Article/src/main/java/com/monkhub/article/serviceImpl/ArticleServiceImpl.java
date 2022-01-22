package com.monkhub.article.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monkhub.article.entity.Article;
import com.monkhub.article.repository.ArticleRepository;
import com.monkhub.article.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleRepository articleRepository;

	@Override
	public boolean articleExistsById(Long articleId) {
		return articleRepository.existsById(articleId);
	}

	@Override
	public List<Article> getArticles() {
		return articleRepository.findAll();
	}

	@Override
	public Article getArticleById(Long articleId) {
		return articleRepository.findById(articleId).get();
	}

	@Override
	public void saveArticle(Article article) {
		articleRepository.save(article);
	}

}
