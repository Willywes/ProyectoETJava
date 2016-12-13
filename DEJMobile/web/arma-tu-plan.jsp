<%-- 
    Document   : principal
    Created on : 08-12-2016, 12:36:39
    Author     : Willywes
--%>
<%@page import="dto.SolicitudDTO"%>
<%@page import="dao.MinutoDAO"%>
<%@page import="dto.MinutoDTO"%>
<%@page import="dao.NavegacionDAO"%>
<%@page import="dto.NavegacionDTO"%>
<%@page import="java.util.List"%>
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

        <title>DEJ Mobile - Arma tu Plan</title>
    </head>
    <body>
        <div class="contenedor">
            <%@include file="barra-usuario.jsp" %>
            <div class="panel-principal">
                <div class="uk-grid">


                    <div class="uk-width-1-1">
                        <h1>ARMA TU PLAN</h1>
                        <p></p>                       
                    </div>
                    <div class="uk-width-1-1" style="">
                        <c:if test="${not empty mensaje}">
                            <div class="uk-alert uk-alert-danger">
                                <p style="font-size: 24px;"><c:out value="${mensaje}" /></p>
                            </div>
                        </c:if>
                        <c:if test="${not empty mapMensajes}">

                            <div class="uk-alert uk-alert-danger">
                                <div><c:out value="${mapMensajes['navegacion']}"/></div>
                                <div><c:out value="${mapMensajes['minutos']}"/></div>

                            </div>
                        </c:if>
                    </div> 
                    <div class="uk-width-1-1">
                        <form class="uk-form" action="<c:url value="/armar-solicitud"/>" method="post">
                            <fieldset data-uk-margin>
                                <p><em>(*) Campos Obligatorios</em></p>

                                <div class="uk-form-row">
                                    <span>(*)&nbsp;<b>Cuota :&nbsp;</b></span>
                                    <select name="navegacion" >
                                        <option value="">(Seleccione Navegación)</option>
                                        <%
                                            List<NavegacionDTO> lista = new NavegacionDAO().readAll();                                                                                 
                                        %>
                                        <c:forEach var="c" items="<%=lista%>">
                                            <option value="${c.getId()}" ${c.getId() == solicitud.getNavegacionDTO().getId() ? 'selected':''}>
                                            <c:out value="${c.getDescripcion()}"/>          
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <p></p>
                                <div class="uk-form-row">
                                    <span>(*)&nbsp;<b>Minutos :&nbsp;</b></span>
                                    <%
                                        List<MinutoDTO> listaMinutos = new MinutoDAO().readAll();  

                                    %>
                                    <c:forEach var="m" items="<%=listaMinutos%>">
                                        <input type="radio" name="minutos" value="${m.getId()}" ${m.getId() == solicitud.getMinutoDTO().getId() ? 'checked':''}> ${m.getDescripcion()} &nbsp;
                                    </c:forEach>
                                </div>
                                <p></p>
                                <div class="uk-form-row">
                                    <span><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Entrega en Domicilio :&nbsp;</b></span>
                                    <input type="checkbox" name="entrega" value="true" ${solicitud.getEntrega() ? 'checked':''}>
                                </div>
                                <br/>
                                <div class="uk-form-row">
                                    <input class="uk-button uk-button-danger uk-button-large" style="float:left; color:#fff;" type="submit" value="Paso 2"/>
                                    <input class="uk-button uk-button-danger uk-button-large" style="float:right; color:#fff;" type="reset" value="Limpiar"/>
                                    &nbsp;
                                    &nbsp;

                                    <input class="uk-button uk-button-danger uk-button-large" style="float:right; color:#fff; margin: 0 5px;" type="button" onclick="location.href='principal.jsp';" value="Volver"/>
                                </div>

                            </fieldset>
                        </form> 
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
