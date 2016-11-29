/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.education.controllers.student;

import com.education.services.StudentService;
import com.education.models.generic.Gender;
import com.education.models.Student;
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

/**
 *
 * @author mohamedk
 */
@WebServlet(name = "updateStudent", urlPatterns = {"/updateStudent", "/addStudent"})
@MultipartConfig
public class ManageStudent extends HttpServlet {

    @EJB
    ValidatorLocal validator;
    @EJB
    StudentService sS;

    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    private static String[] fromString(String string) {
        String[] strings = string.replace("[", "").replace("]", "").split(", ");
        String result[] = new String[strings.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = strings[i];
        }
        return result;
    }

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

        if (url.equals("/updateStudent")) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));

                Student sE = (Student) sS.getStudent(id);
                request.setAttribute("Error", false);
                request.setAttribute("Edit", true);
                request.setAttribute("fname-error", false);
                request.setAttribute("lname-error", false);
                request.setAttribute("email-error", false);
                request.setAttribute("interest-error", false);
                request.setAttribute("gender-error", false);
                request.setAttribute("file-error", false);
                request.setAttribute("age-error", false);
                request.setAttribute("password-error", false);

                request.setAttribute("fname-value", sE.getFname());
                request.setAttribute("lname-value", sE.getLname());
                request.setAttribute("email-value", sE.getEmail());

                request.setAttribute("gender-value", ((sE.getGender().equals("Male")) ? "0" : "1"));
                request.setAttribute("age-value", sE.getAge());
                //  String[] interest = new String[3];
                String[] interest = ManageStudent.fromString(sE.getInterest());
                request.setAttribute("interest-value", interest);
            } catch (Exception e) {
                request.setAttribute("Error", true);
            }
        } else {
            request.setAttribute("Error", false);
            request.setAttribute("Edit", false);
            request.setAttribute("fname-error", false);
            request.setAttribute("lname-error", false);
            request.setAttribute("email-error", false);
            request.setAttribute("interest-error", false);
            request.setAttribute("gender-error", false);
            request.setAttribute("file-error", false);
            request.setAttribute("age-error", false);
            request.setAttribute("password-error", false);

            request.setAttribute("fname-value", "");
            request.setAttribute("lname-value", "");
            request.setAttribute("email-value", "");
            request.setAttribute("gender-value", "");
            request.setAttribute("age-value", "");
            request.setAttribute("password-value", "");
            String[] interest = new String[3];
            request.setAttribute("interest-value", interest);

        }
        RequestDispatcher req = request.getRequestDispatcher("WEB-INF/views/student/addStudent.jsp");
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

        if (url.equals("/updateStudent")) {
            request.setAttribute("Edit", true);
        } else {
            request.setAttribute("Edit", false);
        }
        // Create path components to save the file
        Student sE = new Student();
        request.setAttribute("errors", false);
        request.setAttribute("fname-error", false);
        request.setAttribute("lname-error", false);
        request.setAttribute("email-error", false);
        request.setAttribute("interest-error", false);
        request.setAttribute("gender-error", false);
        request.setAttribute("file-error", false);
        request.setAttribute("age-error", false);
        request.setAttribute("password-error", false);
        final String path = request.getServletContext().getRealPath("");//request.getParameter("destination");
        final Part filePart = request.getPart("file");
        final String fileName = getFileName(filePart);
        String mimeType = request.getServletContext().getMimeType(fileName);

        OutputStream outImage = null;
        InputStream filecontent = null;

        try {
            if (mimeType.startsWith("image/")) {
                // It's an image.
                System.err.println("IMAGEEEEEE");
                sE.setFile(fileName);
                outImage = new FileOutputStream(new File(path + File.separator
                        + fileName));
                filecontent = filePart.getInputStream();
                int read = 0;
                final byte[] bytes = new byte[1024];
                while ((read = filecontent.read(bytes)) != -1) {
                    outImage.write(bytes, 0, read);
                }
            } else {
                request.setAttribute("errors", true);
                request.setAttribute("file-error", true);
            }
        } catch (Exception e) {
            request.setAttribute("errors", true);
            request.setAttribute("file-error", true);
        } finally {
            if (outImage != null) {
                outImage.close();
            }
            if (filecontent != null) {
                filecontent.close();
            }
        }
        String password =request.getParameter("password");
         if (!validator.isNull(password) || !validator.length(password, 1)) {
            request.setAttribute("errors", true);
            request.setAttribute("password-error", true);
            request.setAttribute("password-value", "");
        } else {
            request.setAttribute("password-value", password);
            sE.setPassword(password);
        }
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
        String email = request.getParameter("email");
        if (!validator.isNull(fname) || !validator.length(fname, 1) || !validator.isEmail(email)) {
            request.setAttribute("errors", true);
            request.setAttribute("email-error", true);
            request.setAttribute("email-value", "");
        } else {
            request.setAttribute("email-value", email);
            sE.setEmail(email);
        }
        String[] interest = request.getParameterValues("interest");

        if (interest == null) {
            request.setAttribute("interest-error", true);
            interest = new String[3];
            request.setAttribute("interest-value", interest);
        } else {
            request.setAttribute("interest-value", interest);
            String interestString = Arrays.toString(interest);

            sE.setInterest(interestString);
        }
        String gender = request.getParameter("gender");
        if (!validator.isNull(gender) || !validator.isInt(gender)) {
            request.setAttribute("errors", true);
            request.setAttribute("gender-error", true);
            request.setAttribute("gender-value", "");
        } else {
            request.setAttribute("gender-value", gender);
            if (gender.equals("0")) {
                sE.setGender(Gender.Male);
            } else {
                sE.setGender(Gender.Female);
            }
        }

        String age = (String) request.getParameter("age");
        if (!validator.isNull(age) || !validator.isInt(age) || !validator.intRange(age, 10, 90)) {
            request.setAttribute("errors", true);
            request.setAttribute("age-error", true);
            request.setAttribute("age-value", "");
        } else {
            request.setAttribute("age-value", age);
            sE.setAge(Integer.parseInt(age));
        }
       
        //String fname = request.getParameter("fname");

        if ((Boolean) request.getAttribute("errors")) {
            RequestDispatcher req = request.getRequestDispatcher("WEB-INF/views/student/addStudent.jsp");

            req.forward(request, response);
        } else {
            if (url.equals("/updateStudent")) {
                try {
                    int id = Integer.parseInt(request.getParameter("id"));
                    sE.setId(id);
                    sS.updateStudent(sE);
                } catch (Exception e) {
                    System.err.println("Error !!!!");
                }
            } else {
                sS.addStduent(sE);
            }
            response.sendRedirect("./listStudents");
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
