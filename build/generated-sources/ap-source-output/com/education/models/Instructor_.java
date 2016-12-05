package com.education.models;

import com.education.models.Course;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-05T02:39:25")
@StaticMetamodel(Instructor.class)
public class Instructor_ { 

    public static volatile SingularAttribute<Instructor, String> fname;
    public static volatile ListAttribute<Instructor, Course> courses;
    public static volatile SingularAttribute<Instructor, String> lname;
    public static volatile SingularAttribute<Instructor, String> password;
    public static volatile SingularAttribute<Instructor, Integer> id;
    public static volatile SingularAttribute<Instructor, String> email;

}