<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register | AI Job Recommendation</title>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>

<body>

	<!-- FULL SCREEN WRAPPER (SAFE) -->
	<div class="login-page">

		<div class="container login-container">

			<h2>Create Account ✨</h2>

			<p class="login-desc">Join the AI-powered career guidance
				platform</p>

			<%-- Error Message (UNCHANGED LOGIC) --%>
			<%
			String error = (String) request.getAttribute("error");
			if (error != null) {
			%>
			<p class="login-error">
				<%=error%>
			</p>
			<%
			}
			%>

			<form action="<%=request.getContextPath()%>/register" method="post">

				<label>Full Name</label> <input type="text" name="name" required>

				<br> <label>Email Address</label> <input type="email"
					name="email" required> <label>Password</label> <input
					type="password" name="password" required>

				<!-- CONFIRM PASSWORD (KEPT) -->
				<label>Confirm Password</label> <input type="password"
					name="confirmPassword" required>

				<div class="button-group">
					<input type="submit" value="Create Account">
				</div>

			</form>

			<div class="nav">
				<p>
					Already have an account? <a
						href="<%=request.getContextPath()%>/jsp/login.jsp"> Login here
					</a>
				</p>
			</div>

		</div>

	</div>

</body>
</html>
