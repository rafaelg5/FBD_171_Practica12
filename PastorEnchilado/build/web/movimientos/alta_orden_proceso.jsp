<%@page import="control.Orden"%>
<%
    String cliente = request.getParameter("cliente");
    String empleado = request.getParameter("empleado");
    String sucursal = request.getParameter("sucursal");
    String producto1 = request.getParameter("p1");
    int cantidad1 = Integer.parseInt(request.getParameter("cant1"));
    String producto2 = request.getParameter("p2");
    int cantidad2 = Integer.parseInt(request.getParameter("cant2"));
    String producto3 = request.getParameter("p3");
    int cantidad3 = Integer.parseInt(request.getParameter("cant3"));
    String fecha = request.getParameter("fecha");
    int bDomicilio = Integer.parseInt(request.getParameter("domicilio"));

    Orden orden = new Orden();

    boolean b = false;

    orden.conecta();
    b = orden.setOrden(cliente, empleado, sucursal, producto1, cantidad1,
            producto2, cantidad2, producto3, cantidad3, fecha, bDomicilio);
    orden.desconecta();

    if (b) {
        out.write("Registro exitoso");
    } else {
        out.write("Registro fallido");
    }
%>

<p><a href="alta_orden.jsp">Agregar otra orden</a></p>
<p><a href="../index.html">Inicio</a></p>