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

@WebServlet("/displayEditExpense")
public class DisplayEditExpenseServlet extends HttpServlet {

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

		int expenseId = Integer.parseInt(request.getParameter("expenseId"));
		session.setAttribute("expenseId", expenseId);

		// pass the input to buissness layer execution
		Expense expense = ferService.getExpense(expenseId);

		// Display the output

		out.println("<table border='2' align='center'>");

		out.println("<tr>");
		out.println("<td colspan='2' align='center'>Edit expense</td>");
		out.println("</tr>");
		out.println("<tr>");

		out.println("<td>Expense Type</td>");
		out.println("<td><input type='text' name='type' value='" + expense.getType() + "'>");
		out.println("</td>");
		out.println("</tr>");

		out.println("<td>Date</td>");
		out.println("<td><input type='text' name='date' value='" + expense.getDate() + "'>");
		out.println("</td>");
		out.println("</tr>");

		out.println("<td>Price</td>");
		out.println("<td><input type='text' name='price' value='" + expense.getPrice() + "'>");
		out.println("</td>");
		out.println("</tr>");

		out.println("<td>Number Of Item</td>");
		out.println("<td><input type='text' name='numberOfItem' value='" + expense.getNumberofitems() + "'>");
		out.println("</td>");
		out.println("</tr>");

		out.println("<td>Total</td>");
		out.println("<td><input type='text' name='total' value='" + expense.getTotal() + "'>");
		out.println("</td>");
		out.println("</tr>");

		out.println("<td>ByWhom</td>");
		out.println("<td><input type='text' name='byWhom' value='" + expense.getBywhom() + "'>");
		out.println("</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td colspan='2' align='center'>");
		out.println("<input type ='submit' value='Edit Expense' onclick =\"javascript: submitForm('editExpense')\">");
		out.println("</td>");
		out.println("</tr>");

		out.println("</table>");

		// footer
		LayoutUtil.displayFooter(request, response);
	}

}
