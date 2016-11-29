/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.education.controllers.instructor;

import com.education.models.Course;
import com.education.services.InstructorService;
import com.education.models.generic.Gender;
import com.education.models.Instructor;
import com.education.services.CourseService;
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
import java.util.List;

/**
 *
 * @author mohamedk
 */
@WebServlet(name = "updateInstructor", urlPatterns = {"/updateInstructor", "/addInstructor"})
@MultipartConfig
public class ManageInstructor extends HttpServlet {

    @EJB
    ValidatorLocal validator;
    @EJB
    InstructorService sS;
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

        String url = request.getServletPath();
            List<Course> cList = cS.listCourse();

        if (url.equals("/updateInstructor")) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));

                Instructor sE = (Instructor) sS.getInstructor(id);
                request.setAttribute("Error", false);
                request.setAttribute("Edit", true);
                request.setAttribute("fname-error", false);
                request.setAttribute("lname-error", false);

                request.setAttribute("fname-value", sE.getFname());
                request.setAttribute("lname-value", sE.getLname());
            request.setAttribute("cList", cList);

            } catch (Exception e) {
                request.setAttribute("Error", true);
            }
        } else {
            request.setAttribute("Error", false);
            request.setAttribute("Edit", false);
            request.setAttribute("fname-error", false);
            request.setAttribute("lname-error", false);

            request.setAttribute("fname-value", "");
            request.setAttribute("lname-value", "");
            request.setAttribute("cList", cList);

        }
        RequestDispatcher req = request.getRequestDispatcher("WEB-INF/views/instructor/addInstructor.jsp");
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

        if (url.equals("/updateInstructor")) {
            request.setAttribute("Edit", true);
        } else {
            request.setAttribute("Edit", false);
        }
        // Create path components to save the file
        Instructor sE = new Instructor();
        request.setAttribute("errors", false);
        request.setAttribute("fname-error", false);
        request.setAttribute("lname-error", false);
        String fname = request.getParameter("fname");
        System.out.println(fname);
        if (!validator.isNull(fname) || !validator.length(fname, 1)) {
            request.setAttribute("errors", true);
            request.setAttribute("fname-error", true);
            request.setAttribute("fname-value", "");
        } else {
            request.setAttribute("fname-value", fname);
            sE.setFname(fname);
        }
        String lname = request.getParameter("lname");
        if (!validator.isNull(lname) || !validator.length(lname, 1)) {
            request.setAttribute("errors", true);
            request.setAttribute("lname-error", true);
            request.setAttribute("lname-value", "");
        } else {
            request.setAttribute("lname-value", lname);
            sE.setLname(lname);
        }

        if ((Boolean) request.getAttribute("errors")) {
            RequestDispatcher req = request.getRequestDispatcher("WEB-INF/views/instructor/addInstructor.jsp");

            req.forward(request, response);
        } else {
            if (url.equals("/updateInstructor")) {
                try {
                    int id = Integer.parseInt(request.getParameter("id"));
                    sE.setId(id);
                    sS.updateInstructor(sE);
                } catch (Exception e) {
                    System.err.println("Error !!!!");
                }
            } else {
                sS.addInstructor(sE);
            }
            response.sendRedirect("./listInstructors");
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
