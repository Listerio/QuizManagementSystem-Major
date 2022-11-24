package com.example.persistence.facade;

import com.example.persistence.dao.TeacherDao;
import com.example.persistence.teacher.Teacher;

import java.sql.SQLException;

public class DefaultTeacherVerifier implements TeacherVerifiedFacade{

    @Override
    public Teacher getTeacher(Teacher teacher) {
        try {
            return TeacherDao.getTeacher(teacher);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
