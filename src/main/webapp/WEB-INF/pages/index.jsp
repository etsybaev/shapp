<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>My home access controller</title>
</head>
<body>
	<div align="left">
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

	<%--If logged in - show logout button and access control buttons--%>
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h3>Welcome : ${pageContext.request.userPrincipal.name} | <a href="<c:url value="/logout" />" > Logout</a></h3>
		<%--This is the page to control all the access points--%>
		<jsp:include page="accessButtons.jsp"/>
	</c:if>


	<%--If anonym -  show the reg form--%>
	<c:if test="${pageContext.request.userPrincipal.name == null}">
			<jsp:include page="registerpages/signUpDiv.jsp"/>
	</c:if>


</body>
</html>