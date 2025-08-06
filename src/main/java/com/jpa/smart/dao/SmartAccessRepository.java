package com.jpa.smart.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.smart.entities.Access;
import com.jpa.smart.entities.UserInfo;

public interface SmartAccessRepository extends JpaRepository<UserInfo, String>{

	public Access findByContact(String contact);
}
