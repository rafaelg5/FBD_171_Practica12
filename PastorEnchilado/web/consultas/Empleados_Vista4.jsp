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
        <h1>Empleados_Vista4</h1>
        <%
            EmpleadoDetalle  e = new EmpleadoDetalle();
            ArrayList listaEmpleados = new ArrayList();

            e.conecta();
            listaEmpleados = e.getListaEmpleados();
            e.desconecta();

            if (listaEmpleados.size() > 0) {
                for (int i = 0; i < listaEmpleados.size(); i++) {
                    String nombre = ((EmpleadoDetalle) listaEmpleados.get(i)).getNombre();
                    String aPP = ((EmpleadoDetalle) listaEmpleados.get(i)).getaP();
                    String aPM = ((EmpleadoDetalle) listaEmpleados.get(i)).getaM();
                    String fNac = ((EmpleadoDetalle) listaEmpleados.get(i)).getfNacimiento();
                    String correo = ((EmpleadoDetalle) listaEmpleados.get(i)).getCorreo();
                    String fCont = ((EmpleadoDetalle) listaEmpleados.get(i)).getfContratacion();
                    String rFC = ((EmpleadoDetalle) listaEmpleados.get(i)).getRFC();
                    int activo = ((EmpleadoDetalle) listaEmpleados.get(i)).getActivo();
                    String sucursal = ((EmpleadoDetalle) listaEmpleados.get(i)).getSucursal();
                    String tipoEmpleado = ((EmpleadoDetalle) listaEmpleados.get(i)).getTipoEmpleado();
                    out.write(i + 1 + " | " + nombre + " " + aPP + " " + aPM + " " + fNac + " " + correo + " " + fCont + " " + rFC + " " + activo + " " + sucursal + " " + tipoEmpleado + "<br>");
                }
            } else {
                out.write("No hay personas registradas");
            }
        %>
    </body>
</html>