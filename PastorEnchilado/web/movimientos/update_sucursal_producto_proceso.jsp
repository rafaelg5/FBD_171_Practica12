<%@page import="control.SucursalProducto"%>
<%
    String sucursal = request.getParameter("sucursal");
    String producto = request.getParameter("producto");
    float precio = Float.parseFloat(request.getParameter("precio"));
    

    SucursalProducto sp = new SucursalProducto();

    boolean b = false;

    sp.conecta();
    b = sp.updatePrecio(sucursal, producto, precio);
    sp.desconecta();
        
    if(b){
        out.write("Actualización exitosa");
    }else{
        out.write("Actualización fallida");
    }
%>

<p><a href="update_sucursal_producto.jsp">Seguir actualizando</a></p>
<p><a href="../index.html">Inicio</a></p>
