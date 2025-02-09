<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>History</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<% HttpSession session2 = request.getSession();
	String history = session2.getAttribute("history").toString();
%>
<h1>History : <%=history %></h1>
<div class="links">
	<a href="index.html">↩️ Home</a>
	<a href="Delete">⚔️ Clear</a>
</div>
</body>
</html>