package control;

import java.util.ArrayList;

public class ProductosOrden extends Control {

    private String producto;
    private float precio;
    private int cantidad;

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

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public ArrayList getProductosOrden(int id) {
        ArrayList po = new ArrayList<>();
        try {
            po = conexionBD.productoOrden(id);
        } catch (Exception ex) {
            System.out.println("No se pudo recuperar la orden" + ex.getMessage());
        }
        return po;
    }

}
