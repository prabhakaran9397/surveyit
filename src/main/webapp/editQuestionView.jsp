<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit question - ${question.question}</title>
</head>
<body>
	Title |
	<span>${question.question}</span> |
	<a href="/surveyit/question/${id}/title">Edit</a>
	<br/>
	Type | ${question.questionType}
	<br/>
	<c:if test="${(question.questionType eq 1) or (question.questionType eq 2)}">
		Choices : <br/>
		<c:if test="${question.questionType eq 1}">
				<c:forEach var="choice" items="${choices}">
					<input type="checkbox" disabled /> ${choice.questionChoice}
				| <a href="/surveyit/questionchoice/${choice.id}">Edit</a>
					<br/>
				</c:forEach>
			</c:if>
			<c:if test="${question.questionType eq 2}">
				<c:forEach var="choice" items="${question.questionChoices}">
					<input type="radio" disabled /> ${choice.questionChoice}
					| <a href="/surveyit/questionchoice/${choice.id}">Edit</a>
					<br/>
				</c:forEach>
			</c:if>
			<h3>Add choice</h3>
			<form action="/surveyit/questionchoice" method="POST">
				<input type="text" name="questionChoice">
				<input type="hidden" name="questionId" value="${question.id}">
				<input type="submit" value="Add choice">
			</form>
	</c:if>
	
</body>
</html>