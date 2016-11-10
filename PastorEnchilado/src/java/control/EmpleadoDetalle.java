/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jorge
 */
public class EmpleadoDetalle extends Control{
    
    String nombre;
    String aP;
    String aM;
    String fNacimiento;
    String correo;
    String fContratacion;
    String RFC;
    int activo;
    String sucursal;
    String tipoEmpleado;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getaP() {
        return aP;
    }

    public void setaP(String aP) {
        this.aP = aP;
    }

    public String getaM() {
        return aM;
    }

    public void setaM(String aM) {
        this.aM = aM;
    }

    public String getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(String fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getfContratacion() {
        return fContratacion;
    }

    public void setfContratacion(String fContratacion) {
        this.fContratacion = fContratacion;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }
    
    public ArrayList getListaEmpleados() throws Exception{
        ArrayList lEmpleados = new ArrayList();
        try{
            lEmpleados = conexionBD.todosLosEmpleados();
        }catch(Exception ex){
            System.out.println("No se pudieron recuperar las personas " + ex.getMessage());
        }
        return lEmpleados;
    }
    
    /*public boolean todosLosEmpleados () throws SQLException{
        String s = "SELECT Persona.sNombre AS nombre, sApp, sApm, dFechaNacimiento, sCorreo, dFechaContratacion, sRFC, Empleado.bActivo AS Activo, Sucursal.sNombre AS Sucursal, sTipoEmpleado "
                + "FROM Empleado JOIN Persona ON Empleado.nIdPersona=Persona.nIdPersona "
                + "JOIN CTipo_Empleado ON Empleado.nIdTipoempleado=CTipo_Empleado.nIdTipoEmpleado "
                + "JOIN Sucursal ON Empleado.nIdSucursal=Sucursal.nIdSucursal "
                + "ORDER BY sTipoEmpleado;";
        boolean b = false;
        try {
            stmt.executeQuery(s);
            b = true;
            stmt.close();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return b;
    }*/
    
}