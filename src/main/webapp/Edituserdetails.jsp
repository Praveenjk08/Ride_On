<%@page import="com.servlet.Dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title herer</title>
</head>
<body>
<%User user=(User)request.getAttribute("user");%>
<form action="update" method="get">
<input type="hidden" placeholder="Enter the user id" name="uid" value="<%=user.getU_id()%>"><br>
UserName<br><input type="text" placeholder="Enter the user name" name="name" vlalue="<%=user.getFullname()%>"><br>
UserEmail <br> <input type="email" placeholder="Enter the user mail" name="email" value="<%=user.getEmail()%>"><br>
UserPassword <br> <input type="password" placeholder="Enter your password" name="pass" value="<%=user.getPass()%>"><br>
UserPhoneNumber <br> <input type="tel" placeholder="enter your phone" name="ph" value="<%=user.getPhone()%>">
<br>
<input type="submit" value="Edit">
</form>

</body>
</html>