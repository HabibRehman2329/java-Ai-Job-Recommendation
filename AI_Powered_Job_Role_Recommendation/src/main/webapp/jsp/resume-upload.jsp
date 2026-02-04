<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.jobai.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resume Analysis | AI Job Recommendation</title>

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

		<!-- WIDE CLEAN PAGE -->
		<div class="ai-page">

			<h2>AI Resume Analysis 📄</h2>

			<p class="ai-desc">Upload your resume (PDF). Our AI will analyze
				your profile and suggest the most suitable job roles for you.</p>

			<!-- UPLOAD FORM (SAFE) -->
			<form class="ai-form"
				action="<%=request.getContextPath()%>/uploadResume" method="post"
				enctype="multipart/form-data">

				<label>Select Resume (PDF only)</label> <input type="file"
					name="resume" accept=".pdf" required> <input type="submit"
					value="Analyze Resume with AI">
			</form>

			<!-- ACTION CARDS -->
			<div class="ai-actions">

				<a href="<%=request.getContextPath()%>/jsp/skill-input.jsp"
					class="ai-card">
					<h3>Skill-Based AI</h3>
					<p>Analyze jobs based on skills</p>
				</a> <a href="<%=request.getContextPath()%>/history" class="ai-card">
					<h3>AI History</h3>
					<p>View your past AI results</p>
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
