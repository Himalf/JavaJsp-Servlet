<%@ page import="java.util.List" %>
<%@ page import="com.servlet.demo.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Database Data</title>
    <style>
        table, th, td {
            border: 1px solid black;
            text-align: center;
            margin-left: auto;
            margin-right: auto;
            width: 1000px;
        }
        h1 {
            text-align: center;
        }
        a {
            display: block;
            text-align: center;
            margin-top: 20px;
            color: red;
        }
        div {
            display: flex;
        }
        button {
            margin-left: 10px;
        }
    </style>
</head>
<body>
<h1>The Database Data</h1>
<table>
    <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Address</th>
            <th>Age</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${studentList}" var="Student">
            <tr>
                <td><c:out value="${Student.id}"/></td>
                <td><c:out value="${Student.name}"/></td>
                <td><c:out value="${Student.address}"/></td>
                <td><c:out value="${Student.age}"/></td>
                <td>
                    <div>
                        <form action="DeleteServlet" method="post">
                            <input type="hidden" name="id" value="${Student.id}">
                            <input type="submit" value="Delete">
                        </form>
                        <button>Update</button>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<a href="index.html">Insert Data</a>
</body>
</html>
