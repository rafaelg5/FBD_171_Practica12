<%@page import="control.Telefono"%>
<%
    String telefono = request.getParameter("telefono");

    Telefono tel = new Telefono();

    boolean b = false;

    tel.conecta();
    b = tel.deleteTelefono(telefono);
    tel.desconecta();

    if (b) {
        out.write("Borrado exitoso");
    } else {
        out.write("Borrado fallido");
    }
%>

<p><a href="delete_telefono.jsp">Eliminar otro teléfono</a></p>
<p><a href="../index.html">Inicio</a></p>