<%-- 
    Document   : getStudent
    Created on : Nov 20, 2016, 7:00:00 PM
    Author     : hany
--%>

<%@page import="java.util.Iterator"%>
<%@page import="com.education.models.Instructor"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.lang.ArrayUtils"%>
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


        <%
            String courseError = ((Boolean) request.getAttribute("course-error")) ? "block" : "none"; //false;

            List<Instructor> list = (List<Instructor>) request.getAttribute("li");

         
        %>
        <%@ include file="/WEB-INF/views/includes/header.jsp" %>
        <div class="container">
            <div>

                <nav>
                    <div class="nav-wrapper">
                        <div class="col s12">
                            <a href="#!" class="breadcrumb">Home</a>
                            <a href="#!" class="breadcrumb active">Add Course</a>
                        </div>
                    </div>
                </nav>

                <div>
                    <h3>Add Course</h3>
                    <hr>
                </div>
            </div>
            <div>

                <form method="post" >

                    <div class="form-group col-xs-12 col-sm-12 col-md-12" style="display: <% out.print(courseError);%>">
                        <div  style="color: #a94442" role="alert">
                            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                            <span class="sr-only">Error:</span>
                            Please enter Course name
                        </div>
                    </div>

                    <div class="form-group col-xs-12 col-sm-12 col-md-12">

                        <div class="col-xs-2 col-sm-2 col-md-2">
                            <label for="coursename" >Course Name:</label>
                        </div>
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <input type="text" class="form-control" id="coursename" name="coursename" value="<%= request.getAttribute("course-value")%>">
                        </div>


                    </div>

                    <div class="form-group col-xs-12 col-sm-12 col-md-12">

                        <div class="col-xs-2 col-sm-2 col-md-2">
                            <label for="coursename" >Instructors Names: </label>
                        </div>
                        <div class="col-xs-6 col-sm-6 col-md-6">



                            <select id="chkveg" name="instId">
                                <%

                                    for (Iterator<Instructor> i = list.iterator(); i.hasNext();) {
                                        Instructor item = i.next();


                                %>
                                <option value="<%= item.getId()%>"><%= item.getFname() + " " + item.getLname()%></option>
                                <%
                                    }
                                %>

                            </select>

                        </div>


                    </div>
                    <div class="col-xs-6 col-xs-offset-5 col-sm-6 col-sm-offset-5">
                        <button type="submit" class="btn btn-default">Submit</button>
                    </div>

                </form>

            </div>


        </div>
        <br><br><br><br><br><br><br><br><br>
        <div class="container">
            <%@ include file="/WEB-INF/views/includes/footer.jsp" %>

        </div>



    </body>
</html>