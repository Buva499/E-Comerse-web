<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 	<%@page import="java.util.ArrayList" %>
 	<%@page import="java.util.List" %>
 	<%@page import="in.smarttech.model.ImageDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main Product</title>
<link rel="stylesheet" type="text/css" href="css/table.css">
</head>

<body>

		<%
			List<ImageDto> list= (ArrayList<ImageDto>)request.getAttribute("list");
		%>
		
		<table>
			<thead>
				<tr id="header">
					<td>Product Number</td>
					<td>Product Name</td>
					<td>Catagory</td>
					<td>Product Details</td>
					<td>Price</td>
					<td>Product</td>
					<td>Remove</td>
				</tr>
			</thead>
			<%
				for (int i=0;i<list.size();i++){
				ImageDto dto = list.get(i);
				int pno = dto.getPno();
				String pname = dto.getPname();
				String catagory = dto.getCatagory();
				String pdetails = dto.getPdetails();
				int pcost = dto.getPcost();
			%>
				<tr>
					<td><%= pno%></td>
					<td><%= pname%></td>
					<td><%=catagory %></td>
					<td><%=pdetails %></td>
					<td><%=pcost %> Rs.</td>
					<td><img src="./ImageDownloader?pno=<%=pno%>" height="150" width="150"/></td>
					<td>
						<form action="RemoveProduct" method="post">
							<input type="hidden" name="pno" value="<%=pno %>"/>
							<button type="submit">Remove</button>
						</form>
					</td>
			</tr>
			<%}%>
		</table>
</body>
</html>