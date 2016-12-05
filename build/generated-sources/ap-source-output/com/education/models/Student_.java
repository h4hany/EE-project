package com.education.models;

import com.education.models.Course;
import com.education.models.generic.Gender;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-05T02:39:25")
@StaticMetamodel(Student.class)
public class Student_ { 

    public static volatile SingularAttribute<Student, String> fname;
    public static volatile ListAttribute<Student, Course> courses;
    public static volatile SingularAttribute<Student, String> lname;
    public static volatile SingularAttribute<Student, String> password;
    public static volatile SingularAttribute<Student, String> file;
    public static volatile SingularAttribute<Student, Gender> gender;
    public static volatile SingularAttribute<Student, String> interest;
    public static volatile SingularAttribute<Student, Integer> id;
    public static volatile SingularAttribute<Student, Integer> age;
    public static volatile SingularAttribute<Student, String> email;

}