package com.jobai.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jobai.dao.AIResultDAO;
import com.jobai.model.AIResult;
import com.jobai.model.User;

public class HistoryServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1️⃣ Session check
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("loggedUser") == null) {
			response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
			return;
		}

		User user = (User) session.getAttribute("loggedUser");

		// 2️⃣ Fetch history from DB
		AIResultDAO dao = new AIResultDAO();
		List<AIResult> history = dao.getResultsByUserId(user.getId());

		// 3️⃣ Send to JSP
		request.setAttribute("history", history);
		request.getRequestDispatcher("/jsp/ai-history.jsp").forward(request, response);
	}
}
