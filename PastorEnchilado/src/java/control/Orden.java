package control;

public class Orden extends Control {

    public boolean setOrden(String cliente, String mesero, String sucursal,
            String producto1, int cantidad1, String producto2, int cantidad2,
            String producto3, int cantidad3, String fecha, int bDomicilio)
            throws Exception {
        boolean b = false;
        try {
            b = conexionBD.setOrden(cliente, mesero, sucursal, producto1,
                    cantidad1, producto2, cantidad2, producto3, cantidad3,
                    fecha, bDomicilio);
        } catch (Exception ex) {
            System.out.println("No se pudo registrar la Orden " + ex.getMessage());
        }
        return b;
    }
}
