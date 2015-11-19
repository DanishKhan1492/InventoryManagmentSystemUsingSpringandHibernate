<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text\css" href="resources/Css/StockMenu.css"> 
</head>
<body>
	<div id="container">
		<c:set var="context" value="${pageContext.request.contextPath}" />
		<div id="options">
			<span><a href="${context}/insertCategoryPage" class="menubutton">Add Category</a></span>
			<span><a href="${context}/insertItemPage" class="menubutton">Add Product</a></span>
			<span><a href="${context}/searchItemPage" class="menubutton">Search Item</a></span>
			<span><a href="${context}/itemPricePage" class="menubutton">Show Prices</a></span>
			<span><a href="${context}/mainPage" class="menubutton">Home Page</a></span>
			<span><a href="${context}/logout" class="menubutton">Logout</a></span>
		</div>
	</div>
</body>
</html>