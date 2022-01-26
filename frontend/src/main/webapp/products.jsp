<%-- 
    Document   : products.jps
    Created on : 16-Jan-2022, 14:41:57
    Author     : Roberto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Products">
<h2>Products</h2>
    <c:forEach var="prod" items="${products}" varStatus="status">
         <div class="row">
            <div class="col-md-4">
                ${prod.id}
            </div>
            <div class="col-md-4">
                ${prod.name}
            </div>
            <div class="col-md-4">
                ${prod.unit}
            </div>
        </div>
    </c:forEach>
</t:pageTemplate>