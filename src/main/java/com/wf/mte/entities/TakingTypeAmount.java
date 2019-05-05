package com.wf.mte.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class TakingTypeAmount {

	@EmbeddedId
	private TakingTypeAmountID id;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("takingId")
	private Taking taking;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("takingTypeId")
	private TakingsType takingsType;

	private double amount;

	public TakingTypeAmountID getId() {
		return id;
	}

	public void setId(TakingTypeAmountID id) {
		this.id = id;
	}

	public Taking getTaking() {
		return taking;
	}

	public void setTaking(Taking taking) {
		this.taking = taking;
	}

	public TakingsType getTakingsType() {
		return takingsType;
	}

	public void setTakingsType(TakingsType takingsType) {
		this.takingsType = takingsType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public TakingTypeAmount(Taking taking, TakingsType takingsType, double amount) {
		super();
		this.taking = taking;
		this.takingsType = takingsType;
		this.amount = amount;
	}

	public TakingTypeAmount() {
		super();
	}

}
