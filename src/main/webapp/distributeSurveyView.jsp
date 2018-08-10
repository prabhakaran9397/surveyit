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

		<form action="/surveyit/distribute" method="post">
			
			<input type="hidden" name="survey" value="${survey.id}"/>
			
			<p>Select Users</p>
			<c:forEach var="u" items="${userslist }" >
				<input type="checkbox" name="user" value="${u.id}"/>${u.firstname}
				<br/>
			</c:forEach>
			
			
			<input type="submit" value="Distribute Survey"/> 
		</form>
	</body>
</html>