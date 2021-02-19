<%@page import="in.smarttech.model.Model"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 	<%@page import="java.util.ArrayList" %>
 	<%@page import="java.util.List" %>
 	<%@page import="in.smarttech.model.YourOrderDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Ordered Products</title>
<link rel="stylesheet" type="text/css" href="css/table.css">
</head>

<body>
	
		<%
			List<YourOrderDto> list= (ArrayList<YourOrderDto>)request.getAttribute("list");
			boolean ls = list.isEmpty();
			if(ls==true){
				out.println("<h1>");
				out.println("No Ordered History");
				out.println("</h1>");
			}
		%>
		
		<table >
			
			<%
				HttpSession hs = request.getSession();
				Model m = new Model();
				for (int i=0;i<list.size();i++){
				YourOrderDto dto = list.get(i);
				String fname = dto.getFname();
				String lname = dto.getLname();
				String phone = dto.getPhone();
				String address = dto.getAddress();
				int qty = dto.getQty();
				String modelno = dto.getModelno();
				String size = dto.getSize();
				String other = dto.getOther();
				String paymode = dto.getPaymode();
				int custid = dto.getCustid();
				int pno = dto.getPno();
				int tcost = dto.getTcost();
				m.setPno(pno);
				m.setCustid(custid);
				String ostatus = null;
				boolean status = m.getStatus();
				if(status==true){
					ostatus = m.getOstatus();
				}
			%>
					<tr>
						<td><%= fname%></td>
						<td><%= lname%></td>
						<td><%= phone%></td>
						<td><%= address%></td>
						<td><%= qty%> Qty</td>
						<%
							if(modelno!=null && size==null && other==null){%>
								<td><%= modelno%></td>
							<%}
							else if(size!=null && modelno==null && other==null){%>
								<td><%= size%></td>
							<%}
							else{ %>
								<td><%= other%></td>
							<%}
						%>
						<td><%= paymode%></td>
						<td><%= tcost%> Rs</td>
						
						<td><img src="./OldAdminDownload?pno=<%=pno%>,<%=custid %>" height="150" width="150" alt="No Image" /></td>
						<td>
							<a href="./OldAdminDownload?pno=<%=pno%>,<%=custid %>" download>
							 	<button>Download</button>
							</a>
						</td>
						<td><%= ostatus%></td>
						<td>
							<form action="UpdateStatus" method="post">
								<input type="hidden" name ="pno" value="<%= pno%>" />
								<input type="hidden" name ="custid" value="<%= custid%>" />
								<button type="submit" class="btn">update status</button>
							</form>
						</td>
						
					</tr>
			<%}%>
			
		</table>
	
	
</body>
</html>