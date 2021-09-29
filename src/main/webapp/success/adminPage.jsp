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
	 <%response.setHeader("Cache-Control","no-cache, no-store,must-revalidate"); %>
            <div class="container">
				<div align="left">
					<h1>You have logged in successfully!</h1>
			  			
					<h2>Welcome Admin</h2>
					<br><br>
					
				</div>
					<div class="buttons">
					<button class="button" href="#" onclick="show('popup')">Show Room Usage</button>
	        			<div class="popup" id="popup">
	        				<form action="<%=request.getContextPath()%>/roomDisplay" method="post">
		        				<br><br>
		                        <input type="submit" value="proceed">
	                        </form>
					        <a href="#" onclick="hide('popup')">Close</a>
	    				</div>
    			
    			
    				
    				<button class="button2" href="#" onclick="show('popup1')">Show total Faculty</button>
	        			<div class="popup2" id="popup2">
	        				<form action="<%=request.getContextPath()%>/totalFaculty" method="post">
		        				<br><br>
		                        <input type="submit" value="proceed">
	                        </form>
					        <a href="#" onclick="hide('popup1')">Close</a>
	    				</div>
    				
				</div>
			</div>
		</div>	
    </body>
</body>
</html>