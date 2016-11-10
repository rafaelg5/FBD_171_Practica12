<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar cliente</title>
    </head>
    <body>
        <form action="registro_de_proveedor.jsp" method="post">
            <p>Nombre
                <input type="text" required="true" name="nombreP"></p>
            <p>RFC
                <input type="text" required="true" name="rfcP"></p>
            <p>Sucursal
                <input type="text" required="true" name="sucuP"></p>
	    <p>Fecha
                <input type="text" required="true" name="fechP"></p>
            <p>Costo
                <input type="text" required="true" name="costoP"></p>
	    <p>Cantidad
                <input type="text" required="true" name="cantidP"></p>
	    <p>Calle
                <input type="text" required="true" name="calleP"></p>
	    <p>Colonia
                <input type="text" required="true" name="coloniaP"></p>
            <p>Código Postal
                <input type="text" required="true" name="cpP"></p>
	    <p>Observaciones
                <input type="text" required="true" name="obsP"></p>
	    <p>Municipio
                <input type="text" required="true" name="munP"></p>
	    <p>Estado
                <input type="text" required="true" name="estadP"></p>

            <input type="submit" value="Registrar">
        </form>
        <p><a href="../index.html">Inicio</a></p>
    </body>
</html>
