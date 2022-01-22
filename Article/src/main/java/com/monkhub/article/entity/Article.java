package com.monkhub.article.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "articles")
@Entity
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(readOnly = true)
	private Long id;

	@Column(name = "article_date_created")
	@CreationTimestamp
	private Date date_created;

	@Column(name = "article_date_updated")
	@UpdateTimestamp
	private Date date_updated;

	@Column(name = "article_content")
	private String content;

	@Column(name = "article_description")
	private String description;

	@Column(name = "article_title")
	private String title;

	@OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true)
	@JoinColumn(name = "article_id")
	private List<Comment> articleComments;

}
