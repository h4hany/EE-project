/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.education.controllers.course;

import com.education.services.CourseService;
import com.education.models.generic.Gender;
import com.education.models.Course;
import com.education.models.Instructor;
import com.education.services.InstructorService;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import com.education.services.generic.ValidatorLocal;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author mohamedk
 */
@WebServlet(name = "updateCourse", urlPatterns = {"/updateCourse", "/addCourse"})
@MultipartConfig
public class ManageCourse extends HttpServlet {

    @EJB
    ValidatorLocal validator;
    @EJB
    CourseService cs;
    @EJB
    InstructorService is;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = request.getServletPath();

        if (url.equals("/updateCourse")) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));

                Course sE = (Course) cs.getCourse(id);
                request.setAttribute("Error", false);
                request.setAttribute("Edit", true);
                request.setAttribute("course-error", false);

                request.setAttribute("course-value", sE.getCoursename());

            } catch (Exception e) {
                request.setAttribute("Error", true);
            }
        } else {
            request.setAttribute("Error", false);
            request.setAttribute("Edit", false);
            request.setAttribute("course-error", false);
            request.setAttribute("course-value", "");

            List<Instructor> iList = is.listInstructor();
            request.setAttribute("li", iList);

        }

        RequestDispatcher req = request.getRequestDispatcher("WEB-INF/views/course/addCourse.jsp");

        req.forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          String url = request.getServletPath();

        if (url.equals("/updateCourse")) {
            request.setAttribute("Edit", true);
        } else {
            request.setAttribute("Edit", false);
        }
        // Create path components to save the file
        Course sE = new Course();
        request.setAttribute("errors", false);
        request.setAttribute("course-error", false);
      
        String coursename = request.getParameter("coursename");
        //System.out.println(fname);
        if (!validator.isNull(coursename) || !validator.length(coursename, 1)) {
            request.setAttribute("errors", true);
            request.setAttribute("course-error", true);
            request.setAttribute("course-value", "");
        } else {
            request.setAttribute("course-value", coursename);
            sE.setCoursename(coursename);
        }
        
          int instId = Integer.parseInt( request.getParameter("instId"));
                 
     
            request.setAttribute("instV-value", instId);
            Instructor instCourse = is.getInstructor(instId);
            sE.setInstructorForCourse(instCourse);
       
        if ((Boolean) request.getAttribute("errors")) {
            RequestDispatcher req = request.getRequestDispatcher("WEB-INF/views/course/addCourse.jsp");

            req.forward(request, response);
        } else {
            if (url.equals("/updateCourse")) {
                try {
                    int id = Integer.parseInt(request.getParameter("id"));
                    sE.setId(id);
                    cs.updateCourse(sE);
                } catch (Exception e) {
                    System.err.println("Error !!!!");
                }
            } else {
                cs.addCourse(sE);
            }
            response.sendRedirect("./listCourses");
        }
         
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
