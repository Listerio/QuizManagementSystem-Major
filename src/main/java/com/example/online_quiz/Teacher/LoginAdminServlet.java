package com.example.online_quiz.Teacher;

import com.example.persistence.Controller;
import com.example.persistence.facade.DefaultTeacherVerifier;
import com.example.persistence.facade.StudentFacade;
import com.example.persistence.facade.TeacherVerifiedFacade;
import com.example.persistence.student.Student;
import com.example.persistence.teacher.Teacher;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginAdminServlet", value = "/loginA")
public class LoginAdminServlet extends HttpServlet {
    Controller controller;
    TeacherVerifiedFacade facade;
    final String  error="Error: ";
    {
        controller=Controller.getInstance();
        facade=new DefaultTeacherVerifier();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId;
        String password;
        String errorContent;



        userId=request.getParameter("userId");
        password=request.getParameter("adPassword");

        if(userId.isBlank()||password.isBlank()){
            errorContent=error+"Cannot leave empty spaces";
            errorMessage(response,request,errorContent);
        }
        Teacher stub=new Teacher();
        stub.setId(userId);
        stub.setPassword(password);

        Teacher teacher= facade.getTeacher(stub);
        if (teacher==null){
            System.out.println("error Loading");
            errorContent=error+"invalid login parameters";
            errorMessage(response,request,errorContent);
        }
        else {
            controller.setTeacher(teacher);
            sendToExamPage(request,response,"createSubject.jsp");
        }

    }
    private  void errorMessage(HttpServletResponse response,HttpServletRequest request,String errorMessage) throws ServletException, IOException {
        request.setAttribute("AerrorContent",errorMessage);
        request.getRequestDispatcher("LoginTeacher.jsp").forward(request,response);
    }
    private void sendToExamPage(HttpServletRequest request,HttpServletResponse response,String path) throws ServletException, IOException {
        request.getRequestDispatcher(path).forward(request,response);
    }

}
