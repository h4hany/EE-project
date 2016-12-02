<%-- 
    Document   : ListCourses
    Created on : Nov 19, 2016, 7:02:41 PM
    Author     : hany
--%>

<%@page import="com.education.models.Course"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.lang.ArrayUtils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<Course> list = (List<Course>) request.getAttribute("Courses");%>


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

        <div>
            <div>
                <ol class="breadcrumb">
                    <li><a href="#"> Home </a></li>
                    <li class="active">List Courses</li>
                </ol>
            </div>
            <div>
                <h3>List Courses</h3>
                <hr>
            </div>
        </div>
        <% if (list.isEmpty()) { %>
        No Courses
        <% } else { %>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Course Name</th>
                    <th>Instructor Name</th>

                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (Iterator<Course> i = list.iterator(); i.hasNext();) {
                        Course item = i.next();
                        out.println("<tr>");
                        out.println("<td>" + item.getCoursename() + "</td>");

                        out.println("<td>" + item.getInstructorForCourse().getFname() + "</td>");

                        out.println("<td>" + "<a class='waves-effect waves-light btn' href='./listStudents?CourseId=" + item.getId() + "'>Students</a>" + " | " + "<a class='waves-effect waves-light btn' href='./updateCourse?id=" + item.getId() + "'>Edit</a>" + " | " + "<a class='waves-effect waves-light btn' href='./deleteCourse?id=" + item.getId() + "'>Delete</a>" + "</td>");
                        out.println("</tr>");
                    }
                %>
            </tbody>
        </table>
        <%
            }
        %>

        <%@ include file="/WEB-INF/views/includes/footer.jsp" %>
    </body></html>