package com.snake.model;

import java.util.HashSet;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;



/**
 * Customer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_user", catalog = "snake")
public class User implements java.io.Serializable {

	// Fields

	private String name;
	private Integer grade;
	private Integer ranking;
	private Integer userid;
	private String password;

	// User

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String name) {
		this.name = name;
	}

	/** full constructor */
	public User(String name, int grade, int ranking,String password) {
		this.name = name;
		this.grade = grade;
		this.ranking=ranking;
		this.password=password;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "customerid", unique = true, nullable = false)
	public Integer getCustomerid() {
		return this.userid;
	}

	public void setCustomerid(Integer userid) {
		this.userid = userid;
	}

	@Column(name = "name", nullable = false, length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "grade", length = 40)
	public int getGrade() {
		return this.grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Column(name = "ranking", length = 16)
	public int getRanking() {
		return this.ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public String getPassword(String password) {
		return this.password;
	}
	public void setPassword(String password) {
		this.password=password;
	}

}
