package com.wf.mte.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.OneToMany;

public class Cashier {

	private Long id;
	private String firstName;
	private String lastname;
	private String comments;
	private int state;
	
	@OneToMany(mappedBy = "cashier")
	private Set<Taking> takings = new HashSet<>();
	
	
	public Set<Taking> getTakings() {
		return takings;
	}
	public void setTakings(Set<Taking> takings) {
		this.takings = takings;
	}

	
	public Cashier() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
	
}
