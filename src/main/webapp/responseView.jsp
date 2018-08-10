<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Response View Page</title>
	</head>
	<body>
		<table>
		<tr><th>Survey Title</th><td>${title }</td></tr>
		<tr><th>Survey Description</th><td>${description }</td></tr>
		<tr><th>Time Stamp</th><td>${timestamp }</td></tr>
		<tr><th>Questions</th><th>Answers</th></tr>
		<c:forEach begin="0" step="1" end="${fn:length(questions)}" var="count">
		<tr><td>${questions[count] }</td><td>${answers[count] }</td></tr>
		</c:forEach>
		
		</table>
	</body>
</html>