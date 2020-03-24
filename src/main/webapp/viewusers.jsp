<%@page import="com.rtpl.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Users</title>
</head>
<body>
<%@page import="com.rtpl.bean.User,com.rtpl.dao.UserDao.*,java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Users List</h1>  
<%
List<User>list=UserDao.getAllRecords();
request.setAttribute("list", list);

%>
<table border="1" width="90%">
<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th>  
<th>Sex</th><th>Country</th><th>Edit</th><th>Delete</th></tr>
<c:forEach items="${list}" var="user">  
 <tr><td>${user.getId()}</td><td>${user.getName()}</td><td>${user.getPassword()}</td>  
<td>${user.getEmail()}</td><td>${user.getSex()}</td><td>${user.getCountry()}</td>  
<td><a href="editform.jsp?id=${user.getId()}">Edit</a></td>  
<td><a href="deleteuser.jsp?id=${user.getId()}">Delete</a></td></tr>  




<%-- <tr>

                         <td><c:out value="${user.Id}" /></td>
                        <td><c:out value="${user.Name}" /></td>
                        <td><c:out value="${user.Password}" /></td>
                         <td><c:out value="${user.Email}" /></td>
                          <td><c:out value="${user.Sex}" /></td>
                           <td><c:out value="${user.Country}" /></td> 
                    </tr> --%>
</c:forEach>

</table>

<br/><a href="adduserform.jsp">Add New User</a>  
</body>
</html>