package com.jobai.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobai.dao.UserDAO;
import com.jobai.model.User;

public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 🔍 DEBUG PROOF (DO NOT REMOVE NOW)
		System.out.println(">>> RegisterServlet HIT <<<");

		// Read form values
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");

		// Basic validation
		if (name == null || email == null || password == null || confirmPassword == null) {
			request.setAttribute("error", "All fields are required");
			request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
			return;
		}

		if (!password.equals(confirmPassword)) {
			request.setAttribute("error", "Passwords do not match");
			request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
			return;
		}

		// Create user object
		User user = new User(name, email, password);
		UserDAO userDAO = new UserDAO();

		boolean result = userDAO.registerUser(user);

		if (result) {
			// ✅ SUCCESS → REDIRECT (NOT FORWARD)
			response.sendRedirect(request.getContextPath() + "/jsp/register-success.jsp");
			return;
		} else {
			// Registration failed
			request.setAttribute("error", "Registration failed. Email may already exist.");
			request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
		}
	}
}
