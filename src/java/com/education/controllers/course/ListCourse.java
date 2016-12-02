/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.education.controllers.course;

import com.education.services.CourseService;
import com.education.models.Course;
import com.education.services.InstructorService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.education.models.Instructor;
import com.education.models.Student;
import com.education.services.StudentService;
/**
 *
 * @author mohamedk
 */
@WebServlet(name = "listCourses", urlPatterns = {"/listCourses"})
public class ListCourse extends HttpServlet {

    @EJB
    CourseService cS;
    @EJB
    InstructorService sI;
    @EJB
    StudentService sS;

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
        List<Course> list;
        if (request.getParameter("InstId") != null) {
            int id = Integer.parseInt(request.getParameter("InstId"));
            Instructor inst = (Instructor) sI.getInstructor(id);
            list = (List<Course>) inst.getCourses();
        } 
        else if (request.getParameter("StudId") != null) {
            int id = Integer.parseInt(request.getParameter("StudId"));
            Student inst = (Student) sS.getStudent(id);
            list = (List<Course>) inst.getCourses();
        }
        else {
            list = (List<Course>) cS.listCourse();
        }
        request.setAttribute("Courses", list);
        RequestDispatcher req = request.getRequestDispatcher("WEB-INF/views/course/listCourses.jsp");
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
        response.sendRedirect("/listCourses");
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
