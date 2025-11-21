<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.List"%>
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
<%List<User> userlist=(List<User>)request.getAttribute("userlist1"); %>
<table border="1" cellspacing="5px" >

<tr>
<th>User_id</th>
<th>Name</th>
<th>Email</th>
<th>Phone-Number</th>
<th>Time and Date</th>
<th>Action</th>

</tr>

<% 
for(User ulist:userlist) { %>
	
	<tr>
	<th><%=ulist.getU_id()%></th>
	<th><%=ulist.getFullname()%></th>
	<th><%=ulist.getEmail()%></th>
	<th><%=ulist.getPhone()%></th>
	<th><%=ulist.getCurrDateTime()%></th>
	<th>
	 <a href="delete?d=<%=ulist.getU_id()%>">Delete</a>
	<a href="edit?e=<%=ulist.getU_id()%>">Edit</a> 
	</th>
	
     </tr>
	<%
	} 

	%>

	
</table>

</body>
</html>