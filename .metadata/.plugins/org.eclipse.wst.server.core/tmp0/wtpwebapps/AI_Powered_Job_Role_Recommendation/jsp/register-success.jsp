<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Successful</title>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>

<body>

	<div class="container">

		<h2>Registration Successful 🎉</h2>

		<p style="text-align: center; color: #666;">Your account has been
			created successfully. Please login to continue.</p>

		<div class="nav">
			<a href="<%=request.getContextPath()%>/jsp/login.jsp"> Go to
				Login </a>
		</div>

	</div>

</body>
</html>
