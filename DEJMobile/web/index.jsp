<%-- 
    Document   : index
    Created on : 02-12-2016, 12:28:56
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
        <h1>DEJ Mobile</h1>
        <form title="Acceso">
            <table>
                <tr>
                    <td>Rut</td>
                    <td><input type="text" name="rut" value=""/></td>
                </tr>
                <tr>
                    <td>Clave</td>
                    <td><input type="password" name="clave" value=""/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Enviar" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><a href="<c:url value="registro.jsp"/>">Regístrate</a></td>
                </tr>
            </table>
        </form>
    </body>
</html>
