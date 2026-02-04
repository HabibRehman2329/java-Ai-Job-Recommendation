package com.jobai.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jobai.dao.UserDAO;
import com.jobai.model.User;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		UserDAO userDAO = new UserDAO();
		User user = userDAO.loginUser(email, password);

		if (user != null) {

			// 🔐 Create session
			HttpSession session = request.getSession(true);
			session.setAttribute("loggedUser", user);

			// Redirect to success page
			request.getRequestDispatcher("/jsp/login-success.jsp").forward(request, response);

		} else {

			request.setAttribute("error", "Invalid email or password");
			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
		}
	}
}
