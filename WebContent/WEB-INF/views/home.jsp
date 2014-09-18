<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
	<h2>Welcome <c:out value="${user}"></c:out></h2>
	
	<form:form method="post" action="addAlly">
		<table>
		<tr>
			<td><label><spring:message code="label.email"/></label></td>
			<td><input type="text" name="ally_email"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="<spring:message code="label.addAlly"/>"/>
			</td>
		</tr>
		</table>
	</form:form>
</body>
</html>