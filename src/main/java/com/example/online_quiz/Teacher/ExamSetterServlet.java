package com.example.online_quiz.Teacher;

import com.example.persistence.Controller;
import com.example.persistence.dao.TestDao;
import com.example.persistence.question.Question;
import com.example.persistence.teacher.Teacher;
import com.example.persistence.test.CreateTest;
import com.example.persistence.test.Test;
import com.example.persistence.test.impl.DefaultTest;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ExamSetterServlet", value = "/ExamSetterServlet")
public class ExamSetterServlet extends HttpServlet {
    Controller controller;
    CreateTest createTest;
    Test test;
    List<Question> questionList;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        TestDao dao = new TestDao();
        controller=Controller.getInstance();
        try {
            questionList=dao.getQuestions(controller.getTeacher().getSubject().getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (questionList==null) {
            test = new DefaultTest(10);
            createTest = CreateTest.getInstance(controller.getTeacher().getSubject());
            createTest.setTest(test);
            request.getRequestDispatcher("NewExam.jsp").forward(request, response);
        }
        else {
            test = new DefaultTest(10);
            createTest = CreateTest.getInstance(controller.getTeacher().getSubject());
            createTest.setTest(test);
            try {
                dao.clearQuestions(controller.getTeacher().getSubject());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
