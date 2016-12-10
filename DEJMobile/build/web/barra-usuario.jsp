<%@page import="dto.ClienteDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="user-bar">
    <div style="float:left; padding: 0 5px;">
        <script type="text/javascript"> 
                var meses = new Array ("Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"); 
                var diasSemana = new Array("Domingo","Lunes","Martes","Miércoles","Jueves","Viernes","Sábado"); 
                var f=new Date(); 
                document.write(diasSemana[f.getDay()] + ", " + f.getDate() + " de " + meses[f.getMonth()] + " de " + f.getFullYear()); 
            </script>
            &nbsp;|&nbsp;
            <script type="text/javascript"> 
                function startTime()
                { 
                    today=new Date(); 
                    h=today.getHours(); 
                    m=today.getMinutes(); 
                    s=today.getSeconds(); 
                    m=checkTime(m); 
                    s=checkTime(s); 
                    document.getElementById('reloj').innerHTML=h+":"+m+":"+s; 
                    t=setTimeout('startTime()',500);
                } 
                function checkTime(i) 
                {
                    if (i<10) {i="0" + i;}return i;
                } 
                window.onload=function()
                {
                    startTime();
                } 
                        
            </script> 
        <span id="reloj"></span>   
    </div>
    
    <div style="float: right; padding: 0 5px;">
        <span>Bienvenido : <c:out value="${sessionScope.clienteSession.getNombreCompleto()}"/> | </span><a href="cerrar-sesion" accesskey="1" title="Cerrar Sesión">Cerrar Sesión</a>
    </div>
</div>