<%-- 
    Document   : registro
    Created on : 02-12-2016, 12:43:13
    Author     : Sebastian
--%>

<%@page import="java.util.List"%>
<%@page import="dao.ComunaDAO"%>
<%@page import="dto.ComunaDTO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DEJ Mobile</title>
    </head>
    <body>
        <h1>DEJ Mobile :: Registro</h1>
        <form method="post" action="<c:url value="/AgregaClienteServlet" />">
            <table>
                <tr>
                    <td>Rut</td>
                    <td><input  maxlength="11" name="rut" type="text" placeholder="Ingrese Rut 11223344-K"/>*
                    <c:out value="${mapMensajes['rut']}" />
                    </td>
                </tr>
                <tr>
                    <td>Clave</td>
                    <td><input name="clave" type="password"/>*
                    <c:out value="${mapMensajes['clave']}" />
                    </td>
                </tr>
                <tr>
                    <td>Confirmar Clave</td>
                    <td><input name="clave-confirmar" type="password"/>*
                    <c:out value="${mapMensajes['clave-confirmar']}" />
                    </td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input name="nombre"type="text" placeholder="Ingrese Nombre"/>*
                    <c:out value="${mapMensajes['nombre']}" />
                    </td>
                </tr>
                <tr>
                    <td>Apellido Paterno</td>
                    <td><input name="paterno" type="text" placeholder="Ingrese Apellido Paterno"/>*
                    <c:out value="${mapMensajes['paterno']}" />
                    </td>
                </tr>
                <tr>
                    <td>Apellido Materno</td>
                    <td><input name="materno" type="text" placeholder="Ingrese Apellido Materno"/>*
                    <c:out value="${mapMensajes['materno']}" />
                    </td>
                </tr>
                <tr>
                    <td>Dirección</td>
                    <td><input name="direccion" type="text" placeholder="Ingrese Direccion"/>*
                    <c:out value="${mapMensajes['direccion']}" />
                    </td>
                </tr>
                <tr>
                    <td>Numeración</td>
                    <td><input name="numero" type="text" I/>*
                    <c:out value="${mapMensajes['numero']}" />
                    </td>
                </tr>
                <tr>
                    <td>Comuna</td>
                    <td>
                        <select name="id-comuna">
                            <option value="">(seleccione)</option>
                            <%
                               /* List<ComunaDTO> lista = new ComunaDAO().readAll();
                                ComunaDTO c = new ComunaDTO();
                                for (ComunaDTO d : lista) {
                                    out.println("<option value=\"" + d.getId()+ "\">" + d.getNombre() + "</option>");
                                }*/
                            %>
                            <option value="1101">ARICA</option>


                        </select>
                            <c:out value="${mapMensajes['id-comuna']}" />


                    </td>

                </tr>
                <tr>
                    <td>Teléfono</td>
                    <td><input name="telefono" maxlength="9" type="text" placeholder="Ingrese Direccion" />
                    <c:out value="${mapMensajes['telefono']}" /></td>
                </tr>
                <tr>
                    <td><a href="<c:url value="index.jsp"/>">Volver</a></td>
                    <td><input type="submit" value="Enviar"/></td>
                    
                    
                </tr>
            </table>
        </form>
                    <c:out value="${mensaje}" />
    </body>
</html>
