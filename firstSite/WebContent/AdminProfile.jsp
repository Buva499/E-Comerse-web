<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Profile</title>
<style>
	.container{
		 position: absolute;
		 top: 50%;
		 left: 40%;
		 margin: -150px 0 0 -150px;
		 width:415px;
		 height:200px;
		 padding: 100px;
		 background-color:  #CECEF6;
		 border: 2px solid black;
		 border-radius: 70px;
		 box-shadow: 10px 10px #BCA9F5;
	}
	h2{
		color: #0A122A;
	}
</style>
</head>
<body>
	<%
	HttpSession hs = request.getSession();
	String email = (String) hs.getAttribute("email");
	String phone = (String) hs.getAttribute("phone");
	String name = (String) hs.getAttribute("name");
	String password = (String) hs.getAttribute("password");
	%>
	
	<div class="container" id="impl">
		<h2>Name     : <%=name %></h2>
		<h2>Email    : <%=email %></h2>
		<h2>Phone    : <%=phone %></h2>
		<h2>Password : <%=password %></h2>
	
	</div>
	
</body>
</html>