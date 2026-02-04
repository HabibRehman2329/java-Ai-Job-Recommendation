<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login | AI Job Recommendation</title>

<!-- Global CSS (UNCHANGED) -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>

<body>

	<!-- FULL SCREEN WRAPPER (SAFE) -->
	<div class="login-page">

		<div class="container login-container">

			<h2>Welcome Back 👋</h2>

			<p class="login-desc">Login to continue your AI-powered career
				journey</p>

			<%-- Error message if login fails (UNCHANGED) --%>
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

			<form action="<%=request.getContextPath()%>/login" method="post">

				<label>Email Address</label> <input type="email" name="email"
					placeholder="example@gmail.com" required> <label>Password</label>
				<input type="password" name="password" placeholder="••••••••"
					required>

				<div class="button-group">
					<input type="submit" value="Login">
				</div>

			</form>

			<div class="nav">
				<p>
					Don’t have an account? <a
						href="<%=request.getContextPath()%>/jsp/register.jsp"> Create
						one </a>
				</p>
			</div>

		</div>

	</div>

</body>
</html>
