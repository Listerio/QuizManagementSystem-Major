<%@ page import="com.example.persistence.Controller" %>
<%@ page import="com.example.persistence.test.CreateTest" %>
<%@ page import="com.example.online_quiz.Teacher.NewExamServlet" %><%--
  Created by IntelliJ IDEA.
  User: Omotola
  Date: 11/29/2022
  Time: 3:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

  <link rel="stylesheet" href="includes/main.css">
  <link rel="stylesheet" href="includes/newQuestion.css">
    <title>New Question</title>
<%
    Controller controller;
    CreateTest cTest;
    controller=Controller.getInstance();
    cTest=CreateTest.getInstance(controller.getTeacher().getSubject());
    request.setAttribute("Qnum",cTest.getQuestionStream().size()+1);
%>
</head>
<body>
<jsp:include page="includes/header.jsp"></jsp:include>
<section>
  <div class="lynx">
    <div class="lynx-size">
      <form method="post" action="NewExamServlet">
        <p>Question number: ${Qnum}</p><br>
        <textarea name="question" class="question" cols="30" rows="20" placeholder="enter question here"></textarea>
        <div class="answerArea">
          <div>
          <input type="text" name="option1" class="option" placeholder="option1">
          <input type="text" name="option2" class="option" placeholder="option2">
          <input type="text" name="option3" class="option" placeholder="option3">
          <input type="text" name="option4" class="option" placeholder="option4">
          </div>
                <div class="ans">
                  <label for="ans">Select answer:</label>
                    <select name="answer" id="ans">
                      <optgroup label="Option:">
                        <option value="option1">Option1</option>
                        <option value="option2">Option2</option>
                        <option value="option3">Option3</option>
                        <option value="option4">Option4</option>
                      </optgroup>
                    </select>
                </div>


                <div class="btn">
                  <%
                      int numberOfQuestions=cTest.getTest().getNumberOfQuestions();
                      if (NewExamServlet.getCounter()+1==numberOfQuestions){
                  %>
                    <button type="submit">Finish</button>
                    <%
                        }
                      else {
                    %>
                    <button type="submit">Add Question</button>
                    <%
                        }
                    %>
                </div>
<%--                <div class="pagination">--%>
<%--                    <a href="#">&laquo;</a>--%>
<%--                    <a href="#">1</a>--%>
<%--                    <a href="#" class="active">2</a>--%>
<%--                      <a href="#">& raquo;</a>--%>
<%--                </div>--%>
      </div>
      </form>
    </div>
  </div>
</section>
<jsp:include page="includes/footer.jsp"></jsp:include>
</body>
</html>
