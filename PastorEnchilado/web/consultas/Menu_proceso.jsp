<%@page import="java.util.ArrayList"%>
<%@page import="control.menuSucursal"%>
<%
    String nombreSucursal = request.getParameter("nombreSucursal");

    menuSucursal ms = new menuSucursal();
    ArrayList ams = new ArrayList();

    out.write("Sucursal: " + nombreSucursal + "<br><br>Men�:<br><br>");

    ms.conecta();
    ams = ms.menu(nombreSucursal);
    ms.desconecta();

    if (ams.size() > 0) {
        for (int i = 0; i < ams.size(); i++) {
            String producto = ((menuSucursal) ams.get(i)).getProducto();
            float precio = ((menuSucursal) ams.get(i)).getPrecio();

            out.write(producto + " .......................... $" + precio
                    + "<br>");

        }
    } else {
        out.write("No hay sucursales registradas o men�s disponibles");
    }

%>

<p><a href="Menu.jsp">Consultar otro men�</a></p>
<p><a href="../index.html">Inicio</a></p>
