<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Borrower</title>
<link rel="stylesheet" href="resources/Css/Login.css" type="text\css">
<link rel="stylesheet" href="resources/Css/AddBorrower.css" type="text\css">
</head>
<body>
	<div id="Container">
		<div id="menu"><jsp:include page="BorrowerMenu.jsp"></jsp:include></div>
		
		<div class="borrowerContainer"><br/>
			<c:set var="context" value="${pageContext.request.contextPath}" />
			
			<form:form action="${context}/borrower" method="post" commandName="borrower">
				<table>
					<tr>
						<td><form:hidden path="borrowerId"/></td>
					</tr>
					<tr>
						<td><form:label path="borrowerName" cssClass="label">Borrower Name</form:label></td>
						<td><form:input path="borrowerName" cssClass="input" placeholder="Borrower Name"/></td>
						<td><form:errors path="borrowerName" cssClass="label error" /></td>
					</tr>
					
					<tr>
						<td><form:label path="cnic" cssClass="label">Borrower Cnic</form:label></td>
						<td><form:input path="cnic" cssClass="input" placeholder="Borrower CNIC"/></td>
						<td><form:errors path="cnic" cssClass="label error" /></td>
					</tr>
					
					<tr>
						<td><form:label path="address" cssClass="label">Borrower Address</form:label></td>
						<td><form:input path="address" cssClass="input" placeholder="Borrower Address"/></td>
						<td><form:errors path="address" cssClass="label error" /></td>
					</tr>
					
					<tr>
						<td><form:label path="contactNumber" cssClass="label">Borrower Phone</form:label></td>
						<td><form:input path="contactNumber" cssClass="input" placeholder="Borrower Phone"/></td>
						<td><form:errors path="contactNumber" cssClass="label error" /></td>
					</tr>
					
					<tr>
						<td><form:label path="debtAmount" cssClass="label">Debt Amount</form:label></td>
						<td><form:input path="debtAmount" cssClass="input" placeholder="Borrower Debt"/></td>
						<td><form:errors path="debtAmount" cssClass="label error" /></td>
					</tr>
					
					<tr>
						<td><input type="submit" Value="Add" class="button" name="actionType"></td>
						<td><input type="submit" Value="Update" class="button" name="actionType"></td>
						<td><input type="submit" Value="Search" class="button" name="actionType"></td>
						<td><input type="submit" Value="Delete" class="button" name="actionType"></td>
					</tr>
					
				</table>
			</form:form>
		</div>
		
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
		
		<div id="borrowerTable">
			<table class="borrowerTable">
				<tbody>
				<tr>
						<th colspan="8">Borrower Information</th>
					</tr>
					<tr>
						<th>Borrower Id</th>
						<th>Borrower Name</th>
						<th>Borrower CNIC</th>
						<th>Borrower Address</th>
						<th>Borrower Phone Number</th>
						<th>Borrower Debt Amount</th>
					</tr>
				<c:forEach var="borrower" items="${borrowers}">
					<tr>
						<td>${borrower.borrowerId}</td>
						<td>${borrower.borrowerName}</td>
						<td>${borrower.cnic}</td>
						<td>${borrower.address}</td>
						<td>${borrower.contactNumber}</td>
						<td>${borrower.debtAmount}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		
	</div>
</body>
</html>