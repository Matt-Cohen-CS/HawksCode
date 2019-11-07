package edu.monmouth.hawkscode.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	private String id;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private List<Course> courses;

	private int score;

	public User() { 
		this("");
	}
	
	public User(String id) {
		this.id = id;
		this.score = 0;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void addToScore(int points) {
		this.score += points;
	}
}
