package control;

import java.sql.SQLException;

public class RegistroProveedor extends Control {

    public boolean registrarProveedor(String nombre, String rfc, String sucursal,
            String fecha, double costo, String cantidad, String calle,
            String colonia, String cp, String obs, String municipio, String estado) {
        boolean b = conexionBD.registrarProveedor(nombre, rfc, sucursal, fecha, costo,
                cantidad, calle, colonia, cp, obs, municipio, estado);
        return b;
    }
}
