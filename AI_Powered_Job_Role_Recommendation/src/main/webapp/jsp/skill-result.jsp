<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.jobai.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AI Skill Result | Job Recommendation</title>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>

<body>

	<%
	User user = (User) session.getAttribute("loggedUser");
	if (user == null) {
		response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
		return;
	}
	%>

	<!-- FULL SCREEN WRAPPER -->
	<div class="login-page">

		<!-- WIDE CLEAN CONTAINER -->
		<div class="ai-page">

			<h2>Your AI Career Insights ✨</h2>

			<p class="ai-desc">Based on your skills, here are the job roles
				and career paths recommended by AI.</p>

			<!-- SKILLS SECTION -->
			<div class="result-section">

				<h3>Skills You Entered</h3>

				<div class="skill-badge">
					<%=request.getAttribute("skills")%>
				</div>

			</div>

			<!-- AI RESULT SECTION -->
			<div class="result-section">

				<h3>AI Job Suggestions</h3>

				<div class="ai-result-box">
					<%=request.getAttribute("aiResult")%>
				</div>

			</div>

			<!-- NAVIGATION -->
			<div class="ai-actions">

				<a href="<%=request.getContextPath()%>/jsp/skill-input.jsp"
					class="ai-card">
					<h3>Try Different Skills</h3>
					<p>Run AI again with new skills</p>
				</a> <a href="<%=request.getContextPath()%>/jsp/resume-upload.jsp"
					class="ai-card">
					<h3>Resume-Based AI</h3>
					<p>Analyze your resume using AI</p>
				</a> <a href="<%=request.getContextPath()%>/history" class="ai-card">
					<h3>AI History</h3>
					<p>View previous AI results</p>
				</a> <a href="<%=request.getContextPath()%>/logout"
					class="ai-card logout-card">
					<h3>Logout</h3>
					<p>End your session</p>
				</a>

			</div>

		</div>

	</div>

</body>
</html>
