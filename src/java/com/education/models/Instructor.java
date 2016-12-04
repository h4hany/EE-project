/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.education.models;

import com.education.models.generic.Gender;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.transaction.Transactional;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hany
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instructor.updateById", query = "update Instructor s set s.fname=:fname, s.lname=:lname WHERE s.id=:id")
    ,@NamedQuery(name = "Instructor.getById", query = "select s from Instructor s WHERE s.id=:id")
    ,@NamedQuery(name = "Instructor.deleteById", query = "delete from Instructor s WHERE s.id=:id")
    ,@NamedQuery(name = "Instructor.loginValdiate", query = "select s from Instructor s WHERE s.email=:email and s.password=:pass")

})
@Transactional
public class Instructor implements Serializable {

    @Transient
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String fname;
    private String lname;
    private String password;
    @Column(unique=true)
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @OneToMany(mappedBy="instructorForCourse")
    List<Course> courses;

    public String getFname() {
        return fname;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
        public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instructor)) {
            return false;
        }
        Instructor other = (Instructor) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Instructor[ id=" + id + " ]";
    }

}
