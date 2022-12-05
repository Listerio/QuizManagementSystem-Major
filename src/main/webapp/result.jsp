<%--
  Created by IntelliJ IDEA.
  User: Omotola
  Date: 12/4/2022
  Time: 11:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="includes/main.css">
    <link rel="stylesheet" href="includes/result.css">
    <title>Title</title>
</head>
<body>
<jsp:include page="includes/header.jsp"></jsp:include>

<div class="container">
    <div class="text-container">
        <h1>Congratulations you scored: ${result} </h1>
    </div>
    <div class="buttonsContainer">
        <form  method="post" action="logout">
            <button type="submit">Logout</button>
        </form>
        <form  method="post" action="ExamSelectorPage.jsp">
            <button type="submit">AnotherExam</button>
        </form>
    </div>
</div>
<jsp:include page="includes/footer.jsp"></jsp:include>
</body>
</html>
