<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="styles/homepage.css">
    <title>JSP - Hello World</title>
</head>

<body>
<header>
    <h1>School Name Here</h1>
</header>
<section class="one">
    <div class="cover">
        <div class="hero">
            <h1>Login Page</h1>
            <div class="form">
                <p>${errorContent}</p>
                <form action="loginS" method="post">
                    <input class="inp" name="examNum" type="text" placeholder="Exam number">
                    <input class="inp" name="stdPassword" type="password" placeholder="Password">
                </form>
            </div>
            <div class="btn">
                <button type="submit">Start</button>
            </div>
            <div class="link"><a href="index.jsp">admin Login</a></div>
        </div>
    </div>

</section>

<footer>
    <h3>Footer here</h3>
</footer>
</body>









</html>