
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit survey title - ${survey.title}</title>
</head>
<body>
	<form action="survey/${survey.id}/description" method="PUT">
		Enter the description:<br/>
		<textarea rows="5" cols="10">${survey.description}</textarea>
		<input type="submit" value="Change Description">
	</form>
</body>
</html>