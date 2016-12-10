<%-- 
    Document   : principal
    Created on : 08-12-2016, 12:36:39
    Author     : Willywes
--%>
<%@page import="dao.SolicitudDAO"%>
<%@page import="java.util.List"%>
<%@page import="dto.SolicitudDTO"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="include.jsp" %>
        <style>
            html{
                background: url(images/bg-principal.jpg) no-repeat;
                background-size: cover;
                background-attachment: fixed;
                margin: 0;
                width: 100%;
                height: 100%;
            }
        </style>

        <title>DEJ Mobile - Mi Cuenta</title>
    </head>
    <body>

        <%
            HttpSession miSession = (HttpSession) request.getSession();

            if (miSession.getAttribute("clienteSession") == null) {
                response.sendRedirect("index.jsp");
            }

        %> 
        <div class="contenedor">
            <%@include file="barra-usuario.jsp" %>
            <div class="panel-principal">
                <div class="uk-grid">


                    <div class="uk-width-1-1">
                        <h1>MIS SOLICITUDES</h1>
                        <p>
                            <a href="arma-tu-plan.jsp" class="uk-button uk-button-success uk-button-large"><i class="uk-icon-plus-circle"></i>&nbsp;Nueva Solicitud</a>
                        </p>
                    </div>

                    <div class="uk-width-1-1">
                        <table class="uk-table uk-table-striped">
                            <br/>
                            <caption>Mi solicitudes enviadas</caption>
                            <thead>
                                <tr>
                                    <th>Código</th>
                                    <th>Gigas</th>
                                    <th>Minutos</th>
                                    <th>Entrega Chip</th>
                                    <th>Teléfono</th>
                                    <th>Comuna</th>
                                    <th>Ingreso</th>
                                    <th>Total</th>  
                                    <th></th> 

                                </tr>
                            </thead>
                            <tbody>
                                <%                                    ClienteDTO user = (ClienteDTO) miSession.getAttribute("clienteSession");
                                    List<SolicitudDTO> listita = new SolicitudDAO().readAllUser(user.getRut());
                                %>
                                <c:forEach var="c" items="<%=listita%>">
                                    <tr>
                                        <td><c:out value="${c.getId()}"/></td>
                                        <td><c:out value="${c.getNavegacionDTO().getDescripcion()}"/></td>
                                        <td><c:out value="${c.getMinutoDTO().getDescripcion()}"/></td>
                                        <td><c:if test="${c.getEntrega() == true}">
                                                <c:out value="${c.getClienteDTO().getDireccion() } Nº ${c.getClienteDTO().getNumero()}"/>
                                            </c:if>
                                            <c:if test="${c.getEntrega() == false}">
                                                RETIRO EN SUCURSAL
                                            </c:if></td>
                                        <td><c:out value="${c.getClienteDTO().getTelefono()}"/></td>
                                        <td><c:out value="${c.getClienteDTO().getComunaDTO().getNombre()}"/></td>
                                        <td><fmt:formatDate value="${c.getFecha_hora()}" pattern="dd/MM/yyyy HH:mm:ss"/></td>
                                        <td><b><c:out value="${c.getTotal()}"/></b></td>
                                        <!--  <td><a href="arma-tu-plan.jsp" class="uk-button uk-button-danger"><i class="uk-icon-remove"></i>&nbsp;Eliminar</a></td>-->
                                        <td>
                                            <c:url var="EliminarSolicitud" value="/ListarParticipante">
                                                <c:param name="idSolicitud" value="${param.id}"/>
                                            </c:url>
                                            <form action = "${urlEliminar}" method="post">
                                                <input type="hidden" name="idSolicitud" value="${c.Id}">
                                                <input type="submit" class="uk-button uk-button-danger" value ="Eliminar" />
                                            </form>
                                        </td>


                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
