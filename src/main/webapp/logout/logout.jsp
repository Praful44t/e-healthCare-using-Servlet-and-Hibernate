<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout Page</title>
<link rel="stylesheet" href="CSS/main.css">
</head>
<body>
	<div class="container">
		
        <div class="navbar">
            <%response.setHeader("Cache-Control","no-cache, no-store,must-revalidate"); %>
            <nav>
            	<div class="logo-head">
            	<img src="https://lh3.googleusercontent.com/d/1TfZiCp-jWQfIKY757u8nvzSr0vePB7-h">
            	</div>
                <ul>
                    <li><a href ="index.jsp">Home</a></li>
                    <li><a href ="About.jsp">About</a></li>
                    <li><a href ="admin.jsp">Admin</a></li>
                    <li><a href ="User.jsp">User</a></li>
                    <li><a href ="Faculty.jsp">Faculty</a></li>
                </ul>
            </nav>
        </div>
	<div class="logout" align="left">
		<h1>You have logged out of Session!</h1>
	</div>	
</body>
</html>