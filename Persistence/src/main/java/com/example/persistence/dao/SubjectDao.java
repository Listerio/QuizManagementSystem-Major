package com.example.persistence.dao;


import com.example.persistence.question.Question;
import com.example.persistence.question.impl.DefaultQuestion;
import com.example.persistence.subject.Subject;
import com.example.persistence.test.CreateTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectDao {
    private String query;

    public void setSubject(Subject subject) throws SQLException {
        query="INSERT INTO `quiz`.`subject` (`subject_name`) VALUES (?)";
        try(Connection conn=DbUtil.getConnection();
            PreparedStatement statement= conn.prepareStatement(query)){
           statement.setString(1,subject.getSubjectName());
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

}

