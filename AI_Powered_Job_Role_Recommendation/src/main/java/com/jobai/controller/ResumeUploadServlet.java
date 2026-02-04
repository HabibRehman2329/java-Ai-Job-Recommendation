package com.jobai.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Part;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jobai.util.PDFUtil;
import com.jobai.util.GeminiAIUtil;
import com.jobai.model.AIResult;
import com.jobai.model.User;
import com.jobai.dao.AIResultDAO;

@WebServlet("/uploadResume")
@MultipartConfig
public class ResumeUploadServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println(">>> ResumeUploadServlet HIT <<<");

		/*
		 * =============================== 1️⃣ SESSION CHECK
		 * ===============================
		 */
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("loggedUser") == null) {
			response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
			return;
		}

		User user = (User) session.getAttribute("loggedUser");

		/*
		 * =============================== 2️⃣ GET UPLOADED PDF
		 * ===============================
		 */
		Part resumePart = request.getPart("resume");

		if (resumePart == null || resumePart.getSize() == 0) {
			request.setAttribute("error", "Please upload a resume PDF");
			request.getRequestDispatcher("/jsp/resume-upload.jsp").forward(request, response);
			return;
		}

		/*
		 * =============================== 3️⃣ EXTRACT TEXT FROM PDF
		 * ===============================
		 */
		String resumeText = PDFUtil.extractText(resumePart.getInputStream());

		/*
		 * =============================== 4️⃣ SEND TO GEMINI AI
		 * ===============================
		 */
		String aiResultText = GeminiAIUtil.getJobSuggestionsFromResume(resumeText);

		/*
		 * =============================== 5️⃣ SAVE RESULT TO DB (HISTORY)
		 * ===============================
		 */
		AIResult ai = new AIResult();
		ai.setUserId(user.getId());
		ai.setInputText("Resume Analysis");
		ai.setResultText(aiResultText);
		ai.setType("RESUME"); // ⭐ VERY IMPORTANT

		AIResultDAO dao = new AIResultDAO();
		dao.saveAIResult(ai);

		/*
		 * =============================== 6️⃣ SEND DATA TO JSP
		 * ===============================
		 */
		request.setAttribute("aiResult", aiResultText);

		request.getRequestDispatcher("/jsp/resume-result.jsp").forward(request, response);
	}
}
