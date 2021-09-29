<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="CSS/style.css">
<link rel="stylesheet" type="text/css" href="https://drive.google.com/uc?export=view&id=1NSntgDjx0PHoR7pAfETDlhLuH4SiyEXN">
<link href='https://cdn.jsdelivr.net/npm/boxicons@2.0.5/css/boxicons.min.css' rel='stylesheet'>
<title>Admin login form</title>
</head>
<body>
	<div class="login">
		<div class="container">
			
	        <div class="navbar">
	            
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
	        </div>
            <div class="login__content">
                

                <div class="login__forms">
                    <form action="<%=request.getContextPath()%>/loginAdmin" method="post" class="login__registre" id="login-in">
                        <h1 class="login__title">Admin<br>Sign In</h1>
    
                        <div class="login__box"> 
                        	<label for="mailid"><b>mailid</b></label>       
                            <input type="email" name="mailid" placeholder="mailid" class="login__input" required>
                        </div>
    
                        <div class="login__box">
                        	<label for="password"><b>password</b></label>
                            <input type="password" name="password" placeholder="Password" class="login__input" required>
                        </div>


                        <input type="submit" value="Login" class="login__button"/>

                        
                    </form>

                   
                </div>
            </div>
        </div>

        <script src="script/main.js"></script>
</body>
</html>