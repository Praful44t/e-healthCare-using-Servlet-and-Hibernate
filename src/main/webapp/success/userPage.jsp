<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Page</title>

<link rel="stylesheet" type="text/css" href="https://drive.google.com/uc?export=view&id=1NSntgDjx0PHoR7pAfETDlhLuH4SiyEXN">
<script src='jquery-3.6.0.min.js'>
    </script>

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
					<h1>You have logged in!</h1>
		  			<%String firstName=(String)session.getAttribute("firstName");
		  			  String lastName=(String)session.getAttribute("lastName");
		  			  String fullName = firstName+" "+lastName;%>
					<h2>Welcome <%=fullName%></h2>
					<br><br>
				</div>
				<div class="buttons">
					<button class="button" href="#" onclick="show('popup')">Book Appointment?</button>
	        			<div class="popup" id="popup">
	        				<form action="<%=request.getContextPath()%>/appointment" method="post">
		        				<div class="login__box">
		        				<label for="doa"><b>Date</b></label>
		                            <input type="date" name="doa" class="login__input" required>
		                        </div>
		    					<br>
		                        <div class="login__box">
		                        	<label for="doctor"><b>Doctor</b></label>
		                            <input type="text" name="doctor" placeholder="doctor" class="login__input" required>
		                        </div>
		                        <br>
		                        <div class="login__box">
		                        	<label for="uid"><b>uid</b></label>
		                            <input type="number" name="uid" placeholder="uid" class="login__input" required>
		                        </div>
		                        <br><br>
		                        <input type="submit" value="Submit">
	                        </form>
					        <a href="#" onclick="hide('popup')">Close</a>
	    				</div>
    			
    			
    			<button class="button2" href="#" onclick="show('popup2')">Book a room</button>
        			<div class="popup2" id="popup2">
        				<form action="<%=request.getContextPath()%>/booking" method="post">
	        				<div class="login__box">
	        					<label for="room-no"><b>Room No</b></label>
	                            <input type="number" name="room-no" class="login__input" required>
	                        </div>
	                        <br>
	    					<div class="login__box">
	        					<label for="pid"><b>pid</b></label>
	                            <input type="number" name="pid" class="login__input" required>
	                        </div>
	                        <br>
	                        <br>
	                        <input type="submit" value="Submit">
                        </form>
				        <a href="#" onclick="hide('popup2')">Close</a>
    				</div>	
				</div>
			</div>
		</div>		
		
</body>
</html>