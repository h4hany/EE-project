<%-- 
    Document   : index
    Created on : Nov 27, 2016, 3:09:26 PM
    Author     : hany
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bootstrap Modal Login Form Template</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="resources/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="resources/css/form-elements.css">
        <link rel="stylesheet" href="resources/css/style.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="resources/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="resources/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="resources/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="resources/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="resources/ico/apple-touch-icon-57-precomposed.png">

    </head>

    <body id="mybody">

        <!-- Content -->
        <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                	
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                        	<a class="logo" href="index.html"></a>
                                <h1 style="color:black"><strong style="color: black">Education System Course Application</strong></h1>
                            <div class="description">
                            	<p>
	                            	This is a free responsive modal login form made with Bootstrap. 
	                            	Download it on <a href="http://azmind.com"><strong>AZMIND</strong></a>, customize and use it as you like!
                            	</p>
                            </div>
                                
                            <%
                            try{
                            if((Boolean) request.getAttribute("Error"))
                            out.print("<h1><strong style='color: black'>Login Data is wrong</strong></h1>");
                            }
                            catch(Exception e)
                            {
                            }
                            %>
                            <div class="top-big-link">
                            	<a class="btn btn-link-1 launch-modal" href="#" data-modal-id="modal-login-inst">Instructor Login</a>
                            </div>
                                
                            <div class="top-big-link">
                            	<a class="btn btn-link-1 launch-modal" href="#" data-modal-id="modal-login-stud">Student Login</a>
                            </div>
                        </div>
                    </div>
                    
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 social-login">
                        	<h3>...or login with:</h3>
                        	<div class="social-login-buttons">
	                        	<a class="btn btn-link-2" href="#">
	                        		<i class="fa fa-facebook"></i> Facebook
	                        	</a>
	                        	<a class="btn btn-link-2" href="#">
	                        		<i class="fa fa-twitter"></i> Twitter
	                        	</a>
	                        	<a class="btn btn-link-2" href="#">
	                        		<i class="fa fa-google-plus"></i> Google Plus
	                        	</a>
                        	</div>
                        </div>
                    </div>
                    
                </div>
            </div>
            
        </div>
        
        <!-- MODAL -->
        <div class="modal fade" id="modal-login-inst" tabindex="-1" role="dialog" aria-labelledby="modal-login-label" aria-hidden="true">
        	<div class="modal-dialog">
        		<div class="modal-content">
        			
        			<div class="modal-header">
        				<button type="button" class="close" data-dismiss="modal">
        					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
        				</button>
        				<h3 class="modal-title" id="modal-login-label">Instructor Login</h3>
        				<p>Enter your username and password to log on:</p>
        			</div>
        			
        			<div class="modal-body">
        				
	                    <form role="form" action="./LoginInstructor" method="post" class="login-form">
	                    	<div class="form-group">
	                    		<label class="sr-only" for="form-username">Email</label>
	                        	<input type="text" name="form-username" placeholder="Username..." class="form-username form-control" id="form-username">
	                        </div>
	                        <div class="form-group">
	                        	<label class="sr-only" for="form-password">Password</label>
	                        	<input type="password" name="form-password" placeholder="Password..." class="form-password form-control" id="form-password">
	                        </div>
	                        <button type="submit" class="btn">Sign in!</button>
	                    </form>
	                    
        			</div>
        			
        		</div>
        	</div>
        </div>

        
        
        
                <!-- MODAL -->
        <div class="modal fade" id="modal-login-stud" tabindex="-1" role="dialog" aria-labelledby="modal-login-label" aria-hidden="true">
        	<div class="modal-dialog">
        		<div class="modal-content">
        			
        			<div class="modal-header">
        				<button type="button" class="close" data-dismiss="modal">
        					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
        				</button>
        				<h3 class="modal-title" id="modal-login-label">Student Login</h3>
        				<p>Enter your username and password to log on:</p>
        			</div>
        			
        			<div class="modal-body">
        				
	                    <form role="form" action="./LoginStudent" method="post" class="login-form">
	                    	<div class="form-group">
	                    		<label class="sr-only" for="form-username">Email</label>
	                        	<input type="text" name="form-username" placeholder="Username..." class="form-username form-control" id="form-username">
	                        </div>
	                        <div class="form-group">
	                        	<label class="sr-only" for="form-password">Password</label>
	                        	<input type="password" name="form-password" placeholder="Password..." class="form-password form-control" id="form-password">
	                        </div>
	                        <button type="submit" class="btn">Sign in!</button>
	                    </form>
	                    
        			</div>
        			
        		</div>
        	</div>
        </div>

        <!-- Javascript -->
        <script src="resources/js/jquery-1.11.1.min.js"></script>
        <script src="resources/bootstrap/js/bootstrap.min.js"></script>
        <script src="resources/js/jquery.backstretch.min.js"></script>
        <script src="resources/js/scripts.js"></script>
        
        <!--[if lt IE 10]>
            <script src="resources/js/placeholder.js"></script>
        <![endif]-->

    </body>

</html>