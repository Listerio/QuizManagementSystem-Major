<%@ page import="com.example.persistence.Controller" %><%--
  Created by IntelliJ IDEA.
  User: Omotola
  Date: 11/29/2022
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="includes/main.css">
  <link rel="stylesheet" href="includes/questionCreate.css">
    <title>Title</title>
</head>
<body>
<jsp:include page="includes/header.jsp"></jsp:include>

<%  Controller controller;
    controller=Controller.getInstance();
    String info=" "+controller.getTeacher().getName()+"  Course: "+controller.getTeacher().getSubject().getSubjectName();
    request.setAttribute("info",info);
%>
<section>

    <div class="Cup">
        <div class="cup-size">
            <h1>Welcome ${info}</h1>
            <p>${nullQuestions}</p>
            <div class="cup-form">
                <form method="post" action="ExamSetterServlet">
                    <div class="button">
                    <button type="submit">New question</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

</section>

<jsp:include page="includes/footer.jsp"></jsp:include>
</body>
</html>
