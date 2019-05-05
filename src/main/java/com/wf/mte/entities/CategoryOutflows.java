package com.wf.mte.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CategoryOutflows {
	@Id
	@GeneratedValue
	private Long id;
	private String label;
	private String comments;
	@OneToMany(mappedBy = "categoryOutflows")
	private Set<OutFlows> outFlows;
	
	public CategoryOutflows() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Set<OutFlows> getOutFlows() {
		return outFlows;
	}

	public void setOutFlows(Set<OutFlows> outFlows) {
		this.outFlows = outFlows;
	}

	
	
	
}
