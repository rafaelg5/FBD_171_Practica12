<%@page import="control.RegistroProveedor"%>
<%
        String nombreP = request.getParameter("nombreP");
        String rfcP = request.getParameter("rfcP");
        String sucP = request.getParameter("sucuP");
        String fechP = request.getParameter("fechP");
        double costoP = Double.parseDouble(request.getParameter("costoP"));
        String cantidP = request.getParameter("cantidP");
        String calleP = request.getParameter("calleP");
        String coloniaP = request.getParameter("coloniaP");
        String cpP = request.getParameter("cpP");
        String obsP = request.getParameter("obsP");
        String munP = request.getParameter("munP");
        String estadP = request.getParameter("estadP");

        RegistroProveedor rp = new RegistroProveedor();

        rp.conecta();
        boolean b = rp.registrarProveedor(nombreP, rfcP, sucP, fechP, costoP,
                cantidP, calleP, coloniaP, cpP, obsP, munP, estadP);
        rp.desconecta();

        if (b) {
            out.write("Registro exitoso");
        } else {
            out.write("No se pudo completar el registro");
        }
%>

<p><a href="../index.html">Inicio</a></p>
