package control;

import java.util.ArrayList;

public class Persona extends Control {

    int id;
    String app;
    String nombre;
    String fecha_nac;
    private String correo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public int newPersona(String app, String apm, String nombre, String fechaNacimiento, String correo) throws Exception {
        int b = 0;
        try {
            b = conexionBD.setPersona(app, apm, nombre, fechaNacimiento, correo);
        } catch (Exception ex) {
            System.out.println("No se pudo registrar la persona " + ex.getMessage());
        }
        return b;
    }

    public int getIdRecienAgregado() {
        int ultimo = 0;
        try {
            ultimo = conexionBD.getUltimoIdPersona();
        } catch (Exception ex) {
            System.out.println("No se pudieron recuperar las personas " + ex.getMessage());
        }
        return ultimo;
    }

    public ArrayList getPersonas() throws Exception {
        ArrayList personas = new ArrayList();
        try {
            personas = conexionBD.getPersonas();
        } catch (Exception ex) {
            System.out.println("No se pudieron recuperar las personas "
                    + ex.getMessage());
        }
        return personas;
    }

    public void setPersona(String monedero) {

        try {
            Persona p = conexionBD.setPersona(monedero);
            if (p == null) {
                System.out.println("No se pudo encontrar a la persona");
            }
            this.id = p.id;
            this.nombre = p.nombre;
            this.app = p.app;
        } catch (Exception ex) {
            System.out.println("No se pudo encontrar la persona "
                    + ex.getMessage());
        }
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
