package com.wf.mte.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TakingTypeAmountID implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "taking_d")
	private Long takingId;
	@Column(name = "takingType_id")
	private Long takingTypeId;

	public TakingTypeAmountID() {
		super();
	}

	public Long getTakingId() {
		return takingId;
	}

	public void setTakingId(Long takingId) {
		this.takingId = takingId;
	}

	public Long getTakingTypeId() {
		return takingTypeId;
	}

	public void setTakingTypeId(Long takingTypeId) {
		this.takingTypeId = takingTypeId;
	}

	public TakingTypeAmountID(Long takingId, Long takingTypeId) {
		super();
		this.takingId = takingId;
		this.takingTypeId = takingTypeId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		TakingTypeAmountID that = (TakingTypeAmountID) o;
		return Objects.equals(takingId, that.takingId) && Objects.equals(takingTypeId, that.takingTypeId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(takingId, takingTypeId);
	}

}
