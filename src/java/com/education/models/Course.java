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
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
    @NamedQuery(name = "Course.getById", query = "select s from Course s WHERE s.id=:id")
    ,@NamedQuery(name = "Course.deleteById", query = "delete from Course s WHERE s.id=:id")

})
   // ,@NamedQuery(name = "Course.getByInstId", query = "select s from Course s WHERE s.instructorForCourse=:id")

//    @NamedQuery(name = "Course.updateById", query = "update Course s set s.courseName=:coursename,instractor_fk=:instractor_fk WHERE s.id=:id")
@Transactional
public class Course implements Serializable {

    @Transient
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String coursename;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Instructor getInstructorForCourse() {
        return instructorForCourse;
    }

    public void setInstructorForCourse(Instructor instructorForCourse) {
        this.instructorForCourse = instructorForCourse;
    }

    @ManyToOne
    @JoinColumn(name = "instractor_fk")
    Instructor instructorForCourse;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
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
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Course[ id=" + id + " ]";
    }

}
