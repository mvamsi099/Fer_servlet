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

@WebServlet("/editExpense")
public class EditExpenseServlet extends HttpServlet {

	FerService ferService = null;

	@Override
	public void init() throws ServletException {
		ferService = new FERServiceImpl();

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get the input
		Expense expense = new Expense();
		expense.setType(request.getParameter("type"));
		expense.setDate(request.getParameter("date"));
		expense.setPrice(Float.parseFloat(request.getParameter("price")));
		expense.setNumberofitems(Integer.parseInt(request.getParameter("numberOfItem")));
		expense.setTotal(Float.parseFloat(request.getParameter("total")));
		expense.setBywhom(request.getParameter("byWhom"));

		HttpSession session = request.getSession();
		int expenseId = Integer.parseInt(session.getAttribute("expenseId").toString());
		expense.setId(expenseId);

		// pass the input to business layer execution
		boolean isEditExpense = ferService.editExpense(expense);

		PrintWriter out = response.getWriter();

		// header and leftframe
		LayoutUtil.displayHeaderAndLeftFrame(request, response, out, session);

		// body

		// Display the output
		if (isEditExpense) {
			out.println("Expense edited successfully....!");

		} else {

			out.println("editing expense  failed...!");

		}

		LayoutUtil.displayFooter(request, response);

	}

	@Override
	public void destroy() {
		ferService = null;

	}

}
