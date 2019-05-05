package com.wf.mte.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TakingsType {

	@Id
	@GeneratedValue
	private long id;
	private String label;
	private String comments;

	public TakingsType() {
		super();
	}

	@OneToMany(mappedBy = "takingsType", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TakingTypeAmount> taking = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<TakingTypeAmount> getTaking() {
		return taking;
	}

	public void setTaking(List<TakingTypeAmount> taking) {
		this.taking = taking;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
