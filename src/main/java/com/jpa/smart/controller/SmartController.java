package com.jpa.smart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.smart.entities.UserInfo;
import com.jpa.smart.services.SmartContactServices;

@RestController
public class SmartController {
	
	@Autowired
	private SmartContactServices smartContactServices;
	
	@GetMapping("/fetch")
	public List<UserInfo> getUserData() {
		
		return smartContactServices.fetchAllData();
	}
	
	
	//fetching data with pagination
	@GetMapping("/fetchdata")
	public Page<UserInfo> gePaginatedtUserData(@RequestParam int page, @RequestParam int size) {
//		Page<UserInfo> data =
				return smartContactServices.fetchPaginatedUserData(page, size);
//		return data.getContent());
	}
	
	
	@GetMapping("/fetch/{contact}")
	public UserInfo getUserDataByCont(@PathVariable("contact") String contact) {
		
		return smartContactServices.fetchDataByCont(contact).get();
	}
	
	@GetMapping("/access/{contact1}/{contact2}")
	public void checkAccess(@PathVariable("contact1") String userContact, @PathVariable("conatct2") String othercont) {
		
		
	}
	
	
	
	@PostMapping("/save")
	public UserInfo addNewRecord(@RequestBody UserInfo user) {
		UserInfo temp= smartContactServices.addUser(user);
		return temp;
	}
	
	@PutMapping("/update/{contact}")
	public UserInfo updateUserDataByCont(@RequestBody UserInfo user, @PathVariable("contact") String contact) {
		
		return smartContactServices.updateDataByCont(user,contact);
	}
	
	@DeleteMapping("/delete/{contact}")
	public String deleteUserDataByCont(@PathVariable("contact") String contact) {
	    smartContactServices.deleteDataByCont(contact);
	    return "Record(s) are successfully deleted";
	}
	
}
