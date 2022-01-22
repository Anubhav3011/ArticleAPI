package com.monkhub.article.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "articles")
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "article_id")
	private int id;

	@Column(name = "article_date_created")
	private Date date_created;

	@Column(name = "article_date_updated")
	private Date date_updated;

	@Column(name = "article_content")
	private String content;

	@Column(name = "article_description")
	private String description;

	@Column(name = "article_title")
	private String title;

}
