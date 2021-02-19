<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Go ahead</title>
<link rel="stylesheet" type="text/css" href="css/center.css">
</head>
<body>
	<%
		HttpSession hs = request.getSession();
		int pno = (int) hs.getAttribute("pno");
	%>
	
	<div class="login">
		<form action="FindCheckoutCatagory" method="post">
			<input type="hidden" name="pno" value="${pno }" />
			<button type="submit">One More Step To Go..</button>
		</form>
	</div>
</body>
</html>