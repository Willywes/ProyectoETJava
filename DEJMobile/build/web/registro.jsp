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
        <%@include file="include.jsp" %>
        <style>
            html{
                background: url(images/bg-registro.jpg) no-repeat;
                background-size: cover;
                background-attachment: fixed;
                margin: 0;
                width: 100%;
                height: 100%;
            }

        </style>

        <title>DEJ Mobile - Registro de Clientes</title>
    </head>
    <body>
        <div class="contenedor-registro">
            <div style="padding:25px;"> 
                <form class="uk-form" method="post" action="<c:url value="/AgregaClienteServlet" />">
                    <h1 style="text-align: center;">REGISTRO DE CLIENTE</h1>
                    <p>(*) Campos Obligatorios</p>
                    <c:if test="${not empty mapMensajes}">

                        <div class="uk-alert uk-alert-danger">
                            <c:out value="${mapMensajes['rut']}"/><br/>
                            <c:out value="${mapMensajes['clave']}"/><br/>
                            <c:out value="${mapMensajes['clave-confirmar']}"/><br/>
                            <c:out value="${mapMensajes['nombre']}" /><br/>
                            <c:out value="${mapMensajes['paterno']}" /><br/>
                            <c:out value="${mapMensajes['materno']}" /><br/>
                            <c:out value="${mapMensajes['direccion']}" /><br/>
                            <c:out value="${mapMensajes['numero']}" /><br/>
                            <c:out value="${mapMensajes['id-comuna']}" /><br/>
                            <c:out value="${mapMensajes['telefono']}" /><br/>
                        </div>
                    </c:if>
                    <fieldset data-uk-margin>
                        <div class="uk-form-row">
                            <h3>RUT CLIENTE</h3>
                            <input maxlength="12" name="rut" type="text" value="<c:out value="${cliente.getRut()}" />" placeholder="Ingrese RUT"/>(*)
                        </div>
                        <div class="uk-form-row">
                            <h3>CONTRASEÑA</h3>
                            <input name="clave" type="password" placeholder="Clave"/>(*)&nbsp;
                            <input name="clave-confirmar" type="password" placeholder="Repita Clave"/>(*)
                        </div>
                        <div class="uk-form-row">
                            <h3>DATOS PERSONALES</h3>
                            <input name="nombre"type="text" value="<c:out value="${cliente.getNombre()}" />" placeholder="Nombre"/>(*)&nbsp;
                            <input name="paterno" type="text" value="<c:out value="${cliente.getPaterno()}" />" placeholder="Apellido Paterno"/>(*)&nbsp;
                            <input name="materno" type="text" value="<c:out value="${cliente.getMaterno()}" />" placeholder="Apellido Materno"/>(*)
                        </div>
                        <div class="uk-form-row">
                            <h3>DIRECCION</h3>
                            <input name="direccion" type="text" value="<c:out value="${cliente.getDireccion()}" />" placeholder="Ingrese su Calle"/>(*)&nbsp;
                            <input name="numero" style="width : 80px;" value="<c:out value="${cliente.getNumero()}" />" type="text" placeholder="N°"/>(*)&nbsp;
                            <select name="id-comuna" >
                                <option value="">(Seleccione)</option>
                                <%
                                    List<ComunaDTO> lista = new ComunaDAO().readAll();
                                %>
                                <c:forEach var="c" items="<%=lista%>">
                                    <option value="${c.getId()}" ${c.getId() == cliente.getComunaDTO().getId() ? 'selected':''}>
                                        <c:out value="${c.getNombre()}"/>         
                                    </option>

                                </c:forEach>

                            </select>(*)
                        </div>
                        <div class="uk-form-row">
                            <h3>CELULAR</h3>
                            <input name="telefono" maxlength="9" type="text" value="<c:out value="${telefono}" />" placeholder="N° Telefono"/>(*)
                        </div>
                        <br/>
                        <div class="uk-form-row">
                            <input class="uk-button uk-button-danger" style="float:left; color:#fff;"type="submit" value="Enviar"/>&nbsp;
                            <input class="uk-button uk-button-danger" style="float:right; color:#fff;" type="reset" value="Limpiar"/>
                        </div>

                    </fieldset>

                </form>
                <c:if test="${not empty mensaje}">

                    <div class="uk-alert uk-alert-danger">
                        <p style="font-size: 24px;"><c:out value="${mensaje}" /></p>
                    </div>
                </c:if>

            </div>
        </div>
    </body>
</html>

