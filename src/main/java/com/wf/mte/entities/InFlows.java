package com.wf.mte.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class InFlows {

	@Id
	@GeneratedValue
	private Long id;
	private double amount;
	private String comments;
	@Lob
    @Basic(fetch = FetchType.LAZY)
	private byte[] chemin;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="categoryInflows_id")
	private CategoryInflows categoryInflows;
	
	public InFlows() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public byte[] getChemin() {
		return chemin;
	}

	public void setChemin(byte[] chemin) {
		this.chemin = chemin;
	}

	public CategoryInflows getCategoryInflows() {
		return categoryInflows;
	}

	public void setCategoryInflows(CategoryInflows categoryInflows) {
		this.categoryInflows = categoryInflows;
	}
	

}
