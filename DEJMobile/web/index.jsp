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
        <%@include file="include.jsp" %>
        <style>
            html{
                background: url(images/bg-login.jpg) no-repeat;
                background-size: cover;
                background-attachment: fixed;
                margin: 0;
                width: 100%;
                height: 100%;
            }

        </style>

        <title>DEJ Mobile - Acceso</title>
    </head>
    <body>


        <div class="contenedor-login">

            <div class="contenedor-login-bienvenida">
                <div style="padding:25px; text-align: center; color:#FFF;">
                    <h1>BIENVENIDO A</h1>
                    <img src="images/logo.png" alt="DEJ Mobile">
                </div>

            </div>

            <div class="contenedor-login-form">                    
                <div style="padding:25px; text-align: center;">                        
                    <form class="uk-form" action="action">
                        <h1>DATOS DE ACCESO</h1>
                        <div class="uk-form-row uk-form-icon">
                            <i class="uk-icon-user"></i>
                            <input type="text" class="uk-form-large uk-form-width-large" name="rut" value="" placeholder="Ingrese Rut" autofocus />
                        </div>
                        <div class="uk-form-row uk-form-icon">
                            <i class="uk-icon-key"></i>
                            <input type="password" class="uk-form-large uk-form-width-large" name="rut" value="" placeholder="Ingrese Contraseña"/>
                        </div>
                        <div class="uk-form-row" >
                            <input type="submit" style="color:white; font-size: 14px;" class="uk-button uk-button-danger uk-width-1-1 uk-button-large" value="Ingresar" />
                        </div> 
                    </form> 
                    <div>
                        <br/><br/><br/><br/>
                        <p>Si no tiene cuenta de cliente, registrese gratis </p>
                        <div class="uk-form-row" >
                            <a style="color:white; font-size: 14px;" class="uk-button uk-button-danger uk-width-1-1 uk-button-large" href="registro.jsp">Registrar Cuenta</a>

                        </div>
                    </div>
                </div>  

            </div>
        </div>


    </body>
</html>
