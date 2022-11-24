package com.example.persistence.dao;


import com.example.persistence.question.Question;
import com.example.persistence.question.impl.DefaultQuestion;
import com.example.persistence.subject.Subject;
import com.example.persistence.test.CreateTest;
import com.example.persistence.test.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectDao {
    private String query;

    public void setSubject(Subject subject, Test test) throws SQLException {
        query="INSERT INTO `quiz`.`subject` (`subject_name`,timer) VALUES (?,?)";
        try(Connection conn=DbUtil.getConnection();
            PreparedStatement statement= conn.prepareStatement(query)){
           statement.setString(1,subject.getSubjectName());
           statement.setInt(2,test.getTimer());
           statement.executeUpdate();
        }
    }
    public int getId(Subject subject)throws SQLException{
        query="select id_Subject from quiz.subject where subject_name=?";
        try (Connection connection=DbUtil.getConnection();
             PreparedStatement statement=connection.prepareStatement(query)){
                 statement.setString(1,subject.getSubjectName());
            try(ResultSet set=statement.executeQuery()){
                while (set.next()){
                return set.getInt(1);
                }
            }
        }
        return 0;
    }

    public Subject getSubject(int subId) throws SQLException {
        query="Select * from subject where id_subject=?";
        try(Connection connection=DbUtil.getConnection();
            PreparedStatement statement= connection.prepareStatement(query)){
            statement.setInt(1,subId);
            try (ResultSet set=statement.executeQuery()){
                while (set.next()){
                    Subject subject=new Subject();
                    subject.setSubjectName(set.getString("subject_name"));
                    return subject;
                }
            }
        }
        return null;
    }

}

