package com.monkhub.article;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.monkhub.article.entity.Article;
import com.monkhub.article.entity.Comment;
import com.monkhub.article.service.ArticleService;
import com.monkhub.article.service.CommentService;

@SpringBootApplication
public class ArticleApplication implements CommandLineRunner {

	@Autowired
	private ArticleService articleService;

	@Autowired
	private CommentService commentService;

	public static void main(String[] args) {
		SpringApplication.run(ArticleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Article article = Article.builder().title("Spring Security").description("Something")
				.date_created(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2020-12-21 09:06:33"))
				.date_updated(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2020-12-21 09:06:33"))
				.content("-------").build();
		articleService.saveArticle(article);

		Comment comment = Comment.builder()
				.date_created(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2020-12-21 09:06:33"))
				.date_updated(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2020-12-21 09:06:33"))
				.comment("awesome").article(article).articleId(article.getId()).articleTitle(article.getTitle())
				.build();
		commentService.saveComment(comment);

		while (true) {
			Thread.sleep(5000);

			List<Article> articles = articleService.getArticles();

			if (!articles.isEmpty()) {
				for (int i = 0; i < articles.size(); i++) {
					System.out.println("Blog data\n" + "id: " + articles.get(i).getId() + "\n" + "Title: "
							+ articles.get(i).getTitle() + "\n" + "Description: " + articles.get(i).getDescription()
							+ "\n" + "Date_created: " + articles.get(i).getDate_created() + "\n" + "Date_updated: "
							+ articles.get(i).getDate_updated() + "\n" + "Content: " + articles.get(i).getContent()
							+ "\n\n");
					List<Comment> comments = commentService.getCommentsByArticleId(articles.get(i).getId());
					if (!comments.isEmpty()) {
						for (int j = 0; j < comments.size(); j++) {
							System.out.println("Comments data\n" + "id: " + comments.get(j).getId() + "\n"
									+ "Date_created: " + comments.get(j).getDate_created() + "\n" + "Date_updated: "
									+ comments.get(j).getDate_updated() + "\n" + "Comment: "
									+ comments.get(j).getComment() + "\n" + "article_id: " + articles.get(i).getId()
									+ "\n");
						}
					} else {
						System.out.println("No comments found");
					}
				}
			} else {
				System.out.println("No articles found");
			}
			System.out.println("\n--------------------------------------------------\n");
		}

	}

}
