package com.jpa.smart.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="access_table")
public class Access {
	
	@Id
	private String contact;
	
	private String category;
	
	
	public Access(String contact, String category) {
		super();
		this.contact = contact;
		this.category = category;
	}


	public Access() {
		super();
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	@Override
	public String toString() {
		return "Access [contact=" + contact + ", category=" + category + "]";
	}
	
	
	
}
