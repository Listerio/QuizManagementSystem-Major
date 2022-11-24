package com.example.persistence.teacher;

import com.example.persistence.subject.Subject;

public class Teacher {

    private String Name;
    private String id;
    private String password;
    private Subject subject;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }


    public String getName() {
        return Name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id){
        this.id=id;
    }

}
