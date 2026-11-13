
<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         isELIgnored="false" %>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Details</title>
</head>
<body>

<h2>Student Details</h2>

<table border="1" cellpadding="10" cellspacing="0">

    <tr>
        <th>ID</th>
        <td><c:out value="${student.id}"/></td>
    </tr>

    <tr>
        <th>Full Name</th>
        <td><c:out value="${student.fullName}"/></td>
    </tr>

    <tr>
        <th>Email</th>
        <td><c:out value="${student.email}"/></td>
    </tr>

    <tr>
        <th>Mobile</th>
        <td><c:out value="${student.mobile}"/></td>
    </tr>

    <tr>
        <th>Age</th>
        <td><c:out value="${student.age}"/></td>
    </tr>

    <tr>
        <th>Course</th>
        <td><c:out value="${student.course}"/></td>
    </tr>

    <tr>
        <th>Created At</th>
        <td><c:out value="${student.createdAt}"/></td>
    </tr>

    <tr>
        <th>Updated At</th>
        <td><c:out value="${student.updatedAt}"/></td>
    </tr>

</table>

<br>

<a href="<c:url value='/student/edit/${student.id}'/>">
    Edit Student
</a>

<br><br>

<a href="<c:url value='/student/list'/>">
    Back to Student List
</a>

</body>
</html>
