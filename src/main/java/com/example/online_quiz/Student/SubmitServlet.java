package com.example.online_quiz.Student;

import com.example.persistence.Controller;
import com.example.persistence.question.Question;
import com.example.persistence.scorrer.Scorrer;
import com.example.persistence.student.TestServing;
import com.example.persistence.test.Test;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Map;

@WebServlet(name = "SubmitServlet", value = "/submit")
public class SubmitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TestServing serving;
        Test test;
        Map<Question,String> questionAnswerMap;
        questionAnswerMap=(Map<Question, String>) request.getSession().getAttribute("qAmap");
        serving=(TestServing) request.getSession().getAttribute("serv");
        test=serving.getTest();
        Scorrer scorrer=new Scorrer(test);

        for (Question q: serving.getQuestions()) {
          String ansCheck=q.getAnswer();
          String stdAns=questionAnswerMap.get(q);
            System.out.println(stdAns);
            System.out.println(ansCheck);
            System.out.println(stdAns.equals(ansCheck));
          scorrer.isCorrect(stdAns.equals(ansCheck));
        }
        System.out.println(scorrer.getScore());
        System.out.println(scorrer.getPercentage()+"%");
        request.setAttribute("result",scorrer.getScore()+" / "+test.getNumberOfQuestions());
        request.getRequestDispatcher("result.jsp").forward(request,response);
    }

}
