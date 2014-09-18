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
 
<h2><c:out value="${user_name} would like to know your interests. Please fill the following slam form"></c:out></h2>

<form:form method="post" action="sendSlamDetails" commandName="friend_details">
 
    <table>
    <tr>
        <td><form:label path="email"><spring:message code="label.email"/></form:label></td>
        <td><form:input path="email" /></td>
    </tr>
    <tr>
        <td><form:label path="name"><spring:message code="label.firstname"/></form:label></td>
        <td><form:input path="name" /></td> 
    </tr>
    <tr>
        <td><form:label path="fav_person"><spring:message code="label.nickname"/></form:label></td>
        <td><form:input path="fav_person" /></td>
    </tr>
    <tr>
        <td><form:label path="nick_name"><spring:message code="label.fav_person"/></form:label></td>
        <td><form:input path="nick_name" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="<spring:message code="label.send"/>"/>
        </td>
    </tr>
</table>  
</form:form>
 
</body>
</html>