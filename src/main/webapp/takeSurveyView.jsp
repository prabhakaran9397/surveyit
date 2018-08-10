<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Take Survey</title>
</head>
<body>
	<p>${title}</p>
	<p>${description}</p>
	<p>${timestamp}</p>
	<form method="post">
		<c:forEach begin="1" step="1" end="${fn:length(questions)}"
			varStatus="i">
			<p>${questions[i.count-1].question}</p>
			<c:if test="${questions[i.count-1].questionType eq 1}">
				<c:forEach begin="1" step="1"
					end="${fn:length(questionChoices[i.count-1])}" varStatus="j">
					<c:set var="found" value="0" />
					<c:forEach items="${qas[questions[i.count-1]]}" var="a">
						<c:if test="${a == questionChoices[i.count-1][j.count-1].questionChoice}">
							<c:set var="found" value="1" />
						</c:if>
					</c:forEach>
					<c:if test="${found == '0'}">
						<input type="checkbox" name="${questions[i.count-1].id}" value="${questionChoices[i.count-1][j.count-1].questionChoice}" />${questionChoices[i.count-1][j.count-1].questionChoice}<br/>
					</c:if>
					<c:if test="${found == '1'}">
						<input type="checkbox" name="${questions[i.count-1].id}" value="${questionChoices[i.count-1][j.count-1].questionChoice}" checked/>${questionChoices[i.count-1][j.count-1].questionChoice}<br/>
					</c:if>
				</c:forEach>
			</c:if>
			<c:if test="${questions[i.count-1].questionType eq 2}">
				<c:forEach begin="1" step="1"
					end="${fn:length(questionChoices[i.count-1])}" varStatus="j">
					<c:if test="${qas[questions[i.count-1]][0] == questionChoices[i.count-1][j.count-1].questionChoice}">
						<input type="radio" name="${questions[i.count-1].id}"
							value="${questionChoices[i.count-1][j.count-1].questionChoice}" checked/>${questionChoices[i.count-1][j.count-1].questionChoice}<br />
					</c:if>
					<c:if test="${qas[questions[i.count-1]][0] != questionChoices[i.count-1][j.count-1].questionChoice}">
					<input type="radio" name="${questions[i.count-1].id}"
						value="${questionChoices[i.count-1][j.count-1].questionChoice}" />${questionChoices[i.count-1][j.count-1].questionChoice}<br />
					</c:if>
				</c:forEach>
			</c:if>
			<c:if test="${questions[i.count-1].questionType eq 3}">
				<input type="text" name="${questions[i.count-1].id}"
					value="${qas[questions[i.count-1]][0]}" />
				<br />
			</c:if>
			<c:if test="${questions[i.count-1].questionType eq 4}">
				<textarea name="${questions[i.count-1].id}" rows="4" cols="40">${qas[questions[i.count-1]][0]}</textarea>
			</c:if>
		</c:forEach>
		<input type="submit" name="submit" value="Save" /> <input
			type="submit" name="submit" value="Respond" />
	</form>
</body>
</html>