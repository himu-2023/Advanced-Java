<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
	  <%--Instantiating a JavaBean of type: travel.Airline
	   using some reference:airlineRef --%>
	   <jsp:useBean id="airlineRef" 
	   				class="travel.Airline"
	   				scope="session"/>
	   <%--Setting values for all the properties of the bean --%>
	   <jsp:setProperty property="*" name="airlineRef"/>
	   <h2>Airline Created Successfully.</h2>
	   <h2>To View the Details Please 
	   		<a href="show_airline.jsp">Click Here</a>
	   </h2>
    </body>
</html>