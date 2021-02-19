<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Status</title>
<link rel="stylesheet" type="text/css" href="css/center.css">
</head>
<body>
	<%
	HttpSession hs =request.getSession();
	String status = (String) hs.getAttribute("status");
	%>
	
	<div class="login">
		<h2><%= status %></h2>
		<a href="./YourOrder"><button>Back</button></a>
	</div>
</body>
</html>