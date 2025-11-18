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

import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;
import com.rs.fer.service.FerService;
import com.rs.fer.service.impl.FERServiceImpl;
import com.rs.fer.util.LayoutUtil;

@WebServlet("/displayAddressInfo")
public class DisplayAddressInfoServlet extends HttpServlet {

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
		Address address = user.getAddress();

		// pass the input to buissness layer execution
		user.setEmail(request.getParameter("email"));
		user.setMobile(request.getParameter("mobile"));

		// Display the output

		out.println("<table border='2' align='center'>");

		out.println("<tr>");
		out.println("<td colspan='2' align='center'>Address</td>");
		out.println("</tr>");
		out.println("<tr>");

		out.println("<td> Line1</td>");
		out.println("<td><input type='text' name='lineOne' value='" + address.getLine1() + "'>");
		out.println("</td>");
		out.println("</tr>");

		out.println("<td> Line2</td>");
		out.println("<td><input type='text' name='lineTwo' value='" + address.getLine2() + "'>");
		out.println("</td>");
		out.println("</tr>");

		out.println("<td>City </td>");
		out.println("<td><input type='text' name='city' value='" + address.getCity() + "'>");
		out.println("</td>");
		out.println("</tr>");

		out.println("<td>State </td>");
		out.println("<td><input type='text' name='state' value='" + address.getState() + "'>");
		out.println("</td>");
		out.println("</tr>");

		out.println("<td>Pincode </td>");
		out.println("<td><input type='text' name='pinCode' value='" + address.getPincode() + "'>");
		out.println("</td>");
		out.println("</tr>");

		out.println("<td>Country </td>");
		out.println("<td><input type='text' name='country' value='" + address.getCountry() + "'>");
		out.println("</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td colspan='2' align='center'>");
		out.println("<input type ='submit' value='Next' onclick =\"javascript: submitForm('review')\">");
		out.println("</td>");
		out.println("</tr>");

		out.println("</table>");

		// footer
		LayoutUtil.displayFooter(request, response);
	}

}
