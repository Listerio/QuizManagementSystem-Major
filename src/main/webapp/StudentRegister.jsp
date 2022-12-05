<%--
  Created by IntelliJ IDEA.
  User: Omotola
  Date: 11/29/2022
  Time: 1:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="includes/main.css">
  <title>Title</title>
</head>
<body>
<jsp:include page="includes/header.jsp"></jsp:include>
<section>
  <div class="form-container">
    <form class="form" action="loginS" method="post">
      <h1>Login Here</h1>
      <p>${errorContent}</p>
      <input name="examNum" type="text" placeholder="Exam Number">
      <input name="stdPassword" type="text" placeholder="Password">
      <div class="button">
        <button type="submit">Submit</button>
        <button type="button"><a href="LoginTeacher.jsp">login as Teacher</a></button>
      </div>

    </form>
  </div>
</section>
<jsp:include page="includes/footer.jsp"></jsp:include>
</body>
</html>
