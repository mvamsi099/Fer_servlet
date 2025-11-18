package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;
import com.rs.fer.service.FerService;
import com.rs.fer.service.impl.FERServiceImpl;

public class DeleteExpenseMain {

	public static void main(String[] args) {

		// get the input
		int expenseId = 1;

		// pass the input to buissness layer execution
		FerService ferService = new FERServiceImpl();
		boolean isdeleteExpense = ferService.deleteExpense(expenseId);

		// Display the output
		if (isdeleteExpense) {
			System.out.println("Expense deleted successfully....!");
		} else {

			System.out.println("deleting Expense is failed...!");
		}

	}

}