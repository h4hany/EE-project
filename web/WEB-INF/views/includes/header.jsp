
<%@page import="com.education.controllers.index.CurrentUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    try{
     CurrentUser s = null;
    if(session.getAttribute("currentUser") != null){
    
      s = (CurrentUser) session.getAttribute("currentUser");                         
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
    <%if(s.getType() == 0)
    {%>
    <li><a href="./listCourses?StudId=<%= s.getId() %>" class="btn btn-default">List Courses</a></li>

    <% }else{
    %>
    
    <li><a href="./addStudent" class="btn btn-default">Add Student</a></li>
    <li><a href="./listStudents" class="btn btn-default">List Student</a></li>
    <li><a href="./addCourse" class="btn btn-default">Add course</a></li>
    <li><a href="./listCourses" class="btn btn-default">List Courses</a></li>
    <li><a href="./addInstructor" class="btn btn-default">Add Instructor</a></li>
    <li><a href="./listInstructors" class="btn btn-default">List Instructor</a></li>
    <% } %>
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