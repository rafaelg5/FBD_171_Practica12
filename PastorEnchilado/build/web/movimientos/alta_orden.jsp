<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar orden</title>
    </head>
    <body>
        <h1>Registrar orden</h1>
        <form action="alta_orden_proceso.jsp" method="post">
            <p>Monedero del cliente  
                <input type="text" required="true" name="cliente"></p>
            <p>RFC del mesero 
                <input type="text" required="true" name="empleado"></p>
            <p>Sucursal 
                <input type="text" required="true" name="sucursal"></p>
            <p>Producto 1 <input type="text" required="true" name="p1">
            Cantidad <input type="text" size = "1" required="true" name="cant1"></p>
            <p>Producto 2 <input type="text" required="true" name="p2">
            Cantidad <input type="text" size ="1" required="true" name="cant2"></p>
            <p>Producto 3 <input type="text" required="true" name="p3">
            Cantidad <input type="text" size = "1" required="true" name="cant3"></p>
            <p>Fecha 
                <input type="text" required="true" name="fecha"></p>
            <p>Pedido a domicilio 
                <input type="radio" name="domicilio" value = "1" checked> Sí
                <input type="radio" name="domicilio" value = "0"> No</p>
            <input type="submit" value="Registrar">            
        </form>
        <p><a href="../index.html">Inicio</a></p>
    </body>
</html>