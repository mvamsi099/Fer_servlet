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

@WebServlet("/addExpense")
public class AddExpenseServlet extends HttpServlet {

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
		expense.setType(request.getParameter("Type"));
		expense.setDate(request.getParameter("Date"));
		expense.setPrice(Float.parseFloat(request.getParameter("Price")));
		expense.setNumberofitems(Integer.parseInt(request.getParameter("Numberofitems")));
		expense.setTotal(Float.parseFloat(request.getParameter("Total")));
		expense.setBywhom(request.getParameter("Bywhom"));

		HttpSession session = request.getSession();
		int userId = Integer.parseInt(session.getAttribute("userId").toString());
		expense.setUserid(userId);

		// pass the input to business layer execution
		boolean isRegister = ferService.addExpense(expense);

		PrintWriter out = response.getWriter();

		// header and leftframe
		LayoutUtil.displayHeaderAndLeftFrame(request, response, out, session);

		// body

		// Display the output
		if (isRegister) {
			out.println("Expense Added successfully....!");

		} else {

			out.println("Adding Expense is failed...!");

		}

		LayoutUtil.displayFooter(request, response);

	}

	@Override
	public void destroy() {
		ferService = null;

	}

}
