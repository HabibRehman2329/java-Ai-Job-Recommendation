<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.jobai.model.AIResult"%>
<%@ page import="com.jobai.model.User"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AI History | JobAI</title>

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

	List<AIResult> history = (List<AIResult>) request.getAttribute("history");
	%>

	<!-- FULL SCREEN WRAPPER -->
	<div class="login-page">

		<!-- WIDE PAGE -->
		<div class="ai-page">

			<h2>📊 Your AI Activity History</h2>

			<p class="ai-desc">View your past skill-based and resume-based AI
				recommendations.</p>

			<%
			if (history == null || history.isEmpty()) {
			%>

			<p style="text-align: center; font-weight: 600;">No AI history
				found yet.</p>

			<%
			} else {
			%>

			<!-- HISTORY TABLE -->
			<div class="history-table-wrapper">

				<table class="history-table">
					<thead>
						<tr>
							<th>Date</th>
							<th>Input Type</th>
							<th>AI Result</th>
						</tr>
					</thead>

					<tbody>
						<%
						for (AIResult r : history) {
						%>
						<tr>
							<td><%=r.getCreatedAt()%></td>
							<td><%=r.getInputText()%></td>
							<td class="history-result"><%=r.getResultText()%></td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
			</div>
			<%
			}
			%>

			<!-- ACTIONS -->
			<div class="ai-actions">

				<a href="<%=request.getContextPath()%>/jsp/skill-input.jsp"
					class="ai-card">
					<h3>Skill-Based AI</h3>
					<p>Run AI using skills</p>
				</a> <a href="<%=request.getContextPath()%>/jsp/resume-upload.jsp"
					class="ai-card">
					<h3>Resume-Based AI</h3>
					<p>Analyze resume again</p>
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
