package com.monkhub.article.entity;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comments")
@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(readOnly = true)
	private Long id;

	@Column(name = "comment_date_created")
	@CreationTimestamp
	private Date date_created;

	@Column(name = "comment_date_updated")
	@UpdateTimestamp
	private Date date_updated;

	@Column(name = "comment_comment")
	private String comment;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Article article;

	@JsonIgnore
	public Object getCommentDTO() {
		Map<Object, Object> commentMap = new LinkedHashMap<>();
		Map<Object, Object> articleMap = new LinkedHashMap<>();
		articleMap.put("id", this.getArticle().getId());
		articleMap.put("title", this.getArticle().getTitle());
		commentMap.put("article", articleMap);
		commentMap.put("comment", this.getComment());
		commentMap.put("date_created", this.getDate_created());
		commentMap.put("date_updated", this.getDate_updated());
		commentMap.put("id", this.getId());
		return commentMap;
	}
}
