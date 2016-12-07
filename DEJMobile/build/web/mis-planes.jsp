<%-- 
    Document   : mis-planes
    Created on : 02-12-2016, 14:41:24
    Author     : Sebastian
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DEJ Mobile</title>
    </head>
    <body>
        <h1>Mis Planes</h1>
        <%-- aca con el for se llena la tabla --%>
        <table>
            <tr>
                <th>Código</th>
                <th>Gigas</th>
                <th>Minutos</th>
                <th>Entrega de Chip</th>
                <th>Teléfono</th>
                <th>Comuna</th>
                <th>Ingreso</th>
                <th>Total</th>
            </tr>
        </table>
        <a href="<c:url value="menu.jsp"/>">Volver</a>
    </body>
</html>
