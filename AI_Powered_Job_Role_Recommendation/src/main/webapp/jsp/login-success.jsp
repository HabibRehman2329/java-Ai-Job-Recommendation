<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.jobai.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Successful | AI Job Recommendation</title>

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

		<div class="container dashboard-container">

			<h2>Login Successful 🎉</h2>

			<p class="dashboard-desc">
				Welcome back, <b><%=user.getName()%></b>! Your AI career dashboard
				is ready.
			</p>

			<div class="dashboard-actions">

				<a href="<%=request.getContextPath()%>/jsp/skill-input.jsp"
					class="dashboard-card">
					<h3>Skill-Based AI</h3>
					<p>Get job roles based on your skills</p>
				</a> <a href="<%=request.getContextPath()%>/jsp/resume-upload.jsp"
					class="dashboard-card">
					<h3>Resume-Based AI</h3>
					<p>Upload resume & get AI suggestions</p>
				</a> <a href="<%=request.getContextPath()%>/history"
					class="dashboard-card">
					<h3>AI History</h3>
					<p>View your past AI recommendations</p>
				</a>

			</div>

			<div class="dashboard-logout">
				<a href="<%=request.getContextPath()%>/logout">Logout</a>
			</div>

		</div>

	</div>

</body>
</html>
