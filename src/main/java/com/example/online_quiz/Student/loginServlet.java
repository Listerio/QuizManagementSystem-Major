package com.example.online_quiz.Student;

import com.example.persistence.Controller;
import com.example.persistence.facade.StudentFacade;
import com.example.persistence.student.Student;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/loginS")
public class loginServlet extends HttpServlet {
    Controller controller;
    StudentFacade facade;
    {
        controller=Controller.getInstance();
        facade=new StudentFacade();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String examNum;
            String password;
            String errorContent;

            examNum=request.getParameter("examNum");
            password=request.getParameter("stdPassword");

            if(examNum.isBlank()||password.isBlank()){
                errorContent="Cannot leave empty spaces";
                request.setAttribute("examNum",examNum);
                request.setAttribute("stdPassword",password);
                errorMessage(response,request,errorContent);
            }
            Student student=facade.getStudent(examNum,password);

            if (student==null){
                errorContent="invalid login parameters";
                request.setAttribute("examNum",examNum);
                request.setAttribute("stdPassword",password);
                errorMessage(response,request,errorContent);
            }

            else {
                controller.setStudent(student);
                sendToExamPage(request,response,"ExamSelectorPage.jsp");
            }

    }
    private  void errorMessage(HttpServletResponse response,HttpServletRequest request,String errorMessage) throws ServletException, IOException {
        request.setAttribute("errorContent",errorMessage);
        request.getRequestDispatcher("StudentRegister.jsp").forward(request,response);

    }
    private void sendToExamPage(HttpServletRequest request,HttpServletResponse response,String path) throws ServletException, IOException {
        request.getRequestDispatcher(path).forward(request,response);
    }

}
