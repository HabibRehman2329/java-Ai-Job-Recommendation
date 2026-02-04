package com.jobai.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = { "/jsp/login-success.jsp", "/jsp/skill-input.jsp", "/jsp/resume-upload.jsp", "/history" })
public class AuthFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// No init needed
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		HttpSession session = req.getSession(false);

		if (session == null || session.getAttribute("loggedUser") == null) {
			// ❌ Not logged in
			res.sendRedirect(req.getContextPath() + "/jsp/login.jsp");
			return;
		}

		// ✅ Logged in → allow access
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// No cleanup needed
	}
}
