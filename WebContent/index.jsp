<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TinyLink</title>
</head>
<body>
	<h1>Hello!</h1>
	<form action="shortServlet" method="post">
    	Enter your link (starting from web site name e.g. google.com/...) <br/>
    	http(s)://<input type="text" name="link" size="20" placeholder="google.com">
    <input type="submit" value="Shorter!" />
</form>
</body>
</html>