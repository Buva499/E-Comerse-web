<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 	<%@page import="java.util.ArrayList" %>
 	<%@page import="java.util.List" %>
 	<%@page import="in.smarttech.model.ImageDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Product</title>
<link rel="stylesheet" type="text/css" href="css/a.css">
</head>

<body>
	<header>
		<div class="header">
		<div class="container">
			<div class="navbar">
				<div class="logo">
					<img src="images/Group 1.png" width="225px">
				</div>
				<nav>
					<ul id="menuItems">
						<li><a href="index.html">Home</a></li>
						<li><a href="">About</a></li>
						<li><a href="">Contact</a></li>
						<li><a href="CustomerRegister.html">Register Here</a></li>
						<li><a href="CustomerLogin.html">Login</a></li>
				
					</ul>
				</nav>
				<img src="images/car.png" width="30px" height="30px"/>
			
				<div class="menu-icon" onclick="menutoggle()">
					<img src="images/download.png" width="40px" height="50px"/>
				</div>
				
			</div>
			
		</div>
	</div>
	</header>

		<%
			List<ImageDto> list= (ArrayList<ImageDto>)request.getAttribute("list");
		%>
		<div class="container1">
			<%
				for (int i=0;i<list.size();i++){
				ImageDto dto = list.get(i);
				int pno = dto.getPno();
				String pname = dto.getPname();
				String catagory = dto.getCatagory();
				String pdetails = dto.getPdetails();
				int pcost = dto.getPcost();
			%>

		<div class="box" align="center">

			<img src="./ImageDownloader?pno=<%=pno%>" height="150" width="150" />
			<h3><%= pname%></h3>
			<h3><%=pcost %>Rs.</h3>
			<form action="ViewProductDetails" method="post">
				<input type="hidden" name="pno" value="<%= pno%>" /> 
				
				<button type="submit">view product</button>
			</form>
			<br>
		</div>
		<br>
			<%}%>
			</div>
</body>
</html>