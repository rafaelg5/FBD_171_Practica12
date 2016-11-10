package control;

public class Estado extends Control {

    public int setEstado(String estado) throws Exception {
        int b = 0;
        try {
            b = conexionBD.setEstado(estado);
        } catch (Exception ex) {
            System.out.println("No se pudo registrar el Estado " + ex.getMessage());
        }
        return b;
    }
}
