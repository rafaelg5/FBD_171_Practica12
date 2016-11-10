<%-- 
    Document   : alta_estado_proceso
    Created on : 29-oct-2016, 1:30:29
    Author     : erick
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="control.Persona"%>
<%@page import="control.Cliente"%>
<%--<%@page import="control.Persona_Telefono"%>
<%@page import="control.Telefono"%>
<%@page import="control.CTipoTelefono"%>--%>
<%
    String nombre = request.getParameter("nombre");
    String apellidoPaterno = request.getParameter("app");
    String apellidoMaterno = request.getParameter("apm");
    String fechaNacimiento = request.getParameter("fecha_nacimiento");
    String correo = request.getParameter("correo");
    String monedero = request.getParameter("monedero");
    double saldo  = Double.parseDouble(request.getParameter("saldo"));
    String fechaRegistro = request.getParameter("fecha_registro");
    String telefono = request.getParameter("telefono");

    Persona p = new Persona();
    Cliente c = new Cliente();

    int b = 0;
    int a = 0;
    int x;
    

    p.conecta();
    b = p.newPersona(apellidoPaterno,apellidoMaterno,nombre,fechaNacimiento,correo);
    x = p.getIdRecienAgregado();
    p.desconecta();
    
    c.conecta();
    b = c.newCliente(monedero, saldo, fechaRegistro, x);
    c.desconecta();
    %>
    <a href="../index.html">Inicio</a>
    <%
    
    if(b == 1){
        out.write("Cliente Registrado");
    }else{
        out.write("No se Registró el Cliente");
    }
%>