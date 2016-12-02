<%-- 
    Document   : getStudent
    Created on : Nov 20, 2016, 7:00:00 PM
    Author     : hany
--%>
<%@page import="com.education.models.Course"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.education.models.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div>
    <div>
        <ol class="breadcrumb">
            <li><a href="#"> Home </a></li>
            <li class="active">Add Student</li>
        </ol>
    </div>

    <div>
        <h3>Show Student</h3>
        <hr>
    </div>
</div>

<%
    if((Boolean) request.getAttribute("Error")){
        out.print("Something went Wrong");
    }
    else {
    Student s = (Student) request.getAttribute("StudentData");
%>

<div class="col-xs-12 col-sm-12 col-md-12">
    <div class="col-xs-2 col-sm-2 col-md-2">
        <label for="fname" >Image:</label>
    </div>
    <div class="col-xs-6 col-sm-6 col-md-6">
        <%=s.getFile()%>
    </div>
</div>

<div class="col-xs-12 col-sm-12 col-md-12">
    <div class="col-xs-2 col-sm-2 col-md-2">
        <label for="fname" >First Name:</label>
    </div>
    <div class="col-xs-6 col-sm-6 col-md-6">
        <%=s.getFname()%>
    </div>
</div>

<div class="col-xs-12 col-sm-12 col-md-12">
    <div class="col-xs-2 col-sm-2 col-md-2">
        <label for="fname" >Last Name:</label>
    </div>
    <div class="col-xs-6 col-sm-6 col-md-6">
        <%=s.getLname()%>
    </div>
</div>


<div class="col-xs-12 col-sm-12 col-md-12">
    <div class="col-xs-2 col-sm-2 col-md-2">
        <label for="fname" >Email:</label>
    </div>
    <div class="col-xs-6 col-sm-6 col-md-6">
        <%=s.getEmail()%>
    </div>
</div>



<div class="col-xs-12 col-sm-12 col-md-12">
    <div class="col-xs-2 col-sm-2 col-md-2">
        <label for="fname" >Gender:</label>
    </div>
    <div class="col-xs-6 col-sm-6 col-md-6">
        <%=s.getGender()%>
    </div>
</div>

<div class="col-xs-12 col-sm-12 col-md-12">
    <div class="col-xs-2 col-sm-2 col-md-2">
        <label for="fname" >Age:</label>
    </div>
    <div class="col-xs-6 col-sm-6 col-md-6">
        <%=s.getAge()%>
    </div>
</div>






<div class="col-xs-12 col-sm-12 col-md-12">
    <div class="col-xs-2 col-sm-2 col-md-2">
        <label for="fname" >Interest:</label>
    </div>
    <div class="col-xs-6 col-sm-6 col-md-6">
        <%=s.getInterest()%>
    </div>
</div>
    
    
    <div class="col-xs-12 col-sm-12 col-md-12">
    <div class="col-xs-2 col-sm-2 col-md-2">
        <label for="fname" >Date of Birth:</label>
    </div>
    <div class="col-xs-6 col-sm-6 col-md-6">
                                <%
                                    for (Iterator<Course> i = s.getCourses().iterator(); i.hasNext();) {
                                        Course item = i.next();
                                %>
                                 <%= item.getCoursename()%></option
                                <%
                                    }
                                %>

    </div>
</div>

<% 
}
%>


