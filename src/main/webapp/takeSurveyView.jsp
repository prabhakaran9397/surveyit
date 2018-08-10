<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Take Survey</title>
	</head>
	<body>
		<p> ${title} </p>
		<p> ${description} </p>
		<p> ${timestamp} </p>
		<form method="post">
			<c:forEach begin="1" step="1" end="${fn:length(questions)}" varStatus="i">
				<p> ${questions[i.count-1].question} </p>
				<c:if test="${questions[i.count-1].questionType eq 1}">
					<c:forEach begin="1" step="1" end="${fn:length(questionChoices[i.count-1])}" varStatus="j">
						<input type="checkbox" name="${questions[i.count-1].id}" value="${questionChoices[i.count-1][j.count-1].id}"/>${questionChoices[i.count-1][j.count-1].questionChoice}<br/>
					</c:forEach>
				</c:if>
				<c:if test="${questions[i.count-1].questionType eq 2}">
					<c:forEach begin="1" step="1" end="${fn:length(questionChoices[i.count-1])}" varStatus="j">
						<input type="radio" name="${questions[i.count-1].id}" value="${questionChoices[i.count-1][j.count-1].id}"/>${questionChoices[i.count-1][j.count-1].questionChoice}<br/>
					</c:forEach>
				</c:if>
				<c:if test="${questions[i.count-1].questionType eq 3}">
						<input type="text" name="${questions[i.count-1].id}"/><br/>
				</c:if>
				<c:if test="${questions[i.count-1].questionType eq 4}">
						<textarea name="${questions[i.count-1].id}" rows="4" cols="40"></textarea>
				</c:if>
			</c:forEach>
			<input type="submit" name="submit" value="Save"/> 
			<input type="submit" name="submit" value="Respond"/>
		</form>
	</body>
</html>