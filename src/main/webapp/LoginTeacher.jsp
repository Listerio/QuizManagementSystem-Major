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
            <form class="form" action="loginA" method="post">
                <h1>Login Here</h1>
                <p>${AerrorContent}</p>
                <input name="userId" type="text" placeholder="User id">
                <input name="adPassword" type="text" placeholder="Password">
                <div class="button">
                    <button type="submit">Submit</button>
                </div>
            </form>
    </div>
</section>

<jsp:include page="includes/footer.jsp"></jsp:include>
</body>
</html>
