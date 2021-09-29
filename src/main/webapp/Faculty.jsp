<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="CSS/style.css">
<link rel="stylesheet" type="text/css" href="https://drive.google.com/uc?export=view&id=1NSntgDjx0PHoR7pAfETDlhLuH4SiyEXN">
<link href='https://cdn.jsdelivr.net/npm/boxicons@2.0.5/css/boxicons.min.css' rel='stylesheet'>
<Title>Employee login and Registration form</Title>
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
                    <form action="<%=request.getContextPath()%>/LoginFaculty" method="post" class="login__registre" id="login-in">
                        <h1 class="login__title">Faculty<br>Sign In</h1>
    					
                        <div class="login__box">
                        	<label for="mailid"><b>email</b></label>
                            <input type="email" name="mailid" placeholder="Email" class="login__input" required>
                        </div>
    
                        <div class="login__box">
                        	<label for="password"><b>password</b></label>
                            <input type="password" name="password" placeholder="Password" class="login__input" required>
                        </div>

                        <input type="submit" value="Login" class="login__button"/>
                        
                        <div>
                            <span class="login__account">Don't have an Account ?</span>
                            <span class="login__signin" id="sign-up">Sign Up</span>
                      	</div>
                    </form> 
                        
                    
                    <form action="<%=request.getContextPath()%>/registerEmp" method="post" class="login__create none" id="login-up">
                        <h1 class="login__title">Create Employee Account</h1>
                        
                        <div class="login__box">
                        	<label for="mailid"><b>email</b></label>
                            <input type="email" name="mailid" placeholder="Email" class="login__input" required>
                        </div>
                        
                        <div class="login__box">
                        	<label for="password"><b>password</b></label>
                            <input type="password" name="password" placeholder="Password" class="login__input" required>
                        </div>
    
                        <div class="login__box">
                        	<label for="firstName"><b>First Name</b></label>
                            <input type="text" name="firstName" placeholder="firstName" class="login__input" required>
                        </div>
                        <div class="login__box">
                        	<label for="lastName"><b>Last Name</b></label>
                            <input type="text" name="lastName" placeholder="lastName" class="login__input" required>
                        </div>
                        
                        <div class="login__box">
                        	<label for="age"><b>Age</b></label>
                            <input type="number" name="age" placeholder="Age" class="login__input" required>
                        </div>
                        
                        <div class="login__box">
                        	<label for="phone"><b>Phone</b></label>
                            <input type="number" name="phone" placeholder="phone" class="login__input" required>
                        </div>

                        
                        <input type="submit" value="Signup" class="login__button"/>

                        <div>
                            <span class="login__account">Already have an Account ?</span>
                            <span class="login__signup" id="sign-in">Sign In</span>
                        </div>
                    </form>

                   
                </div>
            </div>
            </div>
  
        <script src="script/main.js"></script>
</body>
</html>