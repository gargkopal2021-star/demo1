package com.jpa.smart.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jpa.smart.entities.UserInfo;

import jakarta.transaction.Transactional;

@Repository
public interface  SmartRepository extends JpaRepository<UserInfo, String>{
	
	public UserInfo findByContact(String contact);
	
	@Transactional
	public void deleteByContact(String contact);
	
	//@Query(value = "Select * from user_info order by name DESC", nativeQuery = true)
	@Query(value = "select u from UserInfo u order by u.name DESC")
	Page<UserInfo> findAll(Pageable pagable);
	
	//Page<UserInfo> findByContact(String ct, Pageable pagable);

}
