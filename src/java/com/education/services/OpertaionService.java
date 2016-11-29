/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.education.services;

import com.education.models.Student;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author hany
 */
@Stateless
@LocalBean
public class OpertaionService {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "EducationPU")
    private EntityManager em;
    
    public boolean login(String email,String password){
        boolean checkLogin = false ;
        TypedQuery<Student> sQuery = em.createNamedQuery("Student.loginValdiate", Student.class);
        
        sQuery.setParameter("email", email);
        sQuery.setParameter("pass", password);
        try{
       if( sQuery.getSingleResult() != null){
           checkLogin = true;
           
       } else{
            checkLogin = false;
       }}catch(Exception e){}
       return checkLogin;
       
    }
}
