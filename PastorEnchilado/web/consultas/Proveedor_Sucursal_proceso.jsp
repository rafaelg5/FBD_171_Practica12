<%@page import="java.util.ArrayList"%>
<%@page import="control.proveedorSucursal"%>
<%
    String nombreSucursal = request.getParameter("nombreSucursal");

    proveedorSucursal ps = new proveedorSucursal();
    ArrayList aps = new ArrayList();

    ps.conecta();
    aps = ps.proveedorSuc(nombreSucursal);
    ps.desconecta();

    out.write("Proveedores: <br><br>");
    if (aps.size() > 0) {
        for (int i = 0; i < aps.size(); i++) {
            String proveedor = (String) aps.get(i);
            out.write(" - " + proveedor + "<br>");

        }
    } else {
        out.write("No hay sucursales registradas o proveedores");
    }
%>

<p><a href="Proveedor_Sucursal.jsp"></a></p>
<p><a href="../index.html">Inicio</a></p>
