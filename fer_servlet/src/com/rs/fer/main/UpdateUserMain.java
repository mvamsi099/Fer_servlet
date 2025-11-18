package com.rs.fer.main;

import java.util.List;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;
import com.rs.fer.service.FerService;
import com.rs.fer.service.impl.FERServiceImpl;

public class UpdateUserMain {

	public static void main(String[] args) {
		
	// get the input 
	int userId = 1;
	
		FerService ferService = new FERServiceImpl(); 
		// to get the original object from the db
		
        User user = ferService.getUser(userId);
	 //update the name data
        user.setFirstName("Sudham");
        user.setMiddleName("reddy");
        user.setLastName("raju");
       
      // update the contact data
        user.setEmail("Sudhamreddy@rs.com");
        user.setMobile("234234234");
        
      // update address data 
        Address address = user.getAddress();
        address.setLine1("200ft road ");
        address.setLine2("chilakapetta");
        address.setCity("Hyderabad");
        address.setState("TS");
        address.setPincode("500081");
        address.setCountry("india");
        
        //call the service 
        boolean isUserUpdate = ferService.updateUser(user);
        
        if(isUserUpdate) {
        	
        	System.out.println("User profile updated successfully...!");
        } else {
		
            System.out.println("User Profile update is failed");
	  
         }

}
}