<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TinyLink</title>
</head>
<body>
	<h2>Hello!</h2>
	<form action="short" method="post">
    	Enter your link (starting from http(s)://...) <br/>
    	<input type="text" name="link" size="100" placeholder="https://google.com/...">
    <input type="submit" value="Shorter!" onclick="loading();"/>
	</form>
	<center>
		<img src = "${pageContext.request.contextPath}/images/loading.gif" id="img" style="display:none"/>
	</center>
    <script type="text/javascript">
    	function loading(){
    		document.getElementById("img").style.display = '';
    	}
    </script>
</body>
</html>