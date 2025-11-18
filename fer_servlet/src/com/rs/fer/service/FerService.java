package com.rs.fer.service;

import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;

public interface FerService {

	boolean addExpense(Expense expense);

	boolean editExpense(Expense expense);

	boolean registration(User user);

	boolean deleteExpense(int expenseId);


	boolean resetPassword(int userId, String currentPassword, String newPassword);
    
	int login(String username,String Password);
	
	List<Expense>getExpenseOptions(int userId);
	
	List<Expense>getExpenseReport(int userid, String expensetype,String fromDate,String toDate);
	
	Expense getExpense(int expenseId);
	
	User getUser(int userid);
	
	boolean updateUser(User user);
}
