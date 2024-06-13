<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <title>List Notes</title>
</head>
<body>
<h2>List Notes</h2>
<ul>
    <c:forEach items="${notes}" var="note">
        <li>${note.title} - ${note.context}</li>
    </c:forEach>
</ul>
<p><a href="index.jsp">Go back to main page</a></p>
</body>
</html>
