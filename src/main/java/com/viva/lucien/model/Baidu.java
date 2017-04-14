package com.viva.lucien.model;
// Generated 2017-4-14 15:43:40 by Hibernate Tools 5.2.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Baidu generated by hbm2java
 */
@Entity
@Table(name = "baidu")
public class Baidu implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1593439739330723496L;
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",nullable = false)
	private Long id;
	@Column(name="title")
	private String title;
	@Column(name="url")
	private String url;

	public Baidu() {
	}

	public Baidu(String title, String url) {
		this.title = title;
		this.url = url;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}