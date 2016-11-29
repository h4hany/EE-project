<%-- 
    Document   : ListInstructors
    Created on : Nov 19, 2016, 7:02:41 PM
    Author     : hany
--%>

<%@page import="com.education.models.Instructor"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.lang.ArrayUtils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<Instructor> list = (List<Instructor>) request.getAttribute("Instructors"); %>

<!DOCTYPE html>
<html lang="en">
    <head>

        <meta charset="UTF-8">
        <title>Title</title>
        <link rel="stylesheet" href="resources/css/style3.css">

        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

        <link rel="stylesheet" href="resources/css/bootstrap.css">
        <link type="text/css" rel="stylesheet" href="resources/css/materialize.min.css" media="screen,projection"/>
        <link rel="stylesheet" href="resources/css/demo.css">
        <link rel="stylesheet" href="resources/css/footer-distributed-with-address-and-phones.css">
        <link rel="stylesheet" href="resources/css/multi-select.css">

        <script src="resources/js/jquery-1.11.2.js"></script>

        <script src="resources/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="resources/js/materialize.min.js"></script>
        <script src="resources/js/script3.js"></script>
        <script src="resources/js/multi-select.js"></script>



    </head>

    <body>
<%@ include file="/WEB-INF/views/includes/header.jsp" %>

<div class="container">
   <div>

                <nav>
                    <div class="nav-wrapper">
                        <div class="col s12">
                            <a href="#!" class="breadcrumb">Home</a>
                            <a href="#!" class="breadcrumb active">List Instructor</a>
                        </div>
                    </div>
                </nav>

                <div>
                    <h3>List Instructor</h3>
                    <hr>
                </div>
            </div>
<% if (list.isEmpty()) { %>
No Instructors
<% } else { %>
<table class="table table-striped">
    <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>

            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <%
            for (Iterator<Instructor> i = list.iterator(); i.hasNext();) {
                Instructor item = i.next();
                out.println("<tr>");
                out.println("<td>" + item.getFname() + "</td>");
                out.println("<td>" + item.getLname() + "</td>");

                out.println("<td>" + "<a class='waves-effect waves-light btn' href='./updateInstructor?id=" + item.getId() + "'>Edit</a>" + " | " + "<a class='waves-effect waves-light btn' href='./deleteInstructor?id=" + item.getId() + "'>Delete</a>" + "</td>");
                out.println("</tr>");
            }
        %>
    </tbody>
</table>
<%
    }
%>
</div>
  <br><br><br><br><br><br><br><br><br>
    <div class="container">
        <%@ include file="/WEB-INF/views/includes/footer.jsp" %>

    </div>
</body>
</html>