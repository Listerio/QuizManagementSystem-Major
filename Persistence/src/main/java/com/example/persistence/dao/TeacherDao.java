package com.example.persistence.dao;

import com.example.persistence.teacher.Teacher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherDao {

    private static String query;
    private static boolean verify(Teacher teacher) throws SQLException {
        query="Select * from teacher where id=? and teacher_password=?";
       try (Connection connection=DbUtil.getConnection();
            PreparedStatement statement=connection.prepareStatement(query)){
           statement.setString(1,teacher.getId());
           statement.setString(2,teacher.getPassword());
           try (ResultSet set=statement.executeQuery()){
               while (set.next()){
                   return true;
               }
           }
       }
        return false;
    }
    public static Teacher getTeacher(Teacher teacher) throws SQLException{
        if (verify(teacher)) {
            query="Select * from teacher where id=? and teacher_password=?";
            Teacher teacher1=new Teacher();
            try (Connection connection=DbUtil.getConnection();
             PreparedStatement statement=connection.prepareStatement(query)){
            statement.setString(1,teacher.getId());
            statement.setString(2,teacher.getPassword());
            try (ResultSet set=statement.executeQuery()){
                while (set.next()){
                    teacher1.setId(set.getString(4));
                    teacher1.setName(set.getString(2));
                    teacher1.setPassword(set.getString(3));
                    SubjectDao subjectDao=new SubjectDao();
                    teacher1.setSubject(subjectDao.getSubject(set.getInt("course_id")));
                    return teacher1;
                    }
                }
            }
        }
        return null;
        }

}
