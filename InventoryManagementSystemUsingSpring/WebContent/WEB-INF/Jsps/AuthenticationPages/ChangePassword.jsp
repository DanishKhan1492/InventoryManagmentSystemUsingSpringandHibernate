<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
<link rel="stylesheet" type="text\css" href="resources/Css/Login.css"> 
</head>
<body>
	<c:set var="context" value="${pageContext.request.contextPath}" />
	<div id="container">
		<div id="messageContainer" style="color:#8e44ad; font-size:20px;">
			<c:if test="${msg != null}">
				<span class="message">${msg}</span>
			</c:if>
		</div>
		
		<div id="formContainer">
			<form:form action="${context}/changePassword" method="post" commandName="changePassword">
				<table>
					<tr>
						
						<td><form:label path="oldPassword" cssClass="label">Old Password</form:label></td>
						<td><form:input path="oldPassword" cssClass="input" placeholder="Old Password"/></td>
						<td><form:errors path="oldPassword" cssClass="label error" /></td>
					</tr>
					
					<tr>
						<td><form:label path="newPassword" cssClass="label"> New Password </form:label></td>
						<td><form:password path="newPassword" cssClass="input" placeholder="New Password" /></td>
						<td><form:errors path="newPassword" cssClass="label error" /></td>
					</tr>
					
					<tr>
						<td><form:label path="confirmNewPassword" cssClass="label"> Confirm New Password </form:label></td>
						<td><form:password path="confirmNewPassword" cssClass="input" placeholder="Confirm New Password" /></td>
						<td><form:errors path="confirmNewPassword" cssClass="label error" /></td>
					</tr>
					
					<tr>
						<td><a href="${context}/loginPage" class="button">Go To Login Page</a></td>
						<td><input type="submit" value="Change Password" class="button"></td>
					</tr>
					
				</table>
			</form:form>
		</div>
	</div>
</body>
</html>