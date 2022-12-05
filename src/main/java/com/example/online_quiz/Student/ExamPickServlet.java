package com.example.online_quiz.Student;

import com.example.persistence.Controller;
import com.example.persistence.dao.SubjectDao;
import com.example.persistence.question.Question;
import com.example.persistence.student.TestServing;
import com.example.persistence.subject.Subject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ExamPickServlet", value = "/ExamPickServlet")
public class ExamPickServlet extends HttpServlet {
    private final Controller controller;
    String examName;
    SubjectDao dao=new SubjectDao();
    List<Subject> subjectList= dao.subjectList();
    Map<Question,String> questionAnswerMap;
    {
        questionAnswerMap=new HashMap<>();
        controller=Controller.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        examName=request.getParameter("examName");
        for (Subject subject : subjectList) {
            if (examName.equals(subject.getSubjectName())) {
                    request.getSession().setAttribute("qAmap",questionAnswerMap);
                    TestServing serving=TestServing.getInstance(controller.getStudent(),examName);
                    request.getSession().setAttribute("serv",serving);
                    request.getRequestDispatcher("startExam.jsp").forward(request,response);
                    break;
            }
        }


    }
}
