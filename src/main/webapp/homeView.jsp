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
		<c:if test="${not empty table1}">
		<div>
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
				</tr>
				</c:forEach>
			</table>
		</div>
		</c:if>
		<c:if test="${not empty table2}">
		<div>
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
				</tr>
				</c:forEach>
			</table>
		</div>
		</c:if>
		<c:if test="${not empty table3}">
		<div>
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
				</tr>
				</c:forEach>
			</table>
		</div>
		</c:if>
		<c:if test="${not empty table4}">
		<div>
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
				</tr>
				</c:forEach>
			</table>
		</div>
		</c:if>
	</body>
</html>