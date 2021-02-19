<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="java.util.ArrayList" %>
 	<%@page import="java.util.List" %>
 	<%@page import="in.smarttech.model.ImageDto" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Perfect Sublimation | Ecomerse Website</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/a.css">
	<link rel="stylesheet" type="text/css" href="css/footer.css">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
    <link href="http://fonts.googleapis.com/css?family=Cookie" rel="stylesheet" type="text/css">
</head>

<body>
<%
		HttpSession hs = request.getSession();
		String cname = (String) hs.getAttribute("cname");
	%>
	<div class="header">
		<div class="container">
			<div class="navbar">
				<div class="logo">
					<img src="images/Group 1.png" width="225px">
				</div>
				<h3 style="color:white;">Welcome <%=cname %></h3>
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
				<a href="./ViewCart"><img src="images/cart1.png" width="50px" height="50px" /></a>
				<div class="menu-icon" onclick="menutoggle()">
					<img src="images/menu2.png" width="40px" height="40px"/>
				</div>
			</div>
			<div class="row">
				<div class="col-2">
					<h1>Perfect Sublimation Printings </h1><br>
						<h2>Store your memories with you!</h2>
					
					<a href="./ImageViewerController" class="btn">Explore Now &#8594</a>
				</div>
				<div class="col-2">
					<img src="images/8.png">
				</div>
			</div>
		</div>
	</div>
	<%
			List<ImageDto> list= (ArrayList<ImageDto>)request.getAttribute("list");
		%>
		<h1 align="center" id="pro">Featured Products</h1>
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
	<!------------offer----------->
	<div class="offer">
		<div class="small-container">
			<div class="row">
				<div class="col-0">
					<img src="images/9.png" class="offer-image">
				</div>
				<div class="col-0">
					<p>Exclusively Available the similar kind of Mobile Covers on Store</p>
					<h1>Perfect Sublimation</h1>
					<small>We provide mobile cover prints for all the mobile phones cover with awesome printed
						design.</small>
					<div><a href="./ImageViewerController" class="btn"> Buy Now &#8594</a> </div>
				</div>
			</div>
		</div>
	</div>
	<!------------footer------------>
	<footer class="footer-distributed">

			<div class="footer-left">

				<h3>Perfect Sublimation Printings<br><span>Arif Kalawant</span></h3>

				<p class="footer-links">
					<a href="./CustomerImageViewerController">Home</a>
					·
					<a href="about.html">About</a>
					·
					<a href="#">Pricing</a>
					·
					<a href="#pro">product</a>
					·
					<a href="contact.html">Contact</a>
					·
					<a href="#">Privacy Policies</a>
				</p>

				<p class="footer-company-name">Perfect Sublimation Printings</p>
			</div>

			<div class="footer-center">

				<div>
					<i class="fa fa-map-marker"></i>
					<p><span>Near Ambai Bazar</span> Rendal_Hupari.Kolhapur,India</p>
				</div>

				<div>
					<i class="fa fa-phone"></i>
					<p>+919356347575</p>
				</div>

				<div>
					<i class="fa fa-envelope"></i>
					<p><a href="mailto:perfectsublimations@gmail.com">perfectsublimations@gmail.com</a></p>
				</div>

			</div>

			<div class="footer-right">

				<p class="footer-company-about">
					<span>About the company</span>
					We provide customized product on the demands of our customer for store there memories.
				</p>

				<div class="footer-icons">

					<a href="#"><i class="fa fa-facebook"></i></a>
					<a href="#"><i class="fa fa-twitter"></i></a>
					<a href="#"><i class="fa fa-linkedin"></i></a>
					<a href="#"><i class="fa fa-github"></i></a>

				</div>

			</div>

		</footer>
	<!--------------------js for toggle menu--------->
	<script>
		var menuItems= document.getElementById("menuItems");
		menuItems.style.maxHeight ="0px";
		function menutoggle(){
			if(menuItems.style.maxHeight == "0px")
			{
				menuItems.style.maxHeight = "200px"
			}
			else
			{
				menuItems.style.maxHeight = "0px"
			}
		}
	</script>
</body>
</body>
</html>