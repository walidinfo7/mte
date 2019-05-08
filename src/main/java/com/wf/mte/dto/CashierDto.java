package com.wf.mte.dto;

import java.util.HashSet;
import java.util.Set;

import com.wf.mte.entities.Cashier;
import com.wf.mte.entities.Taking;

public class CashierDto {

	private Long id;
	private String firstName;
	private String lastname;
	private String comments;
	
	private Set<Taking> takings = new HashSet<>();

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

	public Set<Taking> getTakings() {
		return takings;
	}

	public void setTakings(Set<Taking> takings) {
		this.takings = takings;
	}

	public CashierDto() {
		super();
	}
	
	public CashierDto(Cashier cashier){
		this.id=cashier.getId();
		this.firstName=cashier.getFirstName();
		this.lastname=cashier.getLastname();
		this.comments=cashier.getComments();
	}
	
	
}
