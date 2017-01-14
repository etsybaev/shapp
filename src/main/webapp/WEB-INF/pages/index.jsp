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
						<form:input required="required" pattern="[A-Za-z]{1,15}" path="firstName"/>
					</td>
				</tr>
				<tr>
					<td>
						<form:label path="lastName">
							<spring:message text="Last Name"/>
						</form:label>
					</td>
					<td>
						<form:input required="required" pattern="[A-Za-z]{1,15}" path="lastName"/>
					</td>
				</tr>
				<tr>
					<td>
						<form:label path="apartment">
							<spring:message text="Apartment"/>
						</form:label>
					</td>
					<td>
						<form:input required="required" pattern="[A-Za-z0-9]{1,15}" path="apartment"/>
					</td>
				</tr>
				<tr>
					<td>
						<form:label path="contactPhoneNumber">
							<spring:message text="Phone Number"/>
						</form:label>
					</td>
					<td>
						<form:input maxlength="12"  pattern="^[0-9]{12,12}$"  required="required"
									title="Phone number must be in international format and contains digits only. Ex. 380441234567"
									path="contactPhoneNumber"/>
					</td>
				</tr>
				<tr>
					<td>
						<form:label path="password">
							<spring:message text="Password"/>
						</form:label>
					</td>
					<td>
						<form:input required="required" pattern=".{4,10}"
									title="Password must be from 4 to 10 characters" maxlength="10" path="password"/>
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