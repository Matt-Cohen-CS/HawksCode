package edu.monmouth.hawkscode.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="course")
	private List<Challenge> challenges;
	
	@ManyToOne
	@JoinColumn(name = "user")
	private User user;

	private int points;
	
	public Course() { 
		this("", null);
	}
		
	public Course(String name, User user) {
		this.name = name;
		this.user = user;
		this.points = 0;
	}
	public Course(long id, String name, List<Challenge> challenges, User user) {
		super();
		this.id = id;
		this.name = name;
		this.challenges = challenges;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Challenge> getChallenges() {
		return challenges;
	}

	public void setChallenges(List<Challenge> challenges) {
		this.challenges = challenges;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	public void addToPoints(int points) {
		this.points += points;
	}
	
}
