<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Items</title>
<link rel="stylesheet" href="resources/Css/insertItem.css" type="text\css">
<link rel="stylesheet" href="resources/Css/inputCss.css" type="text\css">
</head>
<body>
	<div id="container">
		<div id="menu"><jsp:include page="StockMenu.jsp"></jsp:include></div>
		
		<div id="itemDetails">
			<c:set var="context" value="${pageContext.request.contextPath}" />
			
			<form:form action="${context}/insertItem" method="post" commandName="product">
				<table>
					<tr><td><form:hidden path="itemId"/></td></tr>
					<tr>
						<td><form:label path="itemName" cssClass="label"> Item Name </form:label></td>
						<td> <form:input path="itemName" cssClass="input" placeholder="Item Name"/> </td>
						<td> <form:errors path="itemName" cssClass="label error" /></td>
					</tr>
					
					<tr>
						<td><form:label path="itemQuantity" cssClass="label"> Item Quantity </form:label></td>
						<td> <form:input path="itemQuantity" cssClass="input" placeholder="Item Quantity"/> </td>
						<td> <form:errors path="itemQuantity" cssClass="label error" /></td>
					</tr>
					
					<tr>
						<td><form:label path="itemPrice" cssClass="label"> Item Price </form:label></td>
						<td> <form:input path="itemPrice" cssClass="input" placeholder="Item Price"/> </td>
						<td> <form:errors path="itemPrice" cssClass="label error" /></td>
					</tr>
					
					<tr>
						<td><form:label path="itemCategory.catName" cssClass="label"> Item Category </form:label></td>
						<td>
							<form:select path="itemCategory.catName" >
								<c:if test="${itemCategory.catName != null}">
									<form:option value="${itemCategory.catName.catName}" selected="true" />
								</c:if>
								<c:forEach var="categName" items="${categoriesList}">
									<form:option value="${categName.catName}" />
								</c:forEach>
							</form:select>
						</td>
						<td> <form:errors path="itemCategory.catName" cssClass="label error" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Add" name="actionType" class="button"></td>
						<td><input type="submit" value="Update" name="actionType" class="button"></td>
						<td><input type="submit" value="Search" name="actionType" class="button"></td>
						<td><input type="submit" value="Delete" name="actionType" class="button"></td>
					</tr>
				</table>
			</form:form>
			
		</div><br/><br/>
		<!-- Showing Message after completion of Action -->
		
		<div id="message">
			<c:if test="${msg == 'Successfully Added'}">
				<span class="message" style="color:green; font-size: 20px;">${msg}</span>
			</c:if>
			<c:if test="${msg == 'Successfully Updated'}">
				<span class="message" style="color:green; font-size: 20px;">${msg}</span>
			</c:if>
			<c:if test="${msg == 'Deleted Successfully'}">
				<span class="message" style="color:red; font-size: 20px;">${msg}</span>
			</c:if>
		</div>
		
		<!-- Showing items in table -->
		
		<div id="itemTable"><br/>
			<table class="itemTable">
				<tbody>
				<tr>
						<th colspan="5">Item Information</th>
					</tr>
					<tr>
						<th>Item Id</th>
						<th>Item Name</th>
						<th>Category Name</th>
						<th>Item Price</th>
						<th>Item Quantity</th>
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