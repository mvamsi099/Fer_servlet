package com.rs.fer.main;

import com.rs.fer.bean.User;
import com.rs.fer.service.FerService;
import com.rs.fer.service.impl.FERServiceImpl;

public class LoginMain {

	public static void main(String[] args) {
		
	// get the input 
	String username = "sudha";
	String Password = "rs123";
	
		
	//pass the input to buissness layer execution
		FerService ferService = new FERServiceImpl(); 
	   int  isValiduser = ferService.login(username, Password);
		
	//Display the output
	   if(isValiduser > 0) {
		   System.out.println("Welcome to the User");
	   } else {
		   
		   System.out.println("login is failed ,please try again ");
	   }

}

}