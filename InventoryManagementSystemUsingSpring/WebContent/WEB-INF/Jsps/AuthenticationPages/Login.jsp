<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LOG IN</title>
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
			
			<form:form action="${context}/login" method="post" commandName="login">
				<table>
					<tr>
						
						<td><form:label path="userName" cssClass="label"> User Name </form:label></td>
						<td><form:input path="userName" cssClass="input" placeholder="User Name"/></td>
						<td><form:errors path="userName" cssClass="label error" /></td>
					</tr>
					
					<tr>
						<td><form:label path="password" cssClass="label"> Password </form:label></td>
						<td><form:password path="password" cssClass="input" placeholder="Password" /></td>
						<td><form:errors path="password" cssClass="label error" /></td>
					</tr>
					
					<tr>
						<td><a href="${context}/changePasswordPage" class="button">Change Password</a></td>
						<td><input type="submit" value="Login" class="button"></td>
					</tr>
					
				</table>
			</form:form>
		</div>
	</div>
</body>
</html>