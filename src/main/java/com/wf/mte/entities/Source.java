package com.wf.mte.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Source {

	@Id
	@GeneratedValue
	private Long id;
	private String label;
	private String address;
	private String tel;
	private String mail;
	
	@OneToMany(mappedBy = "source")
	private Set<Taking> takings = new HashSet<>();
	
	
	public Set<Taking> getTakings() {
		return takings;
	}
	public void setTakings(Set<Taking> takings) {
		this.takings = takings;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Source() {
		super();
	}
	
}
