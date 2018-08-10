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
		<c:forEach begin="1" step="1" end="${fn:length(questions)}" varStatus="i">
		<tr><td>${questions[i.count-1].question }</td><td> </td></tr>
		<c:forEach begin="1" step="1" end="${fn:length(answers[i.count-1]) }" varStatus="j">
		<tr><td> </td><td>${answers[i.count-1][j.count-1].answer}</td></tr>
		</c:forEach>
		</c:forEach>
		
		</table>
	</body>
</html>