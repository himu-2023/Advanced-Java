<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<body>
    <%--Accepting user name and generating responce that greets this user --%>
    <%
     String userFullName =request.getParameter("fullname");
    String responceText = "<h2>Hello " + userFullName + "</h2>";
    out.println(responceText);
    %>
	</body>
</html>