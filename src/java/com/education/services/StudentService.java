/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.education.services;

import com.education.models.Course;
import com.education.models.Student;
import com.education.models.generic.Gender;
import static java.util.Collections.list;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContexts;
import javax.persistence.TypedQuery;
import javax.transaction.Transaction;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author mohamedk
 */
@Stateless
@LocalBean
public class StudentService {

    @PersistenceContext(unitName = "EducationPU")
    private EntityManager em;

    public void addStduent(Student student) {
        /* try{
        if(!student.getCourses().isEmpty()){
         System.out.println("FromService: "+student.getCourses().size());
            System.out.println("FromService: "+student.getCourses().get(0).getCoursename());
            System.out.println("FromService: "+student.getCourses().get(0).getId());
        }}
        catch(Exception e){}
         */
        em.persist(student);
    }

    public List<Student> listStudent() {

        TypedQuery<Student> sQuery = em.createQuery("select s from Student s ", Student.class);
        List<Student> sList = sQuery.getResultList();
        return sList;
    }

    public void updateStudent(Student sss) {
        Student s = em.find(Student.class, sss.getId());
        s.setAge(sss.getAge());
        s.setCourses(sss.getCourses());
        s.setEmail(sss.getEmail());
        s.setFile(sss.getFile());
        s.setFname(sss.getFname());
        s.setGender(sss.getGender());
        s.setInterest(sss.getInterest());
        s.setLname(sss.getLname());
        s.setPassword(sss.getPassword());
        //em.getTransaction().begin();
        //s.setCourses(sss.getCourses());
        
        //em.merge(sss);
       // em.getTransaction().commit();
/*
        TypedQuery<Student> sQuery = em.createNamedQuery("Student.updateById", Student.class);
        sQuery.setParameter("fname", s.getFname());
        sQuery.setParameter("lname", s.getLname());
        sQuery.setParameter("email", s.getEmail());
        sQuery.setParameter("age", s.getAge());
        sQuery.setParameter("file", s.getFile());
        sQuery.setParameter("gender", s.getGender());
        sQuery.setParameter("interest", s.getInterest());
        sQuery.setParameter("id", s.getId());
        sQuery.executeUpdate();
*/
    }

    public Student getStudent(int id) {
        TypedQuery<Student> sQuery = em.createNamedQuery("Student.getById", Student.class);
        sQuery.setParameter("id", id);
        return sQuery.getSingleResult();

    }

    public void deleteStudent(int id) {
        Student s = em.find(Student.class, id);
        em.remove(s);
    }

    public List<Student> getStudents() {

        TypedQuery<Student> sQuery = em.createQuery("select s from Student s ", Student.class);
        List<Student> sList = sQuery.getResultList();
        return sList;
    }

    public Student login(String email, String password) {
        boolean checkLogin = false;
        Student s = null;

        TypedQuery<Student> sQuery = em.createNamedQuery("Student.loginValdiate", Student.class);
        sQuery.setParameter("email", email);
        sQuery.setParameter("pass", password);
        try {
            if (sQuery.getSingleResult() != null) {
                s = sQuery.getSingleResult();

            } else {
                s = null;
            }
        } catch (Exception e) {

        }
        return s;

    }

}
