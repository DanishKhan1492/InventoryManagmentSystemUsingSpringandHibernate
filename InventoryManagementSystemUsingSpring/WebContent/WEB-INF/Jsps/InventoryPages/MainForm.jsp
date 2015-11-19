<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Form</title>
<link rel="stylesheet" type="text\css" href="resources/Css/Menu.css"> 
</head>
<body>
	<c:set var="context" value="${pageContext.request.contextPath}" />
	<div id="container">
		<div id="options">
			<span><a href="${context}/stockPage" class="button">Stock</a></span>
			<span><a href="${context}/borrowerPage" class="button">Borrower</a></span>
			<span><a href="${context}/createBillPage" class="button">Billing</a></span>
			<span><a href="${context}/logout" class="button">Logout</a></span>
		</div>
	</div>
</body>
</html>