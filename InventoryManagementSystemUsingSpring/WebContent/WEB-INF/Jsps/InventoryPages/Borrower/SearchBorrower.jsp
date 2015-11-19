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
		<div id="borrowerContainer">
			<c:set var="context" value="${pageContext.request.contextPath}" />
			<form action="${context}/searchBorrower" method="post">
				<table>
					<tr>
						<td><input name="name" class="input" placeholder="Enter Name"/></td>
						<td><input type="submit" Value="Submit" class="button"></td>
					</tr>
				</table>
			</form>
		</div>
		
		<div>
			<p style="color:red;">${msg}</p>
		</div>
		
		<div id="borrowerTable">
			<table class="borrowerTable">
				<tbody>
				<tr>
						<th colspan="5">Borrower Information</th>
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