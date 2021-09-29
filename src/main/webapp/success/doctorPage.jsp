<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Faculty Page</title>
<link rel="stylesheet" type="text/css" href="https://drive.google.com/uc?export=view&id=1NSntgDjx0PHoR7pAfETDlhLuH4SiyEXN">
</head>
<body>
	<script >
		$ = function(id) {
	        return document.getElementById(id);
	    	}
	
	    var show = function(id) {
	        $(id).style.display ='block';
	    	}
	    var hide = function(id) {
	        $(id).style.display ='none';
	    	}
	</script>
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
				<div class="welcome-text" align="left" >
					<h1>You have logged in successfully!</h1>
			  			
			  		<%String full_name=(String)session.getAttribute("fname")+" "+(String)session.getAttribute("lname");%>
					<h2>Welcome <%=full_name%></h2>
					<br><br>
				</div>
			</div>		
	</div>
	<div class="buttons">
					<button class="button" href="#" onclick="show('popup')">Update Availablity</button>
	        			<div class="popup" id="popup">
	        				<form action="<%=request.getContextPath()%>/availDoc" method="post">
	        					<div class="login__box">
	        						<label for="available"><b>available</b></label>
	                            	<input list="dept" placeholder="available" name="available" id="department" class="login__input" required>
									<datalist id="dept">
									  <option value="true">
									  <option value="false">
									</datalist>
	                        	</div>
	                        	<div class="login__box">
	        					<label for="password"><b>password</b></label>
	                            <input type="password" name="password" class="login__input" required>
	                        </div>
		        				<br><br>
		                        <input type="submit" value="proceed">
	                        </form>
					        <a href="#" onclick="hide('popup')">Close</a>
	    				</div>
    			
    			<button class="button1" href="#" onclick="show('popup1')">Update Session Details</button>
        			<div class="popup1" id="popup1">
        				<form action="<%=request.getContextPath()%>/docSession" method="post">
	                        <div class="login__box">
	        					<label for="session"><b>Consultancy details</b></label>
	                            <input type="text" name="session" class="login__input" required>
	                        </div>
	                        <br>
	                        <div class="login__box">
	        					<label for="password"><b>password</b></label>
	                            <input type="password" name="password" class="login__input" required>
	                        </div>	
	                        <br><br>
	                        <input type="submit" value="proceed">
                        </form>
        				
				        <a href="#" onclick="hide('popup1')">Close</a>
    				</div>	
    				
    			<button class="button2" href="#" onclick="show('popup2')">Update Consultancy Fees</button>
        			<div class="popup2" id="popup2">
        				<form action="<%=request.getContextPath()%>/feeServlet" method="post">
	        				<div class="login__box">
	        					<label for="fees"><b>new amount</b></label>
	                            <input type="number" name="fees" class="login__input" required>
	                        </div>
	                        <br>
	                        <div class="login__box">
	        					<label for="password"><b>password</b></label>
	                            <input type="password" name="password" class="login__input" required>
	                        </div>
	                        <br>
	                        <input type="submit" value="proceed">
                        </form>
				        <a href="#" onclick="hide('popup2')">Close</a>
    				</div>	
				</div>
    </body>
</body>
</html>