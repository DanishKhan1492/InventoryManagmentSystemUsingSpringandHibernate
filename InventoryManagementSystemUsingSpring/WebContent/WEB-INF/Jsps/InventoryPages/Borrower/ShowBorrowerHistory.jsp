<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Borrower</title>
<link rel="stylesheet" href="resources/Css/Login.css" type="text\css">
<link rel="stylesheet" href="resources/Css/BorrowerHistory.css" type="text\css">
</head>
<body>
	<div id="Container">
		<div id="menu"><jsp:include page="BorrowerMenu.jsp"></jsp:include></div>
		<div id="borrowerContainer">
			<c:set var="context" value="${pageContext.request.contextPath}" />
			
			<form action="${context}/showHistory" method="post">
				<table>
					<tr>
						<td><label for="cnic" class="label">Borrower CNIC</label></td>
						<td><input type="text" name="cnic" class="input" required="required" Placeholder="Enter CNIC" ></td>
					</tr>
					<tr>
						<td><label for="searchDate" class="label">Date</label></td>
						<td><input type="date" name="searchDate" class="input" Placeholder="Enter Date" ></td>
					</tr>
					
					<tr>
						<td></td>
						<td><td><input type="submit" Value="Submit" class="button"></td>
					</tr>
					
				</table>
			</form>

			<div>
				<h3 style="color:red;">${msg}</h3>
			</div>

		</div>
		
		<div id="borrowerTable">
			<table class="table">
				<tbody>
				<tr>
						<th colspan="6">Borrower Information</th>
					</tr>
					<tr>
						<th>Borrower Id</th>
						<th>Borrower Name</th>
						<th>Borrower CNIC</th>
						<th>Borrower Address</th>
						<th>Borrower Phone Number</th>
						<th>Borrower Debt Amount</th>
					</tr>
				<%-- <c:forEach var="borrower" items="${borrower}"> --%>
					<tr>
						<td>${borrower.borrowerId}</td>
						<td>${borrower.borrowerName}</td>
						<td>${borrower.cnic}</td>
						<td>${borrower.address}</td>
						<td>${borrower.contactNumber}</td>
						<td>${borrower.debtAmount}</td>
					</tr>
				<%-- </c:forEach> --%>
				</tbody>
			</table>
			<br/>
			<!-- ////////////////////////////////////////////////////////////////////////////////////////// -->
			<!-- ////////////////////////////////////////////////////////////////////////////////////////// -->
			<!-- ////////////////////////////////////////////////////////////////////////////////////////// -->
			 
			<table class="table">
				<tbody>
				<tr>
						<th colspan="8">Borrower Bill Information</th>
					</tr>
					<tr>
						<th>Bill Id</th>
						<th>CNIC</th>
						<th>Sub Total</th>
						<th>Total Amount</th>
						<th>Discount</th>
						<th>Amount Paid</th>
						<th>Due Amount</th>
						<th>Date</th>
					</tr>
				<c:forEach var="borrowerBills" items="${borrowerBills}">
					<tr>
						<td>${borrowerBills.billId}</td>
						<td>${borrowerBills.cnic}</td>
						<td>${borrowerBills.subTotal}</td>
						<td>${borrowerBills.totalAmount}</td>
						<td>${borrowerBills.discount}</td>
						<td>${borrowerBills.amountPaid}</td>
						<td>${borrowerBills.dueAmount}</td>
						<td>${borrowerBills.date}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			<br/>
			<!-- ////////////////////////////////////////////////////////////////////////////////////////// -->
			<!-- ////////////////////////////////////////////////////////////////////////////////////////// -->
			<!-- ////////////////////////////////////////////////////////////////////////////////////////// -->
			 
			<table class="table">
				<tbody>
				<tr>
						<th colspan="6">Bill Items Information</th>
					</tr>
					<tr>
						<th>Bill Id</th>
						<th>Item Name</th>
						<th>Item Quantity</th>
						<th>Item Price</th>
						<th>Total Item Price</th>
						<th>Date</th>
					</tr>
				<c:forEach var="billsItems" items="${borrowerBillItems}">
					<c:forEach var="billItems" items="${billsItems}">
							<tr>
								<td>${billItems.borrowerBill.billId}</td>
								<td>${billItems.itemName}</td>
								<td>${billItems.itemQuantity}</td>
								<td>${billItems.itemPrice}</td>
								<td>${billItems.totalItemPrice}</td>
								<td>${billItems.date}</td>
							</tr>
						</c:forEach>
				</c:forEach>
				</tbody>
			</table>
			<br/>
			<!-- ////////////////////////////////////////////////////////////////////////////////////////// -->
			<!-- ////////////////////////////////////////////////////////////////////////////////////////// -->
			<!-- ////////////////////////////////////////////////////////////////////////////////////////// -->
			 
			<table class="table">
				<tbody>
				<tr>
						<th colspan="6">Debt Amount Information</th>
					</tr>
					<tr>
						<th>Bill Id</th>
						<th>CNIC</th>
						<th>Last Amount</th>
						<th>New Amount</th>
						<th>Total Amount</th>
						<th>Date</th>
					</tr>
				<c:forEach var="amountBorrowed" items="${borrowerAmountBorrowed}">
					<tr>
						<td>${amountBorrowed.billId.billId}</td>
						<td>${amountBorrowed.cnic.cnic}</td>
						<td>${amountBorrowed.lastAmount}</td>
						<td>${amountBorrowed.newAmount}</td>
						<td>${amountBorrowed.totalAmount}</td>
						<td>${amountBorrowed.date}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			<br/>
			<!-- ////////////////////////////////////////////////////////////////////////////////////////// -->
			<!-- ////////////////////////////////////////////////////////////////////////////////////////// -->
			<!-- ////////////////////////////////////////////////////////////////////////////////////////// -->
			 
			<table class="table">
				<tbody>
				<tr>
						<th colspan="6">Amount Paid  Information</th>
					</tr>
					<tr>
						<th>CNIC</th>
						<th>Last Amount</th>
						<th>Amount Paid</th>
						<th>Amount Paid</th>
						<th>Date</th>
					</tr>
				<c:forEach var="amountPaid" items="${borrowerAmountPaid}">
					<tr>
						<td>${amountPaid.cnic}</td>
						<td>${amountPaid.lastAmount}</td>
						<td>${amountPaid.paymentAmount}</td>
						<td>${amountPaid.amountRemaining}</td>
						<td>${amountPaid.date}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			
		</div>
	</div>
</body>
</html>