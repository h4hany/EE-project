<%-- 
    Document   : home
    Created on : Nov 27, 2016, 8:18:27 PM
    Author     : hany
--%>

<%@page import="com.education.controllers.index.CurrentStudent"%>
<%@page import="com.education.models.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Title</title>
        <link rel="stylesheet" href="resources/css/style3.css">

        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

        <link rel="stylesheet" href="resources/css/bootstrap.css">
        <link type="text/css" rel="stylesheet" href="resources/css/materialize.min.css" media="screen,projection"/>

        <script src="resources/js/jquery-1.11.2.js"></script>

        <script src="resources/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="resources/js/materialize.min.js"></script>
        <script src="resources/js/script3.js"></script>


    </head>
    <body>
        <%@include file="includes/header.jsp" %>

    <div style="text-align: center"><h1> Welcome 
                        
                        <%= s.getFname() %>
        </h1></div>
      
    </body>
</html>
