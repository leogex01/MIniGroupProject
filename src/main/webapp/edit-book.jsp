<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="editBookServlet" method="post">
		Store: <input type="text" name="bookTitle" value="${toEdit.bookTitle}">
		Item: <input type="text" name="bookAuthor" value="${toEdit.bookAuthor}">
		<input type="hidden" name="id" value="${toEdit.id}"> <input
			type="submit" value="Save Edited Book">

	</form>
</html>