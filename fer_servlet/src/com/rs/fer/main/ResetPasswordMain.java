package com.rs.fer.main;


import com.rs.fer.bean.User;
import com.rs.fer.service.FerService;
import com.rs.fer.service.impl.FERServiceImpl;

public class ResetPasswordMain {

	public static void main(String[] args) {

		// get the input
		int userId = 5;
		String currentPassword ="rs";
		String newPassword = "rs123";

		// pass the input to buissness layer execution
		FerService ferService = new FERServiceImpl();
		boolean isResetPassword = ferService.resetPassword(userId, currentPassword, newPassword);

		// Display the output
		if (isResetPassword) {
			System.out.println("Password updated successfully....!");
		} else {

			System.out.println("updating of password is failed...!");
		}

	}

}