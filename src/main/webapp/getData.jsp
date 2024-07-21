
<%@page import="com.servlet.demo.GetDataFromDatabase"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.servlet.demo.DbConnect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP File</title>
</head>
<body>


<h1 style="text-align: center;">The Database Data</h1>
<table style="border: 1px solid black; text-align: center; margin-left: auto;margin-right: auto; width:1000px;">
<thead >
 <tr >
 <th style="border:1px solid black">Id</th>
 <th style="border:1px solid black">Name</th>
 <th style="border:1px solid black">Address</th>
 <th style="border:1px solid black">Age</th>
 <th style="border:1px solid black; width: 50px;">Action</th>
 </tr>
</thead>
<tbody >
<%
ResultSet rs = null;
rs = GetDataFromDatabase.getDetail();
while(rs.next()){
	String id = rs.getString("id");
	String name = rs.getString("name");
	String address = rs.getString("address");
	String age = rs.getString("age");

%>
<tr>
<td style="border:1px solid black"><%=id %></td>
<td style="border:1px solid black"><%=name %></td>
<td style="border:1px solid black"><%=address %></td>
<td style="border:1px solid black"><%=age %></td>
<td>
<div style="display: flex;">
<form action="DeleteServlet" method="post">
<input type="hidden" name="id" value="<%=id %>" >
<input type="submit" value="Delete">
</form>
<button>Update</button>
</div>
</td>
</tr>
<%} %>
</tbody>
</table>
<a href="index.html" style="color:red; text-align: center">Insert Data</a>
</body>
</html>