package com.example.persistence.teacher;

import com.example.persistence.subject.Subject;

public class Teacher {
    String Name;
    Subject subject;

    public String getName() {
        return Name;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
