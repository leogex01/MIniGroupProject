<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form method="post" action="navigationServlet">
		<table>
			<c:forEach items="${requestScope.allBook}" var="currentbook">
				<tr>
					<td><input type="radio" name="id" value="${currentbook.id}">
					</td>
					<td>${currentitem.bookTitle}</td>
					<td>${currentitem.bookAuthor}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToBookAuthor"> <input
			type="submit" value="delete" name="doThisToBookAuthor"> <input
			type="submit" value="add" name="doThisToBookAuthor">
	</form>
</body>
</html>