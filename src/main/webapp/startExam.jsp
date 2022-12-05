<%@ page import="com.example.persistence.Controller" %>
<%@ page import="com.example.persistence.student.TestServing" %>
<%@ page import="com.example.persistence.test.Test" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.persistence.question.Question" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Omotola
  Date: 12/3/2022
  Time: 2:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="includes/main.css">
    <link rel="stylesheet" href="includes/examStudent.css">
    <title>Title</title>
</head>
<body>
<%
    TestServing serving;
    Test test;
    Controller controller;

    controller=Controller.getInstance();
    serving=(TestServing) request.getSession().getAttribute("serv");
    test=serving.getTest();
    List<Question> questions=serving.getQuestions();

%>
<section>
  <div class="version1">
    <div class="imgContainer">
      <img class="profilePic" src="includes/blank-profile-picture-973460__480.webp" alt="vv">
    </div>
    <div class="info">
      <div class="title">
          <h3>Your Information</h3>
      </div>
        <%
          String examNo=controller.getStudent().getExamNumber();
        %>
      <h5>Examination Id:<%=examNo%></h5>
    </div>
  </div>
    <form action="ExamServlet" method="post">
        <div>
            <div class="content">
                <%

                    for (Question question:
                            questions) {
                        String questionVal=question.getQuestion();
                        String option1=question.getOption1();
                        String option2=question.getOption2();
                        String option3=question.getOption3();
                        String option4=question.getOption4();
                        String id=question.getQuestionId()+"";
                %>
                <div class="question">
                    <h3>Question no: <%=id%></h3>
                    <h2><%=questionVal%></h2><br>
                    <h4>Select option</h4>
                </div>
                <div class="option">

                        <div class="separator">
                            <input type="radio" class="options" name="option<%=id%>" id="A" value="<%=option1%>">
                            <label for="A"><%=option1%></label>
                        </div>

                        <div class="separator">
                            <input type="radio" class="options" name="option<%=id%>" id="B" value="<%=option2%>">
                            <label for="B"><%=option2%></label>
                        </div>

                        <div class="separator">
                            <input type="radio" class="options" name="option<%=id%>" id="C" value="<%=option3%>">
                            <label for="C"><%=option3%></label>
                        </div>

                        <div class="separator">
                            <input type="radio" class="options" name="option<%=id%>" id="D" value="<%=option4%>">
                            <label for="D"><%=option4%></label>
                        </div>

                </div>
                <hr>
                <%
                    }
                %>
            </div>
        </div>



        <div class="separator">
            <button type="submit" class="btn">Submit</button>
        </div>


    </form>
</section>
</body>
</html>
