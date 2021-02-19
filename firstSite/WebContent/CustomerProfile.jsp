<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>your profile</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/b.css">
	<link rel="stylesheet" type="text/css" href="css/footer.css">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
    <link href="http://fonts.googleapis.com/css?family=Cookie" rel="stylesheet" type="text/css">
</head>
<style>
	.container3{
	padding-left: 25px;
	padding-right: 25px;
	margin: auto;
	padding-top: 5%;
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
						<!-- <li><a href="./ViewCart">Cart</a></li> -->
						<li><a href="./CustomerLogout">Logout</a></li>
					</ul>
				</nav>
				<a href="./ViewCart"><img src="images/cart1.png" width="50px" height="50px" /></a>
				<div class="menu-icon" onclick="menutoggle()">
					<img src="images/menu2.png" width="40px" height="40px"/>
				</div>
			</div>
	<%
	HttpSession hs = request.getSession();
	String email = (String) hs.getAttribute("cemail");
	String phone = (String) hs.getAttribute("cphone");
	String name = (String) hs.getAttribute("cname");
	%>
	
	<div class="container3" align="center">
		<h2>Name: <%=name %></h2>
		<h2>Email: <%=email %></h2>
		<h2>Phone: <%=phone %></h2>
		<a href="EditProfile.jsp"><button>Edit</button></a>
	</div><br>
	
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
</html>