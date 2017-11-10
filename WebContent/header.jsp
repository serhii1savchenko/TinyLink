<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- c:set var="context" value="${pageContext.request.contextPath}" />  -->

<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TinyLink</title>
<meta name="description" content="TinyLink is a simple and quick URL shortener" />
<meta name="keywords" content="URL shortener, TinyLink, Tiny Link, short link" />
	<!-- jQuery -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery-3.2.0.min.js"/></script>
	<!-- Bootstrap -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap-theme.min.css"> 
	<script src="${pageContext.request.contextPath}/resources/bootstrap.min.js"></script>
	<!-- Font Awesome -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/font-awesome-4.7.0/css/font-awesome.min.css">
	<!-- Social Buttons for Bootstrap -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap-social-gh-pages/bootstrap-social.css">
	<!-- Favicon -->
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico" />
	<!-- root path -->
	<script type="text/javascript"> var domainURL = window.location.protocol + "//"  + window.location.host + /* "" + window.location.pathname; */ "/"; </script>
</head>
<body>
	<center>
		<a href="" id="home"><img src = "${pageContext.request.contextPath}/resources/images/topImage.png" style="padding: 20px;"/></a>
		<script type="text/javascript">
			document.getElementById("home").href = domainURL;
		</script>
	</center>
