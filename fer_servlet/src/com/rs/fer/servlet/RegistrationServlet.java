package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rs.fer.bean.User;
import com.rs.fer.service.FerService;
import com.rs.fer.service.impl.FERServiceImpl;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

	FerService ferService = null;

	@Override
	public void init() throws ServletException {
		ferService = new FERServiceImpl();

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get the input
		User user = new User();
		user.setFirstName(request.getParameter("Firstname"));
		user.setMiddleName(request.getParameter("middlename"));
		user.setLastName(request.getParameter("Lastname"));
		user.setEmail(request.getParameter("email"));
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("Password"));
		user.setMobile(request.getParameter("mobilenumber"));

		// pass the input to buissness layer execution

		boolean isRegister = ferService.registration(user);

		PrintWriter out = response.getWriter();
		String path = null;
		// Display the output
		if (isRegister) {
			out.println("User is registered successfully....!");

			path = "Login.html";
		} else {

			out.println("User registration is failed...!");

			path = "Registration.html";

		}
		request.getRequestDispatcher(path).include(request, response);

	}

	@Override
	public void destroy() {
		ferService = null;

	}

}
