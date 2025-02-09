<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<img src="Images\deadpool-heart.gif">
<h1>Joke of Day !</h1>
<h3>🤣<%=request.getParameter("joke") %>🤣</h3>
<form action="MyServlet" method="get">
	<input type="text" placeholder="Enter number1" name="num1">
	<input type="text" placeholder="Enter number2" name="num2">
	<button name="selector" value="1">+</button>
	<button name="selector" value="2">-</button>
	<button name="selector" value="3">×</button>
	<button name="selector" value="4">÷</button>
</form>
<h1>ANS : <%=request.getParameter("ans") %>🚩</h1>
<div class="links">
	<a href="index.html">↩️ Home</a>
	<a href="MyServlet2">📖 History</a>
</div>
</body>
</html>