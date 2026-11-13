
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Student List</title>
</head>
<body>

<h2>Student Management System</h2>

<a href="<%= request.getContextPath() %>/student/add">
    Register New Student
</a>

<h3>Registered Students</h3>

<table border="1" cellpadding="10">

    <tr>
        <th>ID</th>
        <th>Full Name</th>
        <th>Email</th>
        <th>Mobile</th>
        <th>Age</th>
        <th>Course</th>
        <th>Actions</th>
    </tr>

    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.id}</td>
            <td>${student.fullName}</td>
            <td>${student.email}</td>
            <td>${student.mobile}</td>
            <td>${student.age}</td>
            <td>${student.course}</td>

            <td>
                <a href="<%= request.getContextPath() %>/student/view/${student.id}">
                    View
                </a>

                |

                <a href="<%= request.getContextPath() %>/student/edit/${student.id}">
                    Edit
                </a>

                |

                <form action="<%= request.getContextPath() %>/student/delete/${student.id}"
                      method="post" style="display:inline;">

                    <button type="submit">Delete</button>

                </form>
            </td>
        </tr>
    </c:forEach>

    <c:if test="${empty students}">
        <tr>
            <td colspan="7">No students registered yet.</td>
        </tr>
    </c:if>

</table>

</body>
</html>
