package com.viva.lucien.model;
// Generated 2017-4-10 11:33:16 by Hibernate Tools 5.2.1.Final

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author qiaoxing
 *
 * @time:2017年4月10日 下午4:24:10
 * @Description:用户实体类
 */
@Entity
@Table(name = "user")
public class User implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -833849534214426691L;

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",nullable = false)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="register_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date registerTime;

	public User() {
	}

	public User(String name, Date registerTime) {
		this.name = name;
		this.registerTime = registerTime;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegisterTime() {
		return this.registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

}
