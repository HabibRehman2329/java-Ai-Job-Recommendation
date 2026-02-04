package com.jobai.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jobai.dao.AIResultDAO;
import com.jobai.model.AIResult;
import com.jobai.model.User;
import com.jobai.util.GeminiAIUtil;

public class SkillServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Session check
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("loggedUser") == null) {
			response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
			return;
		}

		User user = (User) session.getAttribute("loggedUser");

		// Read skills
		String skills = request.getParameter("skills");

		// Get AI suggestions
		String aiResult = GeminiAIUtil.getJobSuggestionsFromSkills(skills);

		// Save AI result to DB
		AIResult ai = new AIResult();
		ai.setUserId(user.getId());
		ai.setInputText(skills);
		ai.setResultText(aiResult);
		ai.setType("SKILL"); // IMPORTANT
		AIResultDAO dao = new AIResultDAO();
		dao.saveAIResult(ai);

		// Send to JSP
		request.setAttribute("skills", skills);
		request.setAttribute("aiResult", aiResult);

		request.getRequestDispatcher("/jsp/skill-result.jsp").forward(request, response);
	}
}
