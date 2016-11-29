/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.education.api;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.ApplicationPath;

/**
 *
 * @author hany
 */
@ApplicationPath("api")        
public class API extends javax.ws.rs.core.Application{
    
    
    @PersistenceContext(unitName = "EducationPU")
    private EntityManager em;
     
    
}
