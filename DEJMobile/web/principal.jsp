<%-- 
    Document   : principal
    Created on : 08-12-2016, 12:36:39
    Author     : Willywes
--%>
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
                                <tr>
                                    <td>100225</td>
                                    <td>20GB</td>
                                    <td>80 Minutos</td>
                                    <td>SI</td>
                                    <td>900684339</td>
                                    <td>VINA DEL MAR</td>
                                    <td>25/12/2016 14:00:05</td>
                                    <td><b>$5.400</b></td>
                                    <td><a href="arma-tu-plan.jsp" class="uk-button uk-button-danger"><i class="uk-icon-remove"></i>&nbsp;Eliminar</a></td>
                                </tr>
                                <tr>
                                    <td>100225</td>
                                    <td>20GB</td>
                                    <td>80 Minutos</td>
                                    <td>SI</td>
                                    <td>900684339</td>
                                    <td>VINA DEL MAR</td>
                                    <td>25/12/2016 14:00:05</td>
                                    <td><b>$5.400</b></td>
                                    <td><a href="arma-tu-plan.jsp" class="uk-button uk-button-danger"><i class="uk-icon-remove"></i>&nbsp;Eliminar</a></td>
                                </tr>
                                <tr>
                                    <td>100225</td>
                                    <td>20GB</td>
                                    <td>80 Minutos</td>
                                    <td>SI</td>
                                    <td>900684339</td>
                                    <td>VINA DEL MAR</td>
                                    <td>25/12/2016 14:00:05</td>
                                    <td><b>$5.400</b></td>
                                    <td><a href="arma-tu-plan.jsp" class="uk-button uk-button-danger"><i class="uk-icon-remove"></i>&nbsp;Eliminar</a></td>
                                </tr>
                                <tr>
                                    <td>100225</td>
                                    <td>20GB</td>
                                    <td>80 Minutos</td>
                                    <td>SI</td>
                                    <td>900684339</td>
                                    <td>VINA DEL MAR</td>
                                    <td>25/12/2016 14:00:05</td>
                                    <td><b>$5.400</b></td>
                                    <td><a href="arma-tu-plan.jsp" class="uk-button uk-button-danger"><i class="uk-icon-remove"></i>&nbsp;Eliminar</a></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
