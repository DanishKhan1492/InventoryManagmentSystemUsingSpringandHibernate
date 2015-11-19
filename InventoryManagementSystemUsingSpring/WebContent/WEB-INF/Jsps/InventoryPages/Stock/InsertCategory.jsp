<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Category</title>
<link rel="stylesheet" href="resources/Css/InsertCategoryCss.css"
	type="text\css">
<link rel="stylesheet" href="resources/Css/inputCss.css" type="text\css">

</head>
<body>
	<div id="container">
		<div id="menu"><jsp:include page="StockMenu.jsp"></jsp:include></div>

		<div>
			<div id="categoryDetails"> 
				<br/><br/><br/>
				<div id="messageContainer" style="color:${color}; font-size:20px;">
					<c:if test="${msg != null}">
						<span class="message">${msg}</span>
					</c:if>
				</div>
				
				<div>
				
					<c:set var="context" value="${pageContext.request.contextPath}" />

					<form:form action="${context}/addCategory" method="post"
						commandName="category">
						<table>
							<tr>
								<td><form:label path="catName" cssClass="label"> Category Name</form:label></td>
								<td><form:input path="catName" cssClass="input" placeholder="Category Name" /></td>
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
								<td></td>
								<td><input type="submit" value="Add Category" class="button"></td>
								<td></td>
							</tr>
						</table>
					</form:form>
					
				</div>
				
			</div>
			

		</div>

		<!-- Showing Categories in Table -->

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
							<td>${category.catId}</td>
							<td>${category.catName}</td>
							<td>${category.catUnit}</td>
							<td><a href="${delete}?catId=${category.catId}"
								class="genericon genericon-trash">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>
</body>
</html>