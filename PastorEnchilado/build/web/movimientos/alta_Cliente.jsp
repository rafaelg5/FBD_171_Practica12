<%-- 
    Document   : alta_estado
    Created on : 29-oct-2016, 1:26:53
    Author     : erick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AltaCliente</title>
    </head>
    <body>
        <h1>Alta Cliente</h1>
        <form action="alta_cliente_proceso.jsp" method="post">
            Nombre  <input type="text" required="true" name="nombre">
            Apellido Paterno  <input type="text" required="true" name="app">
            Apellido Materno  <input type="text" required="true" name="apm">
            Fecha de Nacimiento  <input type="text" required="true" name="fecha_nacimiento">
            Correo Electrónico  <input type="text" required="true" name="correo">
            Monedero Electrónico  <input type="text" required="true" name="monedero">
            Saldo  <input type="number" required="true" name="saldo">
            FechaRegistro <input type="text" required="true" name="fecha_registro">
            Telefono Casa <input type="text" required="true" name="telefono">
            <input type="submit" value="Registrar">
        </form>
    </body>
</html>
