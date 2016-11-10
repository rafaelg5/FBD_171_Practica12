<%-- 
    Document   : consulta_personas
    Created on : 29-oct-2016, 0:52:34
    Author     : erick
--%>

<%@page import="control.SucursalDetalle"%>
<%@page import="java.util.ArrayList"%>
<%@page import="control.EmpleadoDetalle"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <a href="../index.html">Inicio</a>        
        <h1>Sucursales_Vista5</h1>
        <%
            SucursalDetalle suc = new SucursalDetalle();
            ArrayList listaSucursales = new ArrayList();

            suc.conecta();
            listaSucursales = suc.getListaSucursales();
            suc.desconecta();

            if (listaSucursales.size() > 0) {
                for (int i = 0; i < listaSucursales.size(); i++) {
                    int id = ((SucursalDetalle) listaSucursales.get(i)).getIdSucursal();
                    String nombre = ((SucursalDetalle) listaSucursales.get(i)).getNombre();
                    int aDomicilio = ((SucursalDetalle) listaSucursales.get(i)).getaDomicilio();
                    int activo = ((SucursalDetalle) listaSucursales.get(i)).getActivo();
                    String calle = ((SucursalDetalle) listaSucursales.get(i)).getCalle();
                    String colonia = ((SucursalDetalle) listaSucursales.get(i)).getColonia();
                    String cP = ((SucursalDetalle) listaSucursales.get(i)).getcP();
                    String observaciones = ((SucursalDetalle) listaSucursales.get(i)).getObservaciones();
                    String municipio = ((SucursalDetalle) listaSucursales.get(i)).getMunicipio();
                    String estado = ((SucursalDetalle) listaSucursales.get(i)).getEstado();
                    String telefono = ((SucursalDetalle) listaSucursales.get(i)).getTelefono();
                    String tipoSucursal = ((SucursalDetalle) listaSucursales.get(i)).getTipoSucursal();
                    out.write(i + 1 + " | " + id + " " + nombre + " " + aDomicilio + " " + activo + " " + calle + " " + colonia + " " + cP + " " + observaciones + " " + municipio + " " + estado + " " + telefono + " " + tipoSucursal + "<br>");
                }
            } else {
                out.write("No hay sucursales registradas");
            }
        %>
    </body>
</html>