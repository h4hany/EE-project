<%-- 
    Document   : getStudent
    Created on : Nov 20, 2016, 7:00:00 PM
    Author     : hany
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.education.models.Course"%>
<%@page import="org.apache.commons.lang.*"%>
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
            String fnameError = ((Boolean) request.getAttribute("fname-error")) ? "block" : "none"; //false;
            String lnameError = ((Boolean) request.getAttribute("lname-error")) ? "block" : "none";
            String emailError = ((Boolean) request.getAttribute("email-error")) ? "block" : "none";
            String interestError = ((Boolean) request.getAttribute("interest-error")) ? "block" : "none";
            String genderError = ((Boolean) request.getAttribute("gender-error")) ? "block" : "none";
            String fileError = ((Boolean) request.getAttribute("file-error")) ? "block" : "none";
            String ageError = ((Boolean) request.getAttribute("age-error")) ? "block" : "none";
            String dobError = ((Boolean) request.getAttribute("password-error")) ? "block" : "none";
            String coursesError = ((Boolean) request.getAttribute("courses-error")) ? "block" : "none";
            List<Course> list = (List<Course>) request.getAttribute("cList");
            List<Course> listOwn = (List<Course>) request.getAttribute("cListOwn");
        %>
        <%@ include file="/WEB-INF/views/includes/header.jsp" %>

        <div class="container">
            <div>
                <div>

                    <nav>
                        <div class="nav-wrapper">
                            <div class="col s12">
                                <a href="#!" class="breadcrumb">Home</a>
                                <a href="#!" class="breadcrumb active">Add Student</a>
                            </div>
                        </div>
                    </nav>

                    <div>
                        <h3>Add Student</h3>
                        <hr>
                    </div>
                </div>
                <form method="post" enctype="multipart/form-data">

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
                            <div class="form-group col-xs-12 col-sm-12 col-md-12" style="display: <% out.print(dobError);%>">
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
                    <div class="form-group col-xs-12 col-sm-12 col-md-12" style="display: <% out.print(interestError);%>">
                        <div style="color: #a94442" role="alert">
                            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                            <span class="sr-only">Error:</span>
                            Please select at least one interest
                        </div>
                    </div>
                    <br>
                    <div class="form-group col-xs-12 col-sm-12 col-md-12">
                        <div class="col-xs-2 col-sm-2 col-md-2">
                            <label for="interest">Interests:</label>
                        </div>
                        <div class="col-xs-6 col-sm-6 col-md-6">

                            <label class="checkbox-inline">

                                <input type="checkbox" 
                                       class="with-gap" name="interest" value="Interest1" id="Interest1"<%
                                           String[] interst = (String[]) request.getAttribute("interest-value");

                                           try {
                                               if (ArrayUtils.contains(interst, "Interest1")) {
                                                   out.print("checked");
                                               }
                                           } catch (Exception e) {
                                           }
                                       %>
                                       />
                                <label for="Interest1">Interest 1</label>
                            </label>
                            <label class="checkbox-inline">
                                <input type="checkbox" name="interest" class="with-gap" value="Interest2" id="Interest2"
                                       <%
                                           try {
                                               if (ArrayUtils.contains(interst, "Interest2")) {
                                                   out.print("checked");
                                               }
                                           } catch (Exception e) {
                                           }
                                       %>
                                       > <label for="Interest2">Interest 2</label>
                            </label>
                            <label class="checkbox-inline">
                                <input type="checkbox" name="interest" class="with-gap" value="Interest3" id="Interest3" <%
                                    try {
                                        if (ArrayUtils.contains(interst, "Interest3")) {
                                            out.print("checked");
                                        }
                                    } catch (Exception e) {
                                    }
                                       %>> <label for="Interest3">Interest 3</label>
                            </label>
                        </div>
                    </div>
                    <br>
                    <div class="form-group col-xs-12 col-sm-12 col-md-12" style="display: <% out.print(genderError);%>">
                        <div style="color: #a94442" role="alert">
                            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                            <span class="sr-only">Error:</span>
                            Please select Gender
                        </div>
                    </div>
                    <br>
                    <div class="form-group col-xs-12 col-sm-12 col-md-12">
                        <div class="col-xs-2 col-sm-2 col-md-2">
                            <label for="gender">Gender: </label>
                        </div>
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <label class="radio-inline"><input type="radio" class="with-gap" name="gender" value="0" id="Male"
                                                               <%
                                                                   String gender = (String) request.getAttribute("gender-value");
                                                                   if (gender.equals("0")) {
                                                                       out.print("checked");
                                                                   }
                                                               %>
                                                               > <label for="Male">Male</label></label>
                            <label class="radio-inline"><input type="radio" class="with-gap" name="gender" value="1" id="Female"
                                                               <%
                                                                   if (gender.equals("1")) {
                                                                       out.print("checked");
                                                                   }
                                                               %>
                                                               ><label for="Female">Female</label></label>
                        </div>
                    </div>
                    <br>
                    <div class="form-group col-xs-12 col-sm-12 col-md-12" style="display: <% out.print(fileError);%>">
                        <div style="color: #a94442" role="alert">
                            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                            <span class="sr-only">Error:</span>
                            Please enter a valid image
                        </div>
                    </div>
                    <br>
                    <div class="form-group col-xs-12 col-sm-12 col-md-12">
                        <div class="col-xs-2 col-sm-2 col-md-2">
                            <label for="password">Image: </label>
                        </div>
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="file-field input-field">
                                <div class="btn">
                                    <span>File</span>
                                    <input type="file"  class="form-control" id="img" name="file" accept="image/*" onchange="loadFile(event)" required="true">
                                </div>
                                <div class="file-path-wrapper">
                                    <input class="file-path validate" type="text">
                                </div>
                            </div>
                        </div>
                        <div class="col-xs-3 col-sm-3 col-md-3">
                            <img id="output" />
                        </div>

                    </div>
                    <br>
                    <div class="form-group col-xs-12 col-sm-12 col-md-12" style="display: <% out.print(ageError);%>">
                        <div style="color: #a94442" role="alert">
                            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                            <span class="sr-only">Error:</span>
                            Please enter a valid age
                        </div>
                    </div>
                    <br>
                    <div class="form-group col-xs-12 col-sm-12 col-md-12">
                        <div class="col-xs-2 col-sm-2 col-md-2">
                            <label for="age">Age: </label>
                        </div>
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <input type="text" class="form-control"  name="age" id="age" required="true" value='<%= request.getAttribute("age-value")%>'/>
                        </div>
                    </div>
                    <br>
                    <div class="form-group col-xs-12 col-sm-12 col-md-12" style="display: <% out.print(coursesError);%>">
                        <div  style="color: #a94442" role="alert">
                            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                            <span class="sr-only">Error:</span>
                            Please Select at least 1 course.
                        </div>
                    </div>    
                    <br>
                    <div class="form-group col-xs-12 col-sm-12 col-md-12">

                        <div class="col-xs-2 col-sm-2 col-md-2">
                            <label for="coursename" >Courses Names: </label>
                        </div>
                        <div class="col-xs-6 col-sm-6 col-md-6">



                            <select id="chkveg" name="courseId" multiple>
                                <%

                                    for (Iterator<Course> i = list.iterator(); i.hasNext();) {
                                        Course item = i.next();


                                %>
                                <option <% if ((Boolean) listOwn.contains(item)) {
                                        out.print("selected");
                                    }
                                    %> value="<%= item.getId()%>"><%= item.getCoursename()%></option>
                                <%
                                    }
                                %>

                            </select>

                        </div>


                    </div>
                
                    <br>

                    <div class="col-xs-6 col-xs-offset-5 col-sm-6 col-sm-offset-5">
                        <button type="submit" class="btn btn-default">Submit</button>
                    </div>
                </form>

            </div>
        </div>
        <%@ include file="/WEB-INF/views/includes/footer.jsp" %>

    </body>
</html>