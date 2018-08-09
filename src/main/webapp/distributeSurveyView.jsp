<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Distribute Survey Page</title>
		<style type="text/css">
			.err { color: red; }
		</style>
	</head>
	<body>

		<form action="distribute" method="post">
			
			<input name="survey" value="${survey.id}" disabled/>
			
			<p>Select Users</p>
			<c:forEach var="u" items="${userslist }" >
				${u.firstname} <input type="checkbox" name="user" value="${u.id}"/>
			</c:forEach>
			
			
			<input type="submit" value="Distribute Survey"/> 
		</form>
	</body>
</html>