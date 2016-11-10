package control;

public class SucursalProducto extends Control {

    public boolean updatePrecio(String sucursal, String producto, float precio) {
        boolean b = false;
        try {
            b = conexionBD.updateProductoSucursal(sucursal, producto, precio);
        } catch (Exception ex) {
            System.out.println("No se pudo actualizar el precio "
                    + ex.getMessage());
        }
        return b;
    }
}
