<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Security Basic Demo (XML)</title>
</head>
<body>
	<div align="center">
		<h1>Welcome</h1>
	</div>

	<%--If Admin user -  show admin panel link--%>
	<c:if test="${pageContext.request.isUserInRole('ROLE_ADMIN') == true}">
		<h3>
			<a href="<c:url value="admin"/>">Admin panel</a>
		</h3>
	</c:if>

	<%--If anonymus -  show login link--%>
	<div class="login-link-container">
			<c:if test="${pageContext.request.userPrincipal.name == null}">
				<p>
					<a href="/login">LogIn</a>
				</p>
			</c:if>
	</div>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h3>Welcome : ${pageContext.request.userPrincipal.name} | <a href="<c:url value="/logout" />" > Logout</a></h3>
	</c:if>



	<%--If anonym -  show the reg form--%>
	<c:if test="${pageContext.request.userPrincipal.name == null}">

		<h3>Please fill form to register new account</h3>

		<c:url var="addAction" value="register"/>

		<form:form action="${addAction}" commandName="user">
			<table>
				<tr>
					<td>
						<form:label path="firstName">
							<spring:message text="First name"/>
						</form:label>
					</td>
					<td>
						<form:input path="firstName"/>
					</td>
				</tr>
				<tr>
					<td>
						<form:label path="lastName">
							<spring:message text="Last Name"/>
						</form:label>
					</td>
					<td>
						<form:input path="lastName"/>
					</td>
				</tr>
				<tr>
					<td>
						<form:label path="apartment">
							<spring:message text="Apartment"/>
						</form:label>
					</td>
					<td>
						<form:input path="apartment"/>
					</td>
				</tr>
				<tr>
					<td>
						<form:label path="contactPhoneNumber">
							<spring:message text="Phone Number"/>
						</form:label>
					</td>
					<td>
						<form:input path="contactPhoneNumber"/>
					</td>
				</tr>
				<tr>
					<td>
						<form:label path="password">
							<spring:message text="Password"/>
						</form:label>
					</td>
					<td>
						<form:input path="password"/>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="<spring:message text="Register user"/>"/>
					</td>
				</tr>
			</table>
		</form:form>
	</c:if>



</body>
</html>