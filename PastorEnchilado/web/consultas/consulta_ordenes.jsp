<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar Órdenes</title>
    </head>
    <body>
        <h1>Consulta Órdenes</h1>
        <form action="consulta_ordenes_proceso.jsp" method="post">
            Monedero del cliente  
            <input type="text" required="true" name="cliente">
            <input type="submit" value="Consultar">
        </form>
    </body>
</html>