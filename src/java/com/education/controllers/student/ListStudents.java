/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.education.controllers.student;

import com.education.models.Course;
import com.education.services.StudentService;
import com.education.models.Student;
import com.education.services.CourseService;
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

/**
 *
 * @author mohamedk
 */
@WebServlet(name = "listStudents", urlPatterns = {"/listStudents"})
public class ListStudents extends HttpServlet {

    @EJB
    StudentService sS;
    @EJB
    CourseService cS;

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
        List<Student> list;
        if (request.getParameter("CourseId") != null) {
            int id = Integer.parseInt(request.getParameter("CourseId"));
            Course course = (Course) cS.getCourse(id);
            list = (List<Student>) course.getStudents();
        } else {
            list = (List<Student>) sS.listStudent();
        }
        request.setAttribute("Students", list);
        RequestDispatcher req = request.getRequestDispatcher("WEB-INF/views/student/listStudents.jsp");
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
        response.sendRedirect("/listStudents");
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
