<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<div>
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
</div>
