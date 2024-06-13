<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Note</title>
</head>
<body>
<h2>Add Note</h2>
<form action="notes" method="post">

    <label for="title">Title:</label>
    <input type="text" id = "title" name="title" required><br>

    Context: <textarea name="context" required></textarea>

    <input type="submit" value="Add Note">

</form>
</body>
</html>