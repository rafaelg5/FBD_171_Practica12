package control;

import datos.Conexion;

public class Control {

    Conexion conexionBD = new Conexion();

    public void conecta() throws Exception {
        try {
            conexionBD.conectar();
        } catch (Exception e) {
            System.out.println("Conexión fallida" + e.getMessage());
        }
    }

    public void desconecta() throws Exception {
        try {
            conexionBD.desconectar();
        } catch (Exception e) {
            System.out.println("Desconexión fallida" + e.getMessage());
        }
    }

}
