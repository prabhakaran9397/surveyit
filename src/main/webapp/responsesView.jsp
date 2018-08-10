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
			table {
			    font-family: arial, sans-serif;
			    border-collapse: collapse;
			    width: 100%;
			}
			
			td, th {
			    border: 1px solid #dddddd;
			    text-align: left;
			    padding: 8px;
			}
			
			tr:nth-child(even) {
			    background-color: #dddddd;
			}
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
				<p><b>Question : </b> ${entry.key.question }</p>
				<c:forEach var="ans" items="${entry.value }">
					<p>${ans.answer }</p>
				</c:forEach>
			</div>
			
		</c:forEach>
	</div>
	
	<div>
		<c:forEach var="entry" items="${questiontypeoneandtwo }">
		
		<div>
		<p>${entry.key.question }</p>
			<br>
			<table>
				<tr>
					<th> Choices </th>
					<th> No. Of Respondents </th>
				</tr>
				
				<c:forEach var="choice" items="${entry.value}">
			
				<tr>
					<td> ${choice.key.questionChoice} </td>
					<td> ${choice.value} </td>
				</tr>
				
				</c:forEach>
				
				</table>
		</div>
		
		
		</c:forEach>
	</div>
	
	</body>
</html>
