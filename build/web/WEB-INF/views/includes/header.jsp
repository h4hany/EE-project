<%-- 
    Document   : header
    Created on : Nov 19, 2016, 5:56:43 PM
    Author     : hany
--%>

<%@page import="com.education.controllers.index.CurrentStudent"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    try{
     CurrentStudent s = null;
    if(session.getAttribute("currentUser") != null){
    
      s = (CurrentStudent) session.getAttribute("currentUser");                         
    }
                        
%>
                        
<ul id="slide-out" class="side-nav">
    <li>
        <div class="userView">
            <img class="background" src="resources/img/img1.jpg">
            <a href="#!user"><img class="circle" src="resources/img/pro.jpg"></a>
            <a href="#!name"><span class="white-text name"> <%= s.getFname() %> <%= s.getLname() %></span></a>
            <a href="#!email"><span class="white-text email"> <%= s.getEmail() %></span></a>
        </div>
    </li>
    <li><a href="#" class="btn btn-default">Setting</a></li>
    <li><a href="# " class="btn btn-danger">home</a></li>
    <li>
        <div class="divider"></div>
    </li>
    <li><a class="subheader">Subheader</a></li>
    <li><a class="waves-effect btn btn-flat " href="#!" style="color: white;">More Option</a></li>
</ul>
<nav class="navbar navbar-inverse sidebar" role="navigation">

    <div class="navbar-header">

        <button href="#" data-activates="slide-out" class="btn button-collapse" style="display: block;margin-left: 5%;
    margin-top: 4%;">
            <span class="glyphicon glyphicon-home" aria-hidden="true"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>

        </button>
     
    </div>
        <ul class="nav navbar-nav navbar-right">
      <li><a href="logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    </ul>
</nav>
<% }catch(Exception e){
response.sendRedirect("./index");
//out.print("error");
} %>