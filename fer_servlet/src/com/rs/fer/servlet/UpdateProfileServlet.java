package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;
import com.rs.fer.service.FerService;
import com.rs.fer.service.impl.FERServiceImpl;
import com.rs.fer.util.LayoutUtil;

@WebServlet("/updateProfile")
public class UpdateProfileServlet extends HttpServlet {

	FerService ferService = new FERServiceImpl();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		// Header and leftframe
		LayoutUtil.displayHeaderAndLeftFrame(request, response, out, session);

		// Body
		// get the input

		User user = (User) session.getAttribute("user");

		// call the server for the buisness logic
		boolean isUserUpdate = ferService.updateUser(user);

		if (isUserUpdate) {

			out.println("Updating Profile is  successfull...!");
		} else {

			out.println("Profile Updation failed ....!");
		}

		// footer
		LayoutUtil.displayFooter(request, response);
	}

}
