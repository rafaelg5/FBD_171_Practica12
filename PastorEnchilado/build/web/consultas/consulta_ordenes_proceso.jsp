<%@page import="control.ProductosOrden"%>
<%@page import="datos.Conexion"%>
<%@page import="control.OrdenCliente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="control.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Historial de Órdenes</title>
    </head>
    <body>

        <a href="../index.html">Inicio</a>        
        <h1>Consulta Órdenes</h1>
        <%
            String cliente = request.getParameter("cliente");
            Persona p = new Persona();
            p.conecta();
            p.setPersona(cliente);
            p.desconecta();
            int idCliente = p.getId();

            out.write(p.getApp() + " " + p.getNombre() + "<br><br>");

            OrdenCliente oc = new OrdenCliente();
            ArrayList aoc = new ArrayList();
            oc.conecta();
            aoc = oc.getOrdenCliente(idCliente);
            oc.desconecta();

            if (aoc.size() > 0) {
                for (int i = 0; i < aoc.size(); i++) {
                    int id = ((OrdenCliente) aoc.get(i)).getIdOrden();
                    float total = ((OrdenCliente) aoc.get(i)).getTotal();
                    String dom = ((OrdenCliente) aoc.get(i)).getADomicilio();
                    if (dom.equals("1")) {
                        dom = "Sí";
                    } else {
                        dom = "No";
                    }

                    out.write("Id Orden: " + id + "| Total: $" + total
                            + "| Domicilio: " + dom + "<br>");

                    ProductosOrden po = new ProductosOrden();
                    ArrayList apo = new ArrayList();
                    po.conecta();
                    apo = po.getProductosOrden(id);
                    po.desconecta();
                    if (apo.size() > 0) {
                        for (int j = 0; j < apo.size(); j++) {
                            String producto
                                    = ((ProductosOrden) apo.get(j)).getProducto();
                            float precio = ((ProductosOrden) apo.get(j)).getPrecio();
                            int cantidad = ((ProductosOrden) apo.get(j)).getCantidad();

                            out.write("Producto: " + producto + "| Precio: $"
                                    + precio + "| Cantidad: " + cantidad
                                    + "| Subtotal: $" + (cantidad * precio) + "<br>");
                        }
                        out.write("<br>");
                    }
                }
            } else {
                out.write("No hay personas registradas");
            }
        %>
    </body>
</html>
