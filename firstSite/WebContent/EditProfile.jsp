<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Perfect Sublimation | E-comerse Website</title>
    <link rel="stylesheet" type="text/css" href="css/logsign.css">
</head>

<body>
	<%
	HttpSession hs = request.getSession();
	String email = (String) hs.getAttribute("cemail");
	String phone = (String) hs.getAttribute("cphone");
	String name = (String) hs.getAttribute("cname");
	String cpassword = (String) session.getAttribute("cpassword");
	%>
	
    <div class="header">
        <div class="container">
            <div class="navbar">
                <div class="logo">
                    <img src="images/Group 1.png" width="225px">
                </div>
                <nav>
            
                </nav>
            </div>
        </div>
    <div>
        <div class="sign-up">
            <h1>Welcome</h1>
              <form action="CustomerEditProfile" method="post">
                <input type="text" name="cname"  value="<%=name %>"/>
                <input type="text" name="cphone"   value="<%=phone %>"/>
                <input type="email" name="cemail"  value="<%=email %>"/>                
                <input type="password" name="cpassword"  value="<%= cpassword%>"/>
                <button type="submit" class="btn btn-primary btn-block btn-large">Save Changes</button>
                
              </form>
          </div>
          
</body>
