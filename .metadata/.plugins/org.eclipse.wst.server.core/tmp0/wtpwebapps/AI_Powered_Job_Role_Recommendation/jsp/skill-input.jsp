<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.jobai.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Skill Analysis | AI Job Recommendation</title>

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

	<!-- FULL SCREEN WRAPPER (SAFE) -->
	<div class="login-page">

		<div class="ai-page">

			<h2>AI Skill Analysis 🚀</h2>

			<p class="ai-desc">Enter your technical skills and let AI suggest
				the best job roles and career paths for you.</p>

			<form class="ai-form" action="<%=request.getContextPath()%>/skill"
				method="post">

				<label>Your Skills</label> <input type="text" name="skills"
					placeholder="Java, SQL, HTML, CSS, Python" required> <input
					type="submit" value="Analyze with AI">
			</form>

			<div class="ai-actions">

				<a href="<%=request.getContextPath()%>/jsp/resume-upload.jsp"
					class="ai-card">
					<h3>Resume-Based AI</h3>
					<p>Analyze your resume using AI</p>
				</a> <a href="<%=request.getContextPath()%>/history" class="ai-card">
					<h3>AI History</h3>
					<p>View your previous AI results</p>
				</a> <a href="<%=request.getContextPath()%>/logout"
					class="ai-card logout-card">
					<h3>Logout</h3>
					<p>End your current session</p>
				</a>

			</div>

		</div>

	</div>


</body>
</html>
