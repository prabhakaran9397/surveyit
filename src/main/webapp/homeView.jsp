<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Home</title>
	</head>
	<body>
		<c:if test="${not empty error}">
			<p class="err"> ${error} </p>
		</c:if>
		<c:if test="${not empty table1}">
		<div>
			<h3>Pending Surveys</h3>
			<table>
				<tr>
					<th>Survey Id</th>
					<th>Survey Title</th>
					<th>Distributed Time</th>
				</tr>
				<c:forEach var="row" items="${table1}">
				<tr>
					<c:forEach var="element" items="${row}">
					<td> ${element} </td>
					</c:forEach>
					<td><a href="takeSurvey/${element[0]}" >Go</a></td>
				</tr>
				</c:forEach>
			</table>
		</div>
		</c:if>
		<c:if test="${not empty table2}">
		<div>
			<h3>Finished Surveys</h3>
			<table>
				<tr>
					<th>Survey Id</th>
					<th>Survey Title</th>
					<th>Distributed Time</th>
				</tr>
				<c:forEach var="row" items="${table2}">	
				<tr>
					<c:forEach var="element" items="${row}">
					<td> ${element} </td>
					</c:forEach>
					<td><a href="viewResponse/${element[0]}" >My Response</a></td>
				</tr>
				</c:forEach>
			</table>
		</div>
		</c:if>
		<c:if test="${not empty table3}">
		<div>
			<h3>Distribute Surveys</h3>
			<table>
				<tr>
					<th>Survey Id</th>
					<th>Survey Title</th>
				</tr>
				<c:forEach var="row" items="${table3}">
				<tr>
					<c:forEach var="element" items="${row}">
					<td> ${element} </td>
					</c:forEach>
					<td><a href="distribute/${element[0]}" >My Response</a></td>
				</tr>
				</c:forEach>
			</table>
		</div>
		</c:if>
		<c:if test="${not empty table4}">
		<div>
			<h3>Review Surveys</h3>
			<table>
				<tr>
					<th>Survey Id</th>
					<th>Survey Title</th>
					<th>Distributed Time</th>
				</tr>
				<c:forEach var="row" items="${table4}">
				<tr>
					<c:forEach var="element" items="${row}">
					<td> ${element} </td>
					</c:forEach>
					<td><a href="viewResponses/${element[0]}" >Responses</a></td>
				</tr>
				</c:forEach>
			</table>
		</div>
		</c:if>
	</body>
</html>