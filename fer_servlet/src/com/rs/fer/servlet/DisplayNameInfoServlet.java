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

@WebServlet("/displayNameInfo")
public class DisplayNameInfoServlet extends HttpServlet {

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

		int userId = Integer.parseInt(session.getAttribute("userId").toString());

		// pass the input to buissness layer execution
		User user = ferService.getUser(userId);

		session.setAttribute("user", user);

		// Display the output

		out.println("<table border='2' align='center'>");

		out.println("<tr>");
		out.println("<td colspan='2' align='center'>Name</td>");
		out.println("</tr>");
		out.println("<tr>");

		out.println("<td> First Name</td>");
		out.println("<td><input type='text' name='firstName' value='" + user.getFirstName() + "'>");
		out.println("</td>");
		out.println("</tr>");

		out.println("<td>Middle Name</td>");
		out.println("<td><input type='text' name='middleName' value='" + user.getMiddleName() + "'>");
		out.println("</td>");
		out.println("</tr>");

		out.println("<td>Last Name</td>");
		out.println("<td><input type='text' name='lastName' value='" + user.getLastName() + "'>");
		out.println("</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td colspan='2' align='center'>");
		out.println("<input type ='submit' value='Next' onclick =\"javascript: submitForm('displayContactInfo')\">");
		out.println("</td>");
		out.println("</tr>");

		out.println("</table>");

		// footer
		LayoutUtil.displayFooter(request, response);
	}

}
