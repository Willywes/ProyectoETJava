<%-- 
    Document   : armaTuPlan
    Created on : 02-12-2016, 14:14:53
    Author     : Sebastian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DEJ Mobile</title>
    </head>
    <body>
        <h1>Arma tu Plan :: Paso 1</h1>
        <table>
            <tr>
                <td>Cuota</td>
                <td><select></select></td>
            </tr>
            <%-- estos radio son solo una cascara visual, no estoy seguro pero
creo que para traerlos de la base de datos es con un "for" --%>
            <tr>
                <td></td>
                <td><input type="radio" name="cuota" value=""/>800</td>
            </tr>
            <tr>
                <td>Minutos</td>
                <td><input type="radio" name="cuota" value=""/>2000</td>
            </tr>
            <tr>
                <td></td>
                <td><input type="radio" name="cuota" value=""/>3000</td>
            </tr>
            <tr>
                <td></td>
                <td><input type="checkbox" name="domicilio" value=""/>Entrega del Chip en domicilio</td>
            </tr>
            <tr>
                <td><a>Volver</a></td>
                <td><input type="submit" value="Paso 2"/></td>
            </tr>
        </table>
    </body>
</html>
