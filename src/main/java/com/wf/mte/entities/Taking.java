package com.wf.mte.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Taking {

	@Id
	@GeneratedValue
	private long id;
	private String date;
	private String comments;
    private int state;
    
    
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="source_id")
	private Source source;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cashier_id")
	private Source cashier;
	
	
	public Source getCashier() {
		return cashier;
	}

	public void setCashier(Source cashier) {
		this.cashier = cashier;
	}

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	@OneToMany(mappedBy = "taking", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TakingTypeAmount> takingType = new ArrayList<>();

	public Taking() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public List<TakingTypeAmount> getTakingType() {
		return takingType;
	}

	public void setTakingType(List<TakingTypeAmount> takingType) {
		this.takingType = takingType;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

}
