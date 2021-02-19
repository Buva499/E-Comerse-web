<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 	<%@page import="java.util.ArrayList" %>
 	<%@page import="java.util.List" %>
 	<%@page import="in.smarttech.model.ViewCartDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Cart</title>
<link rel="stylesheet" type="text/css" href="css/table.css">

<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/b.css">

</head>
<style>
	h1{
		background-color: white;
		color: black;
	}
</style>
<body>
	<div class="navbar">
				<div class="logo">
					<img src="images/Group 1.png" width="225px">
				</div>
				<nav>
					<ul id="menuItems">
						<li><a href="./CustomerImageViewerController">Home</a></li>
						<li><a href="about.html">About</a></li>
						<li><a href="contact.html">Contact</a></li>
						<li><a href="./YourOrder">Order</a></li>
						<li><a href="./CustomerProfile">Profile</a></li>
						<li><a href="./CustomerLogout">Logout</a></li>
						
					</ul>
				</nav>
					<a href="./ViewCart"><img src="images/cart1.png" width="50px"
					height="50px" /></a>
				<div class="menu-icon" onclick="menutoggle()">
					<img src="images/menu2.png" width="40px" height="40px" />
				</div>
			</div>
		<%
			List<ViewCartDto> list= (ArrayList<ViewCartDto>)request.getAttribute("lst");
			boolean empty = list.isEmpty();
			if(empty ==true){
				out.println("<h1>");
				out.println("Your Cart is Empty.");
				out.println("<h1>");
			}
		%>
		
		<table>
			
			<%
				for (int i=0;i<list.size();i++){
				ViewCartDto dto = list.get(i);
				int custid = dto.getCustid();
				int pno = dto.getPno();
				int qty = dto.getQty();
				int tcost = dto.getTcost();
				
			%>
					<tr>
						<td><%= qty%> Qty</td>
						<td><%= tcost%> Rs</td>
						
						<td><img src="./DownloadCartProduct?pno=<%=pno%>" height="150" width="150" alt="No Image" /></td>
						<td>
							<form action="RemoveFromCart" method="post">
								<input type="hidden" name ="pno" value="<%= pno%>" />
								<button type="submit">remove</button>
							</form>
						</td>
						<td>
							<form action="Checkout" method="post">
								<input type="hidden" name="pno" value="<%= pno%>"/>
						 		<button type="submit">checkout</button>
							</form>
						</td>
					</tr>
			<%}%>
			
		</table><br>
		
</body>
</html>