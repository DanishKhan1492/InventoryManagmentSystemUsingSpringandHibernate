<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text\css" href="resources/Css/StockMenu.css"> 
</head>
<body>
	<div id="container">
		<c:set var="context" value="${pageContext.request.contextPath}" />
		<div id="options">
			<span><a href="${context}/borrowerPage" class="menubutton">Add Borrower</a></span>
			<span><a href="${context}/searchBorrowerPage" class="menubutton">Search</a></span>
			<span><a href="${context}/payAmountPage" class="menubutton">Pay Amount</a></span>
			<span><a href="${context}/showHistoryPage" class="menubutton">Show History</a></span>
			<span><a href="${context}/mainPage" class="menubutton">Home Page</a></span>
			<span><a href="${context}/logout" class="menubutton">Logout</a></span>
		</div>
	</div>
</body>
</html>