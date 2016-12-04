/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.education.controllers.index;

import com.education.models.Student;
import com.education.services.InstructorService;
import com.education.services.StudentService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hany
 */
@WebServlet(name = "Index", urlPatterns = {"/index", "/LoginStudent", "/LoginInstructor"})
public class Index extends HttpServlet {

    @EJB
    StudentService studentService;
    @EJB
    InstructorService iS;

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
        // processRequest(request, response);
        RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/index.jsp");

        view.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public CurrentStudent currentUser;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("Error", false);
        String url = request.getServletPath();
        if (url.equals("/LoginStudent")) {
            String email = request.getParameter("form-username");
            String password = request.getParameter("form-password");
            if (studentService.login(email, password) != null) {
                currentUser = new CurrentStudent(studentService.login(email, password));
                HttpSession session = request.getSession();
                session.setAttribute("currentUser", currentUser);
                response.sendRedirect("listStudents");
            } else {
                request.setAttribute("Error", true);
            }

        } else if (url.equals("/LoginInstructor")) {
            String email = request.getParameter("form-username");
            String password = request.getParameter("form-password");
            if (studentService.login(email, password) != null) {
                currentUser = new CurrentStudent(studentService.login(email, password));
                HttpSession session = request.getSession();
                session.setAttribute("currentUser", currentUser);
                response.sendRedirect("listStudents");
            } else {
                request.setAttribute("Error", true);
            }
        }
        if ((Boolean) request.getAttribute("Error") || url.equals("/index")) {
            RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/index.jsp");
            view.forward(request, response);
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
