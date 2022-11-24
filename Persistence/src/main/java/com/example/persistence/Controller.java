package com.example.persistence;

import com.example.persistence.student.Student;
import com.example.persistence.teacher.Teacher;

public class Controller {

    private Student student;
    private Teacher teacher;

    private static Controller instance;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public static Controller getInstance() {
        if (instance==null){
            return new Controller();
        }
        return instance;
    }
}

