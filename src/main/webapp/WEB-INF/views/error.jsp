
<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         isELIgnored="false" %>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Application Error</title>
</head>
<body>

<h2>Something Went Wrong!</h2>

<p style="color:red;">
    <c:out value="${errorMessage}"
           default="An unexpected application error occurred."/>
</p>

<a href="<c:url value='/student/list'/>">
    Back to Student List
</a>

</body>
</html>
