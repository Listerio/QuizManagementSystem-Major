package com.example.online_quiz.Teacher;

import com.example.persistence.Controller;
import com.example.persistence.dao.TestDao;
import com.example.persistence.question.Question;
import com.example.persistence.test.CreateTest;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "NewExamServlet", value = "/NewExamServlet")
public class NewExamServlet extends HttpServlet {
    Controller controller;
    String  question;
    String  option1;
    String  option2;
    String  option3;
    String  option4;
    String  answer;
    String  error;
    CreateTest cTest;
    private static int counter;


    public static int getCounter() {
        return counter;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        question=request.getParameter("question");
        option1=request.getParameter("option1");
        option2=request.getParameter("option2");
        option3=request.getParameter("option3");
        option4=request.getParameter("option4");
        answer=request.getParameter("answer");
        if (question==null||option1==null||option2==null||option3==null||option4==null||answer==null){
            error="cannot have blank spaces";
            errorMessage(request,response,error);
        }
        counter++;
        System.out.println(counter);

        switch (answer) {
            case "option1" -> answer = option1;
            case "option2" -> answer = option2;
            case "option3" -> answer = option3;
            case "option4" -> answer = option4;
        }
        controller=Controller.getInstance();
        cTest = CreateTest.getInstance(controller.getTeacher().getSubject());
        int numberOfQuestions=cTest.getTest().getNumberOfQuestions();
        if (counter==numberOfQuestions){
            cTest.createQuestions(question, option1, option2, option3, option4, answer);
            TestDao dao=new TestDao();
            try {
                dao.setQuestions(cTest,controller.getTeacher().getSubject().getId());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("logout");
        }
        else {
            cTest.createQuestions(question, option1, option2, option3, option4, answer);
            request.getRequestDispatcher("NewExam.jsp").forward(request,response);
        }
    }

    private  void errorMessage(HttpServletRequest request,HttpServletResponse response,String errorMessage) throws ServletException, IOException {
        request.setAttribute("errVal",errorMessage);
        request.getRequestDispatcher("NewExam.jsp").forward(request,response);
    }


}
