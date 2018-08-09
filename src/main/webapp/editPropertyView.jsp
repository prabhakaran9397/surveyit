<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Survey - ${survey.title}</title>
</head>
<body>
	Title: <span id="title-p">${survey.title}</span><input type="button" id="button-p">
	<form action="/survey/${survey.id}/title" method="PUT" id="form-p"><input type="text"name="value"></form>
	
	Description: <span id="description-p">${survey.description}</span><input type="button" id="button-d">
	<form action="/survey/${survey.id}/description" method="PUT" id="form-d"><input type="text"name="value"></form>
	
	<input type="button" value="Add question">
	<form action="/survey/${survey.id}/question" method="POST" id="form-q">
		Question <input type="text" name="question">
		Type 
		<select name="questionType">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
		</select>
		<input type="question
	</form>
</body>
</html>