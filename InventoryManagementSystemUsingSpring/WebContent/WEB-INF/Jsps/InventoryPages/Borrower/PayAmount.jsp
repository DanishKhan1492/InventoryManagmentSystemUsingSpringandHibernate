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
			
			<form:form action="${context}/payAmount" method="post" commandName="payAmount">
				<table>
					<tr>
						<td><form:label path="cnic" cssClass="label" >Cnic Number</form:label></td>
						<td><form:input path="cnic" cssClass="input" placeholder="Enter Cnic"/></td>
						<td><form:errors path="cnic" cssClass="label" /></td>
					</tr>
					<tr>
						<td><form:label path="paymentAmount" cssClass="label" >Payment Amount</form:label></td>
						<td><form:input path="paymentAmount" cssClass="input" placeholder="Enter Payment Amount"/></td>
						<td><form:errors path="paymentAmount" cssClass="label" /></td>
					</tr>
					<tr>
						<td></td>
						<td><td><input type="submit" Value="Submit" class="button"></td>
					</tr>
				</table>
			</form:form>
		</div>
		
		<div>
			<p style="color: green;">${msg}</p>
		</div>
	</div>
</body>
</html>