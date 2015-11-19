<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Item</title>
<link rel="stylesheet" href="resources/Css/searchItem.css" type="text\css">
<link rel="stylesheet" href="resources/Css/Login.css" type="text\css">
</head>
<body>
	<div id="container">
		<div id="menu">
			<jsp:include page="StockMenu.jsp"></jsp:include>
		</div><br/><br/><br/>
		<br/><br/><br/>
		<div id="searchArea">
			<c:set var="context" value="${pageContext.request.contextPath}" />
			<div>
				<form action="${context}/searchItem" method="post">
				<table>
					<tr>
						<td><label for="searchItem" class="label"> Item Name</label></td>
						<td><input name="searchItem" class="input" placeholder="Item Name"/></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" Value="Submit" class="button"></td>
					</tr>
				</table>
			</form>
			</div>
			

		</div>
		
		<div id="itemTable">
			<table class="itemTable">
				<tbody>
				<tr>
						<th colspan="5">Item Information</th>
					</tr>
					<tr>
						<th>Item Id</th>
						<th>Item Name</th>
						<th>Category Name</th>
						<th>Item Quantity</th>
						<th>Item Price</th>

					</tr>
				<c:forEach var="item" items="${items}">
					<tr>
						<td>${item.itemId}</td>
						<td>${item.itemName}</td>
						<td>${item.itemCategory.catName}</td>
						<td>${item.itemPrice}</td>
						<td>${item.itemQuantity}</td>	
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>