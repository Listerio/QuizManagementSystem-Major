package com.example.persistence.facade;
import com.example.persistence.student.Student;
import com.example.persistence.dao.StudentDao;

import java.sql.SQLException;

public class StudentFacade {
   private final StudentDao dao;

    {
        dao=new StudentDao();
    }

    private Student getStudent(String examNumber,String password){
        try {
            return dao.getStudent(examNumber,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
