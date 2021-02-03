<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" type="text/css" href="/css/show.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Artist and Song</title>
</head>
<body>
	<a class="dashboard" href="/dashboard">Dashboard</a>
	<div class="container">
		<h1><c:out value="${shows.title}"/></h1>
		<p>Network: <c:out value="${shows.artist}"/></p>
		<p>Rating: <c:out value="${shows.rating}"/></p>
		<a href="/songs/delete/${shows.id}">Delete</a>
	</div>
</body>
</html>