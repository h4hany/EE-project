/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.education.services;

import com.education.models.Course;
import com.education.models.Instructor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContexts;
import javax.persistence.TypedQuery;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author mohamedk
 */
@Stateless
public class InstructorService {

    @PersistenceContext(unitName = "EducationPU")
    private EntityManager em;
    public void addInstructor (Instructor instructor) {
        em.persist(instructor);
        
    }
    public List<Instructor> listInstructor(){
    
       TypedQuery<Instructor> sQuery = em.createQuery("select s from Instructor s ",Instructor.class);
         List<Instructor>  sList =sQuery.getResultList();
         return sList;
    }
    
    

    public void addCoursesToInstructor(String courseId, String instructorId) {
        TypedQuery<Course> sQuery = em.createNamedQuery("Course.getById", Course.class);
        sQuery.setParameter("id", courseId);
        Course c =sQuery.getSingleResult();
        
        TypedQuery<Instructor> insQuery = em.createNamedQuery("Instructor.getById", Instructor.class);
        insQuery.setParameter("id", instructorId);
        Instructor ins = insQuery.getSingleResult();
        List<Course> coursesList =ins.getCourses();
        coursesList.add(c);
        ins.setCourses(coursesList);

    }

    public void updateInstructor(Instructor s){
    TypedQuery<Instructor> sQuery = em.createNamedQuery("Instructor.updateById",Instructor.class);
    sQuery.setParameter("fname", s.getFname());
    sQuery.setParameter("lname", s.getLname());
   
    sQuery.setParameter("id", s.getId());
    sQuery.executeUpdate();
    }
    public Instructor getInstructor(int id){
    TypedQuery<Instructor> sQuery = em.createNamedQuery("Instructor.getById",Instructor.class);
    sQuery.setParameter("id", id);
    return  sQuery.getSingleResult();
        
    }

    public void deleteInstructor(int id){
    Instructor s = em.find(Instructor.class, id);
    em.remove(s);    
    }
    
}
