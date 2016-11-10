package control;

import java.util.ArrayList;

public class proveedorSucursal extends Control {

    public ArrayList proveedorSuc(String nombreSucursal) {
        ArrayList<String> proveedores = new ArrayList<>();
        try {
            proveedores = conexionBD.proveedorSucursal(nombreSucursal);
        } catch (Exception ex) {
            System.out.println("No se pudieron encontrar los proveedores de "
                    + "esa sucursal " + ex.getMessage());
        }
        return proveedores;
    }
}
