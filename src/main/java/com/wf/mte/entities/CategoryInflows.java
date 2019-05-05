package com.wf.mte.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CategoryInflows {

	@Id
	@GeneratedValue
	private Long id;
	private String label;
	private String comments;
	
	@OneToMany(mappedBy = "categoryInflows")
	private Set<InFlows> inFlows;
	
	public CategoryInflows() {
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

	public Set<InFlows> getInFlows() {
		return inFlows;
	}

	public void setInFlows(Set<InFlows> inFlows) {
		this.inFlows = inFlows;
	}
		
}
