<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
<link rel="stylesheet" type="text/css" href="https://drive.google.com/uc?export=view&id=1NSntgDjx0PHoR7pAfETDlhLuH4SiyEXN">
</head>
<body>
	
	<%response.setHeader("Cache-Control","no-cache, no-store,must-revalidate"); %>
	<div class="navbar">
	         <nav>
	              <div class="logo-head">
	              	<img src="https://lh3.googleusercontent.com/d/1TfZiCp-jWQfIKY757u8nvzSr0vePB7-h">
	            	</div>
	                <ul>
	                    <li><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></li>
	                </ul>
	         </nav>
	 </div>
	 <div class="contents">
            <div class="container">
				<div class="welcome-text" align="left">	  			
					<br><br>
					<h2>Form Submitted successfully!</h2>
					<br><br>
					<a href ="adminPage.jsp">Go back</a>
				</div>
			</div>
		</div>		
</body>
</html>