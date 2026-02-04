<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JobAI | AI Job Role Recommendation</title>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>

	<div class="app-container">

		<!-- ================= NAVBAR ================= -->
		<header class="navbar">
			<div class="logo">Job Genius</div>
			<%@ page import="com.jobai.model.User"%>

			<nav class="nav-links">
				<a href="<%=request.getContextPath()%>/index.jsp">Home</a> <a
					href="#features">Features</a>

				<%
				User user = (User) session.getAttribute("loggedUser");
				if (user == null) {
				%>
				<!-- NOT LOGGED IN -->
				<a href="<%=request.getContextPath()%>/jsp/login.jsp">Login</a> <a
					href="<%=request.getContextPath()%>/jsp/register.jsp">Register</a>
				<%
				} else {
				%>
				<!-- LOGGED IN -->
				<a href="<%=request.getContextPath()%>/jsp/login-success.jsp">
					Dashboard </a> <a href="<%=request.getContextPath()%>/logout">Logout</a>
				<%
				}
				%>
			</nav>

		</header>

		<!-- ================= HERO SECTION ================= -->
		<section class="hero">

			<!-- LEFT -->
			<div class="hero-left">
				<h1>AI-Powered Job Role Recommendation</h1>

				<p>A smart platform that helps IT students discover the most
					suitable job roles using AI-based skill and resume analysis.</p>

				<div class="hero-buttons">
					<a href="<%=request.getContextPath()%>/jsp/register.jsp"
						class="btn primary-btn"> REGISTER </a> <a
						href="<%=request.getContextPath()%>/jsp/login.jsp"
						class="btn secondary-btn"> LOGIN </a>
				</div>
			</div>

			<!-- RIGHT -->
			<div class="hero-right">
				<img src="<%=request.getContextPath()%>/assets/images/job.png"
					alt="AI Job Recommendation" class="hero-image">
			</div>

		</section>

		<!-- ================= FEATURES ================= -->
		<section class="features" id="features">

			<h2 class="features-title">What Job Genius Do</h2>

			<div class="features-container">

				<div class="feature-card">
					<h3>AI Skill Analysis</h3>
					<p>Analyze your technical skills using AI to understand your
						career strengths.</p>
				</div>

				<div class="feature-card">
					<h3>Resume Analyzer</h3>
					<p>Upload your resume and let AI extract skills, experience,
						and suitability.</p>
				</div>

				<div class="feature-card">
					<h3>Job Role Matching</h3>
					<p>Get the most suitable IT job roles based on your profile.</p>
				</div>

				<div class="feature-card">
					<h3>Skill Upgrade Suggestions</h3>
					<p>AI suggests additional skills to improve your job readiness.
					</p>
				</div>

			</div>
		</section>

	</div>

</body>
</html>
