package com.jpa.smart.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="other_info")
public class OtherInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long uid;
	
	private String email;
	
	private String addInfo;

	public OtherInfo(String email, String addInfo) {
		super();
		this.email = email;
		this.addInfo = addInfo;
	}

	public OtherInfo() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddInfo() {
		return addInfo;
	}

	public void setAddInfo(String addInfo) {
		this.addInfo = addInfo;
	}

	@Override
	public String toString() {
		return "OtherInfo [email=" + email + ", addInfo=" + addInfo + "]";
	}
	
	

}
