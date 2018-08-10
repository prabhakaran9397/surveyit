<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit question - ${question}</title>
</head>
<body>
	Title |
	<span>${question.title}</span> |
	<a href="question/${id}/title">Edit</a>
	<br/>
	Type | ${question.questionType}
	<br/>
	<c:if test="${not empty choices}">
		Choices : <br/>
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
	</c:if>
	<
</body>
</html>