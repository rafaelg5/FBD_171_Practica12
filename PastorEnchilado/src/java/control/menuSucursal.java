package control;

import java.util.ArrayList;

public class menuSucursal extends Control {

    private String producto;
    private float precio;

    public ArrayList menu(String nombreSucursal) {
        ArrayList ms = new ArrayList<>();
        try {
            ms = conexionBD.sucursalMenu(nombreSucursal);
        } catch (Exception ex) {
            System.out.println("No se pudo recuperar el menu" + ex.getMessage());
        }
        return ms;
    }

    /**
     * @return the producto
     */
    public String getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(String producto) {
        this.producto = producto;
    }

    /**
     * @return the precio
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
