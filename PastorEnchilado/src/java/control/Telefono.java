package control;

public class Telefono extends Control {

    public boolean deleteTelefono(String telefono) {
        boolean b = false;
        try {
            b = conexionBD.deleteTelefono(telefono);
        } catch (Exception ex) {
            System.out.println("No se pudo actualizar el precio "
                    + ex.getMessage());
        }
        return b;
    }
}
