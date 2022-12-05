package com.example.online_quiz.Student;

import com.example.persistence.Controller;
import com.example.persistence.question.Question;
import com.example.persistence.student.TestServing;
import com.example.persistence.test.Test;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ExamServlet", value = "/ExamServlet")
public class ExamServlet extends HttpServlet {
    TestServing serving;
    String answer;
    Map<Question,String> questionAnswerMap;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        serving=(TestServing) request.getSession().getAttribute("serv");
        List<Question> questions=serving.getQuestions();
        questionAnswerMap=(Map<Question, String>) request.getSession().getAttribute("qAmap");

        for (Question question:
                questions)
        {
            String id = question.getQuestionId() + "";
            answer=request.getParameter("option"+id);
            questionAnswerMap.put(question,answer);
        }
        request.getSession().setAttribute("qAmap",questionAnswerMap);
        request.getRequestDispatcher("submit").forward(request,response);
    }

}




