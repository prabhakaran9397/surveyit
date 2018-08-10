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
		<p>${title}</p>
		<p>${description}</p>
		<p>${timestamp}</p>
		<c:forEach items="${qas}" var="qa" >
			<p>${qa.key.question}</p>
			<c:forEach items="${qa.value}" var="a">
				<p>${a}</p>
			</c:forEach>
			<hr/>
		</c:forEach>
	</body>
</html>