
package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.bean.User;
import com.rs.fer.service.FerService;
import com.rs.fer.service.impl.FERServiceImpl;
import com.rs.fer.util.LayoutUtil;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	FerService ferService = null;

	@Override
	public void init() throws ServletException {
		ferService = new FERServiceImpl();

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get the input
		String username = request.getParameter("username");
		String Password = request.getParameter("password");

		// pass the input to buissness layer execution

		int userId = ferService.login(username, Password);

		PrintWriter out = response.getWriter();
		String path = null;
		// Display the output
		if (userId > 0) {

			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("userId", userId);

			// Header and LeftFrame
			LayoutUtil.displayHeaderAndLeftFrame(request, response, out, session);

			// body
			out.println("Welcome to the User: " + username);

			// Footer
			LayoutUtil.displayFooter(request, response);

		} else {

			out.println("login is failed ,please try again ");
			request.getRequestDispatcher("Login.html").include(request, response);

		}

	}

	@Override
	public void destroy() {
		ferService = null;

	}

}
