<%@ page import="com.happ.model.UserRoles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <script src="<c:url value="/resources/script/userDelConfirm.js" />"></script>
    <title>Users Page</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<p><a href="../">Back to main menu</a></p>

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h3>Welcome : ${pageContext.request.userPrincipal.name} | <a href="<c:url value="/logout" />" > Logout</a></h3>
    </c:if>

<br/>
<br/>

<h1>Add a user</h1>

<c:url var="addAction" value="/admin/adduser"/>

<form:form action="${addAction}" commandName="user">
    <table>
        <c:if test="${!empty user.firstName}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>

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
            <td>
                <form:label path="enabled">
                    <spring:message text="Is enabled"/>
                </form:label>
            </td>
            <td>
                <select id="enabled" name="enabled">
                    <option value="-1">Select a type</option>
                    <option value="true">Active</option>
                    <option value="false">Inactive</option>
                </select>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="userRoles.Id">User Role</form:label>
            </td>
            <td>
                <form:select path="userRoles.Id">
                    <option value="-1">Select a type</option>
                    <c:forEach items="${userRolesList}" var="role">
                        <option value="${role.id}">${role.role}</option>
                    </c:forEach>
                </form:select>
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <c:if test="${!empty user.firstName}">
                    <input type="submit"
                           value="<spring:message text="Save changes"/>"/>
                </c:if>
                <c:if test="${empty user.firstName}">
                    <input type="submit"
                           value="<spring:message text="Add user"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>


<h1>User List</h1>

<c:if test="${!empty listUsers}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">First Name</th>
            <th width="120">Last Name</th>
            <th width="120">Apartment</th>
            <th width="120">Phone number</th>
            <th width="120">Is Active</th>

            <th width="60">Edit</th>
            <th width="60">Delete</th>
            <th width="60">See entrance history</th>
        </tr>
        <c:forEach items="${listUsers}" var="user">
            <tr>
                    <%--<td>${user.id}</td>--%>
                <%--additional code for Id param make its value a link to entrance history details--%>
                <td><a target="_blank" href="/admin/userdata/${user.id}" >${user.id}</a></td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.apartment}</td>
                <td>${user.contactPhoneNumber}</td>
                <td>${user.enabled}</td>

                <td><a href="<c:url value='/admin/edituser/${user.id}'/>">Edit</a></td>
                <%--<td><a href="<c:url value='/users/remove/${user.id}'/>">Delete</a></td>--%>
                <td><a href="javascript:deleteUser.deleteBook(${user.id})">Delete</a></td>
                <td><a target="_blank" href="<c:url value='/admin/userdata/${user.id}'/>">Entrance history</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
