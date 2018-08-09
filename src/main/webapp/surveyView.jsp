<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Survey</title>
</head>
<body>
	<form action="/createSurvey" method="POST">
		Title<input type="text" name="title"><br/>
		Description
		<textarea rows="5" cols="10" name="description"></textarea>
		<button type="submit" formaction="saveSurvey">Save</button>
		<button type="submit" formaction="addQuestion">Add question</button>
	</form>
</body>
</html>