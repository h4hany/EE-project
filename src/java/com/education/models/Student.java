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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.transaction.Transactional;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mohamedk
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.updateById", query = "update Student s set s.age=:age, s.email=:email, s.file=:file, s.fname=:fname, s.gender=:gender, s.interest=:interest, s.lname=:lname WHERE s.id=:id")
    ,@NamedQuery(name = "Student.getById", query = "select s from Student s WHERE s.id=:id")
    ,@NamedQuery(name = "Student.deleteById", query = "delete from Student s WHERE s.id=:id")
    ,@NamedQuery(name = "Student.loginValdiate", query = "select s from Student s WHERE s.email=:email and s.password=:pass")

})
@Transactional
public class Student implements Serializable {

    @Transient
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String fname;
    private String lname;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String file;
    private int age;
    @Column(unique=true)
    private String email;
    private String interest;
    private String password;

    @ManyToMany
    @JoinTable(name = "students_courses", joinColumns = @JoinColumn(name = "student_fk"), inverseJoinColumns = @JoinColumn(name = "course_fk"))
    private List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public String getFname() {
        return fname;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Student[ id=" + id + " ]";
    }

}
