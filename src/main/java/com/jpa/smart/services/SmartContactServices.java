package com.jpa.smart.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.jpa.smart.dao.SmartRepository;
import com.jpa.smart.entities.OtherInfo;
import com.jpa.smart.entities.UserInfo;

import jakarta.transaction.Transactional;


@Service
public class SmartContactServices {
	
	@Autowired
	private SmartRepository smartRepository;
	
	static OtherInfo inp1 = new OtherInfo("meripyaaribubu@bubuli.com","hobbies: showing my adaayn");
	static OtherInfo inp2 = new OtherInfo("meripyaaribubu@bubuli.com","education: b-tech");

//	private static List<UserInfo> list= new ArrayList<>();
//	
//	static {
//		list.add(new UserInfo("Abhishek","9694994603","Bubu ka dil","I'm bubu ka para",details));
//		
//	}
	
//	static UserInfo user1;
	
	
//	static {
//
//		List<OtherInfo> list =new ArrayList<>();
//		
//		list.add(inp1);
//		list.add(inp2);
//		
//		user1= new UserInfo("Abhishek","9694994603","Bubu ka dil","I'm bubu ka para",list);
//		
//		
//		
//	}
//	
//	public UserInfo saveData() {
//		
//		UserInfo res= smartRepositiry.save(user1);
//		System.out.println("Entry is saved successfully");
//		return res;
//		
//	}
	
	//without pagination
	public List<UserInfo> fetchAllData() {
		
		System.out.println("Records fetched successfully");
		return smartRepository.findAll();
			
	}
	
	//with pagination 
	public Page<UserInfo> fetchPaginatedUserData(int page, int size){
		Pageable pageable = PageRequest.of(page, size);
		return smartRepository.findAll(pageable);
	}
	
	
	public Optional<UserInfo> fetchDataByCont(String contact) {
		
		System.out.println("Record(s) are successfully fetched by contact");
		return smartRepository.findById(contact);
			
	}
	
	
	public UserInfo addUser(UserInfo user) {
		UserInfo res= smartRepository.save(user);
		System.out.println("User is added successfully");
		return res;
	}
	
	public UserInfo updateDataByCont(UserInfo updatedUserData, String contact) {
		UserInfo existingUser = smartRepository.findByContact(contact);
		if(existingUser != null) {
			existingUser.setAddress(updatedUserData.getAddress());
			existingUser.setContact(updatedUserData.getContact());
			existingUser.setDescription(updatedUserData.getDescription());
			existingUser.setName(updatedUserData.getName());
			existingUser.setOtherInfo(updatedUserData.getOtherInfo());
			System.out.println("User data is updated successfully");
			smartRepository.save(existingUser);
		}
		return existingUser;
	}
	
	
	public void deleteDataByCont(String contact) {
		
		smartRepository.deleteByContact(contact);
	    System.out.println("Record(s) are successfully deleted");
	  
	}
	
}	
				
				
				