<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Contact</title>
</head>
<body>


<h2>Contact Manager</h2>
	
	<form:form method="post" action="/action/add" commandName="contact">
		<table>
			<tr>
				<td><form:label path="firstName">First Name</form:label></td>
				<td><form:input path="firstName"/></td>
			</tr>
			<tr>
				<td><form:label path="lastName">Last Name</form:label></td>
				<td><form:input path="lastName"></form:input></td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type='submit' value="add contact" />
				</td>
			</tr>
		</table>
	</form:form>
	
	<a href="<c:url value="j_spring_security_logout" />" > Logout</a>
	<h3>Contact List</h3>
	
	<c:if test="${!empty contactList }">
		<table class="data">
			<tr>
				<th>First Name</th>
				<th>Last Name</th>				
			</tr>
			
			<c:forEach items="${contactList}" var="user">
				<tr>
					<td> ${user.firstName}</td>
					<td> ${user.lastName}</td>
				</tr>
			</c:forEach>
			
		</table>
	</c:if>


</body>
</html>