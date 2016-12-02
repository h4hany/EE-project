<%-- 
    Document   : ListStudents
    Created on : Nov 19, 2016, 7:02:41 PM
    Author     : mohamedk
--%>

<%@page import="com.education.models.Student"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.lang.ArrayUtils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
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
            <% List<Student> list = (List<Student>) request.getAttribute("Students"); %>
            <div>

                <nav>
                    <div class="nav-wrapper">
                        <div class="col s12">
                            <a href="#!" class="breadcrumb">Home</a>
                            <a href="#!" class="breadcrumb active">List Student</a>
                        </div>
                    </div>
                </nav>

                <div>
                    <h3>List Student</h3>
                    <hr>
                </div>
            </div>
            <% if (list.isEmpty()) { %>
            No Students
            <% } else { %>
            <table class="table table-striped table-responsive">
                <thead>
                    <tr>
                        <th>Image</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Gender</th>
                        <th>Interest</th>
                        <th>Age</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>

                    <%
                        for (Iterator<Student> i = list.iterator(); i.hasNext();) {
                            Student item = i.next();
                            out.println("<tr>");
                            out.println("<td><img style='width:40px;hight:40px;' src='./" + item.getFile() + "'/></td>");
                            out.println("<td>" + item.getFname() + "</td>");
                            out.println("<td>" + item.getLname() + "</td>");
                            out.println("<td>" + item.getEmail() + "</td>");
                            out.println("<td>" + item.getGender() + "</td>");
                            out.println("<td>" + item.getInterest() + "</td>");
                            out.println("<td>" + item.getAge() + "</td>");

                            out.println("<td>" + "<a class='waves-effect waves-light btn' href='./listCourses?StudId=" + item.getId() + "'>Courses</a>" + " | " + "<a class='waves-effect waves-light btn' href='./updateStudent?id=" + item.getId() + "'>Edit</a>" + " | " + "<a class='waves-effect waves-light btn' href='./deleteStudent?id=" + item.getId() + "'>Delete</a>" + "</td>");
                            out.println("</tr>");
                        }
                    %>
                </tbody>
            </table>
            <%
                }
            %>
        </div>
    </div>
    <br><br><br><br><br><br><br><br><br>
    <div class="container">
        <%@ include file="/WEB-INF/views/includes/footer.jsp" %>

    </div>


</body>
</html>
