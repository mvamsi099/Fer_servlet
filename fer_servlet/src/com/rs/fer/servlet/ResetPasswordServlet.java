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

@WebServlet("/resetpassword")
public class ResetPasswordServlet extends HttpServlet {

	FerService ferService = null;

	@Override
	public void init() throws ServletException {
		ferService = new FERServiceImpl();

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		int userId = Integer.parseInt(session.getAttribute("userId").toString());
		// get the input
		String currentPassword = request.getParameter("currentpassword");
		String newPassword = request.getParameter("newpassword");

		// pass the input to buissness layer execution
		boolean isResetPassword = ferService.resetPassword(userId, currentPassword, newPassword);

		PrintWriter out = response.getWriter();

		// header and leftframe
		LayoutUtil.displayHeaderAndLeftFrame(request, response, out, session);

		// Display the output
		if (isResetPassword) {
			out.println("Password updated successfully....!");
		} else {

			out.println("updating of password is failed...!");
		}

		LayoutUtil.displayFooter(request, response);

	}

	@Override
	public void destroy() {
		ferService = null;

	}

}
