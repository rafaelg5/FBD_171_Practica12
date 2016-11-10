<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Eliminar Teléfono</h1>
        <form action="delete_telefono_proceso.jsp" method="post">
            <p>Numero de telefono  
            <input type="text" required="true" name="telefono"></p>   
            <input type="submit" value="Eliminar">
        </form>
        <p><a href="../index.html">Inicio</a></p>
    </body>
</html>
