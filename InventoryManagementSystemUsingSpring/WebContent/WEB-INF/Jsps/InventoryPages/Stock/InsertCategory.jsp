<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Category</title>
<link rel="stylesheet" href="resources/Css/InsertCategoryCss.css" type="text\css">
<link rel="stylesheet" href="resources/Css/Login.css" type="text\css">

</head>
<body>
	<div id="container">
		<div id="menu"><jsp:include page="StockMenu.jsp"></jsp:include></div>
		<div id="categoryDetails">
			
			<form:form action="" method="post" commandName="category">
				<table>
					<tr>
						<td><form:label path="catName" cssClass="label"> Category Name</form:label></td>
						<td><form:input path="catName" cssClass="input" placeholder="Category Name"/></td>
						<td><form:label path="catName" cssClass="label error" /></td>
					</tr>
					
					<tr>
						<td><form:label path="catUnit" cssClass="label"> Category Unit</form:label></td>
						<td><form:select path="catUnit" cssClass="select">
								<form:option value="Kg"></form:option>
								<form:option value="Packet"></form:option>
							</form:select></td>
						<td><form:label path="catUnit" cssClass="label error" /></td>
					</tr>
					
					<tr>
						<td><input type="submit" value="Add Category" class="button"></td>
					</tr>
				</table>
			</form:form>
			
		</div>

		<div id="categoryTable">
			<table class="catTable">
				<tbody>
				<tr>
						<th colspan="5">Category Information</th>
					</tr>
					<tr>
						<th>Category Id</th>
						<th>Category Name</th>
						<th>CategoryUnit</th>
						<th>Delete</th>
					</tr>
				<c:url var="delete" value="/deleteCategory"></c:url>
				<c:forEach var="category" items="${categories}">
					<tr>
						<td>${category.id}</td>
						<td>${category.categoryName}</td>
						<td>${category.categoryUnit}</td>
						<td><a href="${delete}?Cat_Name=${category.categoryName}" class="genericon genericon-trash">Delete</a></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>

	</div>
</body>
</html>