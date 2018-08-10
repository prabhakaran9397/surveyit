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
	<a href="/survey/${id}/title">Edit</a>
	<br />
	<br /> Description
	<p>${survey.description}</p>
	<a href="/survey/${id}/description">Edit</a>
	<br />
	<br />

	<h3>Questions</h3>
	<c:forEach var="question" items="${survey.questions}">
		<div>
			<p>${question.question}</p>
			<c:if test="${question.questionType==1}">
				<c:forEach var="choice" items="${question.questionChoices}">
					<input type="checkbox" disabled /> ${choice.questionChoice}
					<br/>
				</c:forEach>
			</c:if>
			<c:if test="${question.questionType==2}">
				<c:forEach var="choice" items="${question.questionChoices}">
					<input type="radio" disabled /> ${choice.questionChoice}
					<br/>
				</c:forEach>
			</c:if>
			<a href="/question/${question.id}">Edit</a>
		</div>
	</c:forEach>

</body>
</html>