<%-- 
    Document   : getStudent
    Created on : Nov 20, 2016, 7:00:00 PM
    Author     : hany
--%>

<%@page import="com.education.models.Course"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.education.models.Instructor"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.lang.ArrayUtils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% try{ %>
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
            String fnameError = ((Boolean) request.getAttribute("fname-error")) ? "block" : "none"; //false;
            String lnameError = ((Boolean) request.getAttribute("lname-error")) ? "block" : "none";
            String passError = ((Boolean) request.getAttribute("password-error")) ? "block" : "none";
            String emailError = ((Boolean) request.getAttribute("email-error")) ? "block" : "none";

            List<Course> list = (List<Course>) request.getAttribute("cList");


        %>
        <%@ include file="/WEB-INF/views/includes/header.jsp" %>
        <div class="container">
            <div>

                <nav>
                    <div class="nav-wrapper">
                        <div class="col s12">
                            <a href="#!" class="breadcrumb">Home</a>
                            <a href="#!" class="breadcrumb active">Add Instructor</a>
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

                    <div class="form-group col-xs-12 col-sm-12 col-md-12" style="display: <% out.print(fnameError);%>">
                        <div  style="color: #a94442" role="alert">
                            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                            <span class="sr-only">Error:</span>
                            Please enter first name
                        </div>
                    </div>
                    <div class="form-group col-xs-12 col-sm-12 col-md-12">

                        <div class="col-xs-2 col-sm-2 col-md-2">
                            <label for="fname" >First Name:</label>
                        </div>
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <input type="text" class="form-control" id="fname" name="fname" value="<%= request.getAttribute("fname-value")%>">
                        </div>
                    </div>
                    <br>
                    <div class="form-group col-xs-12 col-sm-12 col-md-12" style="display: <% out.print(lnameError);%>">
                        <div style="color: #a94442" role="alert">
                            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                            <span class="sr-only">Error:</span>
                            Please enter last name
                        </div>
                    </div>
                    <br>
                    <div class="form-group col-xs-12 col-sm-12 col-md-12">
                        <div class="col-xs-2 col-sm-2 col-md-2">
                            <label for="lname">Last Name:</label>
                        </div>
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <input type="text" class="form-control" id="lname" name="lname" value="<%= request.getAttribute("lname-value")%>">
                        </div>
                    </div>
                    <br>
                    <div class="form-group col-xs-12 col-sm-12 col-md-12" style="display: <% out.print(passError);%>">
                        <div style="color: #a94442" role="alert">
                            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                            <span class="sr-only">Error:</span>
                            Please enter a valid Password
                        </div>
                    </div>
                    <br>
                    <div class="form-group col-xs-12 col-sm-12 col-md-12">

                        <div class="col-xs-2 col-sm-2 col-md-2">
                            <label for="password" >Password :</label>
                        </div>
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <input type="password" class="form-control" id="password" name="password" value="<%= request.getAttribute("password-value")%>">
                        </div>
                    </div>
                    <br>
                    <div class="form-group col-xs-12 col-sm-12 col-md-12" style="display: <% out.print(emailError);%>">
                        <div style="color: #a94442" role="alert">
                            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                            <span class="sr-only">Error:</span>
                            Please enter a valid email
                        </div>
                    </div>
                    <br>
                    <div class="form-group col-xs-12 col-sm-12 col-md-12">
                        <div class="col-xs-2 col-sm-2 col-md-2">
                            <label for="email">Email address:</label>
                        </div>
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <input type="email" class="form-control" id="email" name="email" value="<%= request.getAttribute("email-value")%>">
                        </div>
                    </div>
                    <br>
                    <div class="form-group col-xs-12 col-sm-12 col-md-12">

                        <div class="col-xs-2 col-sm-2 col-md-2">
                            <label for="coursename" >Courses Names: </label>
                        </div>
                        <div class="col-xs-6 col-sm-6 col-md-6">



                            <select id="chkveg" name="courseId">
                                <%

                                    for (Iterator<Course> i = list.iterator(); i.hasNext();) {
                                        Course item = i.next();


                                %>
                                <option value="<%= item.getId()%>"><%= item.getCoursename()%></option>
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
<% }
catch(Exception e)
{
System.out.println("HOHOHOHOHO");
System.out.println(e);
}
%>