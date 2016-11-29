/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.education.api;


import com.education.models.Student;
import com.education.services.StudentService;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author hany
 */
@Path("/students")
public class studentApi {

    @PersistenceContext(unitName = "EducationPU")
    private EntityManager em;

    @EJB
    StudentService studentS;

    @Context
    UriInfo sUriInfo;

    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> listAll(){
    
    List<Student> s= studentS.getStudents();
    return s;
    
    }
}
