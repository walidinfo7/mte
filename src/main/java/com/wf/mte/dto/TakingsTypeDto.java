package com.wf.mte.dto;

public class TakingsTypeDto {

	private long id;
	private String label;
	private String comments;

	public long getId() {
		return id;
	}

	public TakingsTypeDto() {
		super();
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

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
