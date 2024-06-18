<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

 <body>
   <h1 style="color: white; background-color: green">
       Aha, You are In
       <%
          Object currentUser=session.getAttribute("validUser");
       
       %>
       <h2>Current Logged In=<%= currentUser %></h2>
   </h1>
 </body>
</html>