
<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         isELIgnored="false" %>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Registration</title>
</head>
<body>

<h2>
    <c:choose>
        <c:when test="${not empty student.id}">
            Update Student
        </c:when>
        <c:otherwise>
            Register Student
        </c:otherwise>
    </c:choose>
</h2>

<c:choose>
    <c:when test="${not empty student.id}">
        <c:url value="/student/update" var="formAction"/>
    </c:when>
    <c:otherwise>
        <c:url value="/student/save" var="formAction"/>
    </c:otherwise>
</c:choose>

<form:form modelAttribute="student"
           action="${formAction}"
           method="post">

    <form:hidden path="id"/>

    <p>
        Full Name:
        <form:input path="fullName"/>
        <form:errors path="fullName" cssStyle="color:red"/>
    </p>

    <p>
        Email:
        <form:input path="email"/>
        <form:errors path="email" cssStyle="color:red"/>
    </p>

    <p>
        Mobile:
        <form:input path="mobile"/>
        <form:errors path="mobile" cssStyle="color:red"/>
    </p>

    <p>
        Age:
        <form:input path="age" type="number"/>
        <form:errors path="age" cssStyle="color:red"/>
    </p>

    <p>
        Course:
        <form:input path="course"/>
        <form:errors path="course" cssStyle="color:red"/>
    </p>

    <button type="submit">
        <c:choose>
            <c:when test="${not empty student.id}">
                Update Student
            </c:when>
            <c:otherwise>
                Register Student
            </c:otherwise>
        </c:choose>
    </button>

</form:form>

<br>

<a href="<c:url value='/student/list'/>">
    Back to Student List
</a>

</body>
</html>
