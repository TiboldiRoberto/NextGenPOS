<%-- 
    Document   : users
    Created on : 15-Jan-2022, 14:41:41
    Author     : Roberto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Users">
    <h2>Users</h2>
    <c:forEach var="user" items="${users}" varStatus="status">
         <div class="row">
            <div class="col-md-4">
                ${user.id}
            </div>
            <div class="col-md-4">
                ${user.email}
            </div>
            <div class="col-md-4">
                ${user.username}
            </div>
        </div>
    </c:forEach>
</t:pageTemplate>

