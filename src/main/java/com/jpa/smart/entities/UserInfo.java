package com.jpa.smart.entities;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="user_info")
public class UserInfo {
	
	private String name;
	
	@Id
	private String contact;
	
	private String address;
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "contact")
	private List<OtherInfo> otherInfo; 
	


	public UserInfo(String name, String contact, String address, String description, List<OtherInfo> otherInfo) {
		super();
		this.name = name;
		this.contact = contact;
		this.address = address;
		this.description = description;
		this.otherInfo = otherInfo;
	}


	public UserInfo() {
		//super();
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public List<OtherInfo> getOtherInfo() {
		return otherInfo;
	}


	public void setOtherInfo(List<OtherInfo> otherInfo) {
		this.otherInfo = otherInfo;
	}


	@Override
	public String toString() {
		return "UserInfo [name=" + name + ", contact=" + contact + ", address=" + address + ", description="
				+ description + ", otherInfo=" + otherInfo + "]";
	}
	
	
	
}

