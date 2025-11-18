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

@WebServlet("/expenseReport")
public class ExpenseReportServlet extends HttpServlet {

	FerService ferService = new FERServiceImpl();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		// Header and leftframe
		LayoutUtil.displayHeaderAndLeftFrame(request, response, out, session);

		String expenseType = request.getParameter("expensetype");
		String fromDate = request.getParameter("fromDate");
		String toDate = request.getParameter("toDate");

		int userId = Integer.parseInt(session.getAttribute("userId").toString());

		List<Expense> expenseOptions = ferService.getExpenseReport(userId, expenseType, fromDate, toDate);

		if (expenseOptions.isEmpty()) {

			out.println("Expense Not found ");
		} else {
			// Display the output

			out.println("<table border='2' align='center'>");

			out.println("<tr>");
			out.println("<td colspan='10' align='center'>Expense Report</td>");
			out.println("</tr>");
			out.println("<tr>");

			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>");
			out.println("Expense Type");
			out.println("</td>");

			out.println("<td>");
			out.println("From Date");
			out.println("</td>");

			out.println("<td>");
			out.println("Price");
			out.println("</td>");

			out.println("<td>");
			out.println("No of item");
			out.println("</td>");

			out.println("<td>");
			out.println("Total");
			out.println("</td>");

			out.println("<td>");
			out.println("By Whom");
			out.println("</td>");

			out.println("</tr>");

			for (Expense expense : expenseOptions) {

				out.println("<tr>");
				out.println("<td>" + expense.getType() + "</td>");
				out.println("<td>" + expense.getDate() + "</td>");
				out.println("<td>" + expense.getPrice() + "</td>");
				out.println("<td>" + expense.getNumberofitems() + "</td>");
				out.println("<td>" + expense.getTotal() + "</td>");
				out.println("<td>" + expense.getBywhom() + "</td>");
				out.println("</tr>");
			}

			out.println("<tr>");
			out.println("<td colspan ='10' align = 'center'>");
			out.print("<input type='submit' value='print' >");
			out.println("</td>");
			out.println("</tr>");

			out.println("</table>");

		}
		LayoutUtil.displayFooter(request, response);
	}

}
