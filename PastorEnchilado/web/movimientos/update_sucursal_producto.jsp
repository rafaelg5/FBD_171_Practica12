<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Sucursal_Producto</title>
    </head>
    <body>
        <form action="update_sucursal_producto_proceso.jsp" method="post">
            <p>Nombre de la sucursal  
                <input type="text" required="true" name="sucursal"></p>
            <p>Nombre del producto
                <input type="text" required="true" name="producto"></p>
            <p>Nuevo precio
                <input type="text" required="true" name="precio"></p>
            <input type="submit" value="Actualizar">
        </form>
        <p><a href="../index.html">Inicio</a></p>
    </body>
</html>
