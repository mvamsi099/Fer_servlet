package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/displayContactInfo")
public class DisplayContactInfoServlet extends HttpServlet {

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

		// pass the input to buissness layer execution
		user.setFirstName(request.getParameter("firstName"));
		user.setMiddleName(request.getParameter("middleName"));
		user.setLastName(request.getParameter("lastName"));

		// Display the output

		out.println("<table border='2' align='center'>");

		out.println("<tr>");
		out.println("<td colspan='2' align='center'>Contact</td>");
		out.println("</tr>");
		out.println("<tr>");

		out.println("<td> Email</td>");
		out.println("<td><input type='text' name='email' value='" + user.getEmail() + "'>");
		out.println("</td>");
		out.println("</tr>");

		out.println("<td>Mobile</td>");
		out.println("<td><input type='text' name='mobile' value='" + user.getMobile() + "'>");
		out.println("</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td colspan='2' align='center'>");
		out.println("<input type ='submit' value='Next' onclick =\"javascript: submitForm('displayAddressInfo')\">");
		out.println("</td>");
		out.println("</tr>");

		out.println("</table>");

		// footer
		LayoutUtil.displayFooter(request, response);
	}

}
