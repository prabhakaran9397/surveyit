<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit survey - ${survey.title}</title>
</head>
<body>
	Title |
	<span>${survey.title} |</span>
	<a href="${id}/title">Edit</a>
	<br />
	<br /> Description
	<p>${survey.description}</p>
	<a href="${id}/description">Edit</a>
	<br />
	<br />

	<h3>Questions</h3>
	<c:forEach var="question" items="${questions}">
		<div>
			<p>${question.question}</p>
			<c:if test="${question.questionType eq 1}">
				<c:forEach var="choice" items="${question.questionChoices}">
					<input type="checkbox" disabled /> ${choice.questionChoice}
					<br/>
				</c:forEach>
			</c:if>
			<c:if test="${question.questionType eq 2}">
				<c:forEach var="choice" items="${question.questionChoices}">
					<input type="radio" disabled /> ${choice.questionChoice}
					<br/>
				</c:forEach>
			</c:if>
			<a href="/surveyit/question/${question.id}">Edit</a>	
		</div>
		<hr size="7">
	</c:forEach>
	<h3>Add question</h3>
	<form method="POST" action="/surveyit/question">
		Question <input type="text" name="question">
		Type 
		<select name="questionType">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
		</select>
		<input type="hidden" name="surveyId" value="${survey.id}">
		<input type="submit" value="Add question">
	</form>

</body>
</html>