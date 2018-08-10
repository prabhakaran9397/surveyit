<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>View Responses Page</title>
		<style type="text/css">
			.err { color: red; }
		</style>
	</head>
	<body>
	<center><h3>Review Survey Responses</h3></center>
	<br><br>
	
	<div>
		<p>Survey Name  :  <span> ${surveytitle }</span> </p>
		<p>Survey Description  :  <span> ${surveydesc }</span></p>
		<p>Distributed On  :  <span> ${surveytimestamp }</span></p>	
	</div>
	
	<div>
		<c:forEach var="entry" items="${questiontypethreeandfour }">
		
			<div>
				<p>${entry.key }</p>
				<c:forEach var="answer" items="${entry.value }">
					<p>${answer }</p>
				</c:forEach>
			</div>
			
		</c:forEach>
	</div>
	
	<div>
		<c:forEach var="entry" items="${questiontypeoneandtwo }">
		
		<div>
		<c:forEach var="choice" items="${entry.value }">
			<p>${entry.key }</p>
			<br>
			<table>
				<tr>
					<th> Choices </th>
					<th> No. Of Respondents </th>
				</tr>
				<tr>
					<td> ${choice.key } </td>
					<td> ${choice.value } </td>
				</tr>
			</table>
		</c:forEach>
		</div>
		
		</c:forEach>
	</div>
	
	</body>
</html>
