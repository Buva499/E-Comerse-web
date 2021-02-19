<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Checkout product</title>
<link rel="stylesheet" type="text/css" href="css/select.css">

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
<div align="center">

<div class="container" align="center">

<img src="./DownloadProduct" width="500px;" height="500px;"/>

<c:forEach var="i" items="${rs.rows}"> 

<h2>Product Name: <c:out value="${i.pname}" /></h2>

<h2>Product Details: <c:out value="${i.pdetails}" /></h2>

<h2>Cost: <c:out value="${i.pcost}" /> Rs/-</h2>

<a href="CheckoutForm.jsp"><button>Proceed</button></a>
</c:forEach>

</div>
</div>
</body>
</html>