<%-- 
    Document   : principal
    Created on : 08-12-2016, 12:36:39
    Author     : Willywes
--%>
<%@page import="dao.SolicitudDAO"%>
<%@page import="java.util.List"%>
<%@page import="dto.SolicitudDTO"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                    <div class="uk-width-1-1" style="">
                        <c:if test="${not empty mensaje}">
                            <div class="uk-alert uk-alert-danger">
                                <p style="font-size: 24px;"><c:out value="${mensaje}" /></p>
                            </div>
                        </c:if>
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
                                <%
                                    ClienteDTO user = null;
                                    List<SolicitudDTO> listita = null;

                                    if (session != null) {

                                        if (session.getAttribute("clienteSession") != null) {

                                            user = (ClienteDTO) session.getAttribute("clienteSession");
                                            listita = new SolicitudDAO().readAllUser(user.getRut());

                                        } else {
                                            response.sendRedirect("index.jsp");
                                        }
                                    } else {
                                        response.sendRedirect("index.jsp");
                                    }

                                    
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
                                        <td><b><span style="float:left;">$&nbsp;</span><span style="float:right;"><fmt:formatNumber value="${c.getTotal()}" pattern="###,###" />.-</span></b></td>
                                        <!--  <td><a href="arma-tu-plan.jsp" class="uk-button uk-button-danger"><i class="uk-icon-remove"></i>&nbsp;Eliminar</a></td>-->
                                        <td>

                                            <form action="<c:url value="/eliminar-solicitud"/>" method="post">
                                                <input type="hidden" name="idSolicitud" value="${c.getId()}">
                                                <button  type="submit" class="uk-button uk-button-danger" data-uk-tooltip title="Eliminar"><i data-uk-tooltip title="Eliminar" class="uk-icon-trash"></i></button>
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
