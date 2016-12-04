/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.education.controllers.index;

import com.education.models.Instructor;
import com.education.models.Student;
import com.education.models.generic.Gender;

/**
 *
 * @author hany
 */
public class CurrentUser {
     
    private int id;
    private String fname;
    private String lname;
    private Gender gender;
    private String file;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    private String email;
    private String interest;
    private String password;
private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    public CurrentUser(Student s) {
        this.id = s.getId();
        this.fname = s.getFname();
        this.lname = s.getLname();
        this.gender = s.getGender();
        this.file = s.getFile();
        this.age = s.getAge();
        this.email = s.getEmail();
        this.interest = s.getInterest();
        this.type=0;
    }
    
    public CurrentUser(Instructor i) {
        this.id = i.getId();
        this.fname = i.getFname();
        this.lname = i.getLname();
        this.email = i.getEmail();
        this.type=1;
    }
    
}
