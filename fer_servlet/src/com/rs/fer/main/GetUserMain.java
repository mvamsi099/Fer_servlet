package com.rs.fer.main;

import java.util.List;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;
import com.rs.fer.service.FerService;
import com.rs.fer.service.impl.FERServiceImpl;

public class GetUserMain {

	public static void main(String[] args) {
		
	// get the input 
	int userId = 1;
	
		
	//pass the input to buissness layer execution
		FerService ferService = new FERServiceImpl(); 
        User user = ferService.getUser(userId);
	 
		
	//Display the output
	   if(user == null) {
		   System.out.println("user not found");
	   } else {
		   
		 
			   
			   System.out.println("FirstName: " + user.getFirstName());
				System.out.println("MiddleName: " + user.getMiddleName());
				System.out.println("LastName: " + user.getLastName());
				System.out.println("...................!");
				
				System.out.println("Email: " + user.getEmail());
				System.out.println("Mobile: " + user.getMobile());
				System.out.println(".........................!");
				
				Address address = user.getAddress();
				System.out.println("Line1: " + address.getLine1());
				System.out.println("Line2: " + address.getLine2());
				System.out.println("City: " + address.getCity());
				System.out.println("State: " + address.getState());
				System.out.println("Pincode: " + address.getPincode());
				System.out.println("Country: " + address.getCountry());
				
				System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,,,,!");
		   
	   }

}

}