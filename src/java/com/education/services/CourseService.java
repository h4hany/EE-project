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
public class CourseService {

    @PersistenceContext(unitName = "EducationPU")
    private EntityManager em;

    public void addCourse(Course course) {
        em.persist(course);

    }
     public void addCourseAndInstructor(Course course, Instructor instructor ) {
        em.persist(course);
        em.persist(instructor);

    }
    public List<Course> listCourse() {

        TypedQuery<Course> sQuery = em.createQuery("select s from Course s ", Course.class);
        List<Course> sList = sQuery.getResultList();
        return sList;
    }

    public void updateCourse(Course s) {
        TypedQuery<Course> sQuery = em.createNamedQuery("Course.updateById", Course.class);
        sQuery.setParameter("coursename", s.getCoursename());

        sQuery.setParameter("id", s.getId());
        sQuery.executeUpdate();
    }

    public Course getCourse(int id) {
        TypedQuery<Course> sQuery = em.createNamedQuery("Course.getById", Course.class);
        sQuery.setParameter("id", id);
        return sQuery.getSingleResult();

    }


    public void deleteCourse(int id) {
        Course s = em.find(Course.class, id);
        em.remove(s);
    }

}
