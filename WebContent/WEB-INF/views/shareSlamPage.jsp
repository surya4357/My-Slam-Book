<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>Share My Slam Details</title>
</head>
<body>
 
<h2><c:out value="${user_name} would like to know your interests. would you like to share?"></c:out></h2>

<form:form method="post" action="sendSlamDetails" commandName="friend_details">
 
    <table>
    <tr>
        <td><input type="submit" value="<spring:message code="label.share"/>"/></td>
        <td><input type="submit" value="<spring:message code="label.no"/>"/></td>
    </tr>
</table>  
</form:form>
 
</body>
</html>