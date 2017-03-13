<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User</title>
</head>
<body>

<spring:url value="/user/save" var="saveURL"></spring:url>

<form:form action="${ saveURL}" modelAttribute="userForm" method="POST">
	<form:hidden path="id" />
	<table>
	
	 	 <tr>
            <td>Name:</td>
            <td><form:input path="name" /></td>
        </tr>
	
		<tr>
            <td>LastName:</td>
            <td><form:input path="lastName" /></td>
        </tr>
        
        <tr>
            <td>DateOfBirth</td>
            <td><form:input path="dateOfBirth" /></td>
        </tr>
        
         <tr>
            <td>email</td>
            <td><form:input path="email" /></td>
        </tr>
        
        <tr>
            <td>Password</td>
            <td><form:input path="password" /></td>
        </tr>
        
        <tr>
            <td colspan="2">
                <input type="submit" />
            </td>
        </tr>
        
	</table>
	
</form:form>
</body>
</html>