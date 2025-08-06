package com.jpa.smart.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="access_table")
public class Access {
	
	@Id
	private String contact;
	
	private int category;
	
	
	public Access(String contact, int category) {
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


	public int getCategory() {
		return category;
	}


	public void setCategory(int category) {
		this.category = category;
	}


	@Override
	public String toString() {
		return "Access [contact=" + contact + ", category=" + category + "]";
	}
	
	
	
}
