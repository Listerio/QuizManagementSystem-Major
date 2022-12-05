<%@ page import="com.example.persistence.Controller" %>
<%@ page import="com.example.persistence.dao.SubjectDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.persistence.subject.Subject" %>
<%@ page import="com.example.persistence.scorrer.Scorrer" %>

<%--
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
    <link rel="stylesheet" href="includes/rid.css">
    <title>Title</title>
</head>
<body>
<jsp:include page="includes/header.jsp"></jsp:include>

<%
Controller controller=Controller.getInstance();
request.setAttribute("info",controller.getStudent().getExamNumber());
SubjectDao dao=new SubjectDao();
List<Subject> subjectList= dao.subjectList();
request.getSession().setAttribute("qAmap",null);
request.getSession().setAttribute("serv",null);
%>
<section>

    <div class="Cup">
        <div class="cup-size">
            <h1>Select Course: ${info}</h1>
            <div class="cup-form">
                <form method="post" action="ExamPickServlet">
                    <div class="ans">
                        <label for="ans">Select Exam:</label>
                        <select name="examName" id="ans">
                            <optgroup label="Option:">
                                <%
                                    for (Subject subject:subjectList){
                                %>
                                <option value="<%=subject.getSubjectName()%>"><%=subject.getSubjectName()%></option>
                                <%
                                    }
                                %>

                            </optgroup>
                        </select>
                    </div>

                    <div class="button">
                        <button type="submit">Start Exam</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
    <jsp:include page="includes/footer.jsp"></jsp:include>
</body>
</html>
