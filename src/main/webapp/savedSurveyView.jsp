<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit a survey</title>
</head>
<body>
	<h1>Edit the survey</h1>
	<form action="survey/${id}" method="POST">
		Title <input type="text" name="title" value="${title}">
		Description <input type="text" name="description" value="${description}">
		<c:set var="question_counter" value="1"></c:set>
		<c:forEach items="${questions}" var="question">
			<p>Question ${question_couter}</p>
			<input type="text" placeholder="Add a question" value="${question.question}" name="question"/>
			<textarea rows="5" cols="10">${question.description}</textarea>
			
		</c:forEach>
	</form>
</body>
</html>