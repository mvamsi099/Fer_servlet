package com.rs.fer.main;

import com.rs.fer.bean.User;
import com.rs.fer.service.FerService;
import com.rs.fer.service.impl.FERServiceImpl;

public class RegistrationMain {

	public static void main(String[] args) {
		
	// get the input 
		User user = new User();
		user.setFirstName("GV");
		user.setMiddleName("");
		user.setLastName("G");
		user.setEmail("GV@rs.com");
		user.setUsername("gv");
		user.setPassword("rs");
		user.setMobile("45667656");
	
		
	//pass the input to buissness layer execution
		FerService ferService = new FERServiceImpl(); 
	   boolean isRegister = ferService.registration(user);
		
	//Display the output
	   if(isRegister) {
		   System.out.println("User is registered successfully....!");
	   } else {
		   
		   System.out.println("User registration is failed...!");
	   }

}

}