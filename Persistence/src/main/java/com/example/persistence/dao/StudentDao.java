package com.example.persistence.dao;

import com.example.persistence.student.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDao {

    private String query;

    private boolean verify(String examNumber) throws SQLException {
        query="Select * from student where examNumber=?";
        try (Connection connection=DbUtil.getConnection();
             PreparedStatement statement=connection.prepareStatement(query)){
            statement.setString(1,examNumber);
            try (ResultSet set=statement.executeQuery()){
                while (set.next()){
                    return true;
                }
            }
        }
        return false;
    }

    public Student getStudent(String examNumber,String password) throws SQLException{
        if (verify(examNumber)){
            query="Select * from student where examNumber=? and password=?";
            Student student1=new Student();
            try (Connection connection=DbUtil.getConnection();
                 PreparedStatement statement=connection.prepareStatement(query)){
                statement.setString(1,examNumber);
                statement.setString(2,password);
                try (ResultSet set=statement.executeQuery()){
                    while (set.next()){
                        student1.setExamNumber(set.getString("examNumber"));
                        student1.setPassword(set.getString("password"));
                        student1.setImageIcon(set.getString("img"));
                        return student1;
                    }
                }
            }
        }
        return null;
    }








}
