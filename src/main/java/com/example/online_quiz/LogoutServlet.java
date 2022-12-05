package com.example.online_quiz;

import com.example.persistence.Controller;
import com.example.persistence.scorrer.Scorrer;
import com.example.persistence.student.TestServing;
import com.example.persistence.test.CreateTest;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LogoutServlet", value = "/logout")
public class LogoutServlet extends HttpServlet {
    @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("qAmap",null);
        TestServing serving=(TestServing) request.getSession().getAttribute("serv");
        Controller controller=Controller.getInstance();

        request.getSession().setAttribute("serv", null);
        controller=null;
        response.sendRedirect("StudentRegister.jsp");
    }

}
