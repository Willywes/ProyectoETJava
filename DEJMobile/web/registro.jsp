<%-- 
    Document   : registro
    Created on : 02-12-2016, 12:43:13
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
        <h1>DEJ Mobile :: Registro</h1>
        <form>
            <table>
                <tr>
                    <td>Rut</td>
                    <td><input type="text"/>*</td>
                </tr>
                <tr>
                    <td>Clave</td>
                    <td><input type="password"/>*</td>
                </tr>
                <tr>
                    <td>Confirmar Clave</td>
                    <td><input type="password"/>*</td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text"/>*</td>
                </tr>
                <tr>
                    <td>Apellido Paterno</td>
                    <td><input type="text"/>*</td>
                </tr>
                <tr>
                    <td>Apellido Materno</td>
                    <td><input type="text"/>*</td>
                </tr>
                <tr>
                    <td>Dirección</td>
                    <td><input type="text"/>*</td>
                </tr>
                <tr>
                    <td>Numeración</td>
                    <td><input type="text"/>*</td>
                </tr>
                <tr>
                    <td>Comuna</td>
                    <td><select>
                
            </select>*</td>
                </tr>
                <tr>
                    <td>Teléfono</td>
                    <td><input type="text"/></td>
                </tr>
                <tr>
                    <td><a href="<c:url value="index.jsp"/>">Volver</a></td>
                    <td><input type="submit" value="Enviar"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
