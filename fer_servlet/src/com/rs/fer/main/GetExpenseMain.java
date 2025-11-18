package com.rs.fer.main;

import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FerService;
import com.rs.fer.service.impl.FERServiceImpl;

public class GetExpenseMain {

	public static void main(String[] args) {
		
	// get the input 
	int expenseId = 10;
	
		
	//pass the input to buissness layer execution
		FerService ferService = new FERServiceImpl(); 
	 Expense expense = ferService.getExpense(expenseId);
	 
		
	//Display the output
	   if(expense == null) {
		   System.out.println("Expense is not found" +expenseId);
	   } else {
		   
		 
			   
			   System.out.println("ID: " + expense.getId());
				System.out.println("Type: " + expense.getType());
				System.out.println("Date: " + expense.getDate());
				System.out.println("Price: " + expense.getPrice());
				System.out.println("Numberofitems: " + expense.getNumberofitems());
				System.out.println("Total: " + expense.getTotal());
				System.out.println("Bywhom: " + expense.getBywhom());
				System.out.println("ID: " + expense.getUserid());
				
				System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,,,,!");
		   
	   }

}

}