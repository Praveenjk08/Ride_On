
<%@page import="com.servlet.Dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%User user=(User)request.getAttribute("editusers");%>
<form action="update1" method="get">
<%=user.getU_id()%><input type="hidden" placeholder="Enter the user id" name="uid" value="<%=user.getU_id()%>"><br>
UserName<br><input type="text" placeholder="Enter the user name" name="name" value="<%=user.getFullname()%>"><br>
UserEmail <br> <input type="email" placeholder="Enter the user mail" name="email" value="<%=user.getEmail()%>"><br>
UserPassword <br> <input type="password" placeholder="Enter your password" name="pass" value="<%=user.getPass()%>"><br>
UserPhoneNumber <br> <input type="tel" placeholder="enter your phone" name="ph" value="<%=user.getPhone()%>">
<br>
<input type="submit" value="Edit1">
</form>

</body>
</html>