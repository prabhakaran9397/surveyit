
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Enter the choice
	<form action="/surveyit/questionChoice/${choice.id}" method="POST">
		<input type="text" name="questionChoice" value="${choice.questionChoice}"/>
		<input type="submit" value="Save choice">
	</form>
	
</body>
</html>