<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proveedor_Sucursal</title>
    </head>
    <body>
        <form action="Proveedor_Sucursal_proceso.jsp" method="post">
            <p>Nombre de la Sucursal
                <input type="text" required="true" name="nombreSucursal"></p>
            <input type="submit" value="Consultar">
        </form>
        <p><a href="../index.html">Inicio</a></p>
    </body>
</html>
