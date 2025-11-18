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

@WebServlet("/displayEditExpenseOptions")
public class DisplayEditExpenseOptionsServlet2 extends HttpServlet {

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
		List<Expense> expenseOptions = ferService.getExpenseOptions(userId);

		// Display the output
		if (expenseOptions.isEmpty()) {
			out.println("Expense not found");
		} else {

			out.println("Expense ID:");
			out.println("&nbsp;&nbsp;&nbsp;");

			out.println("<select name = 'expenseId'>");
			out.println("<option value =''>Please select Expense Id</option>");

			int expenseId = 0;
			String text = null;

			for (Expense expense : expenseOptions) {

				expenseId = expense.getId();
				text = expense.getId() + "--" + expense.getType() + "--" + expense.getDate() + "--" + expense.getPrice()
						+ "--" + expense.getNumberofitems() + "--" + expense.getTotal() + expense.getBywhom();
				out.println("<option value ='" + expenseId + "'>" + text + "</option>");
			}
			out.println(" </select>");
			out.println("&nbsp;&nbsp;&nbsp;");

			out.println("<input type ='submit' value='Delete' onclick =\"javascript: submitForm('deleteExpense')\">");

		}

		// footer
		LayoutUtil.displayFooter(request, response);
	}

}
