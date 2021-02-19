<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Selected product details</title>
<link rel="stylesheet" type="text/css" href="css/select.css">
<link rel="stylesheet" type="text/css" href="css/footer.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/b.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<link href="http://fonts.googleapis.com/css?family=Cookie" rel="stylesheet" type="text/css">
</head>

<body>
<sql:setDataSource var="abc"
driver="com.mysql.cj.jdbc.Driver"
url="jdbc:mysql://localhost:3306/firstwebsite"
user="root"
password="root123"
/>
<%
HttpSession hs= request.getSession();
int pno = (int) hs.getAttribute("pno");
%>
<sql:query dataSource ="${abc}" var="rs">
select * from product where pno=?;
<sql:param value="${pno}"/>
</sql:query>

			<div class="navbar">
				<div class="logo">
					<img src="images/Group 1.png" width="225px">
				</div>
				<nav>
					<ul id="menuItems">
						<li><a href="./ImageViewerController">Home</a></li>
						<li><a href="about.html">About</a></li>
						<li><a href="contact.html">Contact</a></li>
						<li><a href="CustomerRegister.html">Register Here</a></li>
						
					</ul>
				</nav>
					<a href="./ViewCart"><img src="images/cart1.png" width="50px"
					height="50px" /></a>
				<div class="menu-icon" onclick="menutoggle()">
					<img src="images/menu2.png" width="40px" height="40px" />
				</div>
			</div>

<div class="container" align="center">
<img src="./DownloadProduct" width="400px" height="400px" />

<c:forEach var="i" items="${rs.rows}"> 

<h2>Product Name: <c:out value="${i.pname}" /></h2>
<h2>Product Details : <c:out value="${i.pdetails}" /></h2>
<h2>Cost: <c:out value="${i.pcost}" /> Rs/-</h2>
<br>
		<form action="AddCart" method="post">
	 		<input type="number" id="quantity" name="qty" min="1" max="10" required="required"
	 		placeholder="Quantity"/>
	 		<input type="hidden" name="pno" value="<c:out value="${i.pno}" />"/><br><br>
	 		<button type="submit">add cart</button>
		</form>
 
		<form action="Checkout" method="post">
			<input type="hidden" name="pno" value="<c:out value="${i.pno}" />"/>
	 		<button type="submit">checkout</button>
		</form>
		<br>
</c:forEach>
</div>

<footer class="footer-distributed">

			<div class="footer-left">

				<h3>Perfect Sublimation Printings<br><span>Arif Kalawant</span></h3>

				<p class="footer-links">
					<a href="./ImageViewerController">Home</a>
					·
					<a href="about.html">About</a>
					·
					<a href="#">Pricing</a>
					·
					<a href="./ImageViewerController">product</a>
					·
					<a href="#">Contact</a>
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
		var menuItems = document.getElementById("menuItems");
		menuItems.style.maxHeight = "0px";
		function menutoggle() {
			if (menuItems.style.maxHeight == "0px") {
				menuItems.style.maxHeight = "200px"
			} else {
				menuItems.style.maxHeight = "0px"
			}
		}
	</script>
</body>
</html>