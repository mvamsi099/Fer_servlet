package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;
import com.rs.fer.service.FerService;
import com.rs.fer.service.impl.FERServiceImpl;

public class EditExpenseMain {

	public static void main(String[] args) {
		
	// get the input 
	Expense expense = new Expense();
	expense.setType("Tea");
	expense.setDate("11-11-2022");
	expense.setPrice(30);
	expense.setNumberofitems(2);
	expense.setTotal(120);
	expense.setBywhom("Me");
	expense.setId(1);
	
		
	//pass the input to buissness layer execution
		FerService ferService = new FERServiceImpl(); 
	   boolean isEditExpense = ferService.editExpense(expense);
		
	//Display the output
	   if(isEditExpense) {
		   System.out.println("Expense Added successfully....!");
	   } else {
		   
		   System.out.println("Adding Expense is failed...!");
	   }

}

}