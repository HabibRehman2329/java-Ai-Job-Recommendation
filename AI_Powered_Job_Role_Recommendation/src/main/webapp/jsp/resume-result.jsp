<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.jobai.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resume AI Result | Job Recommendation</title>

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

	<!-- FULL SCREEN BACKGROUND -->
	<div class="login-page">

		<!-- WIDE CONTENT AREA -->
		<div class="ai-page">

			<h2>Your Resume AI Report 🧠</h2>

			<p class="ai-desc">Based on your resume, AI has analyzed your
				profile and suggested the most suitable job roles and career
				improvements.</p>

			<!-- AI RESULT SECTION -->
			<div class="result-section">

				<h3>AI Job Recommendations</h3>

				<!-- 🔥 DO NOT TOUCH THIS LINE -->
				<div class="ai-result-box">
					<%=request.getAttribute("aiResult")%>
				</div>

			</div>

			<!-- NAVIGATION ACTIONS -->
			<div class="ai-actions">

				<a href="<%=request.getContextPath()%>/jsp/resume-upload.jsp"
					class="ai-card">
					<h3>Upload Another Resume</h3>
					<p>Analyze a different resume</p>
				</a> <a href="<%=request.getContextPath()%>/jsp/skill-input.jsp"
					class="ai-card">
					<h3>Skill-Based AI</h3>
					<p>Analyze jobs using skills</p>
				</a> <a href="<%=request.getContextPath()%>/history" class="ai-card">
					<h3>AI History</h3>
					<p>View past AI analyses</p>
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
