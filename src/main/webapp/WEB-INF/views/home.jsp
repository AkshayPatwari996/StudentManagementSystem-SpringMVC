
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Student Management System</title>
</head>
<body>

<h1>Student Management System</h1>

<h2>Welcome!</h2>

<h3>Select an Option</h3>

<a href="<%= request.getContextPath() %>/student/add">
    Add Student
</a>

<br><br>

<a href="<%= request.getContextPath() %>/student/list">
    Fetch Students
</a>

</body>
</html>
