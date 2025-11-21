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
<%User user=(User)request.getAttribute("userrod"); %>

<table border="2">
<tr>
<td colspan="7" style="align-items: center;"><centere>UserDetails</centere></td>

</tr>
<tr>
<td>User_Id</td>
<td>User_Name</td>
<td>User_Email</td>
<td>User_Password</td>
<td>User_Phone</td>
<td>User_Enter_Time</td>
<td>Action</td>

</tr>
<tr>
<td><%=user.getU_id()%></td>
<td><%=user.getFullname()%></td>
<td><%=user.getEmail()%></td>
<td><%=user.getPass()%></td>
<td><%=user.getPhone()%></td>
<td><%=user.getCurrDateTime()%></td>
<td>
<!-- <a href="edit?e=<%=user.getU_id()%>">Edit</a> -->
 <a href="edit1?e1=<%=user.getU_id()%>">Edit</a>
</td>
</tr>



</table>
</body>
</html>