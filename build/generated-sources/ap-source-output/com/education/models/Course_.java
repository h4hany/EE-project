package com.education.models;

import com.education.models.Instructor;
import com.education.models.Student;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-05T02:39:25")
@StaticMetamodel(Course.class)
public class Course_ { 

    public static volatile SingularAttribute<Course, String> coursename;
    public static volatile ListAttribute<Course, Student> students;
    public static volatile SingularAttribute<Course, Integer> id;
    public static volatile SingularAttribute<Course, Instructor> instructorForCourse;

}