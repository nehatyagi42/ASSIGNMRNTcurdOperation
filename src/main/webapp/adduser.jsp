<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import="com.rtpl.dao.UserDao"%>
  <jsp:useBean id="user" class="com.rtpl.bean.User"></jsp:useBean>
<jsp:setProperty property="*" name="user"/>  

<%  
int i=UserDao.save(user);  
if(i>0){  
response.sendRedirect("addusersuccess.jsp");  
}else{  
response.sendRedirect("addusererror.jsp");  
}  
%>  
