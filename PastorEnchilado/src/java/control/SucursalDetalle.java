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
public class SucursalDetalle extends Control{
    
    int idSucursal;
    String nombre;
    int aDomicilio;
    int activo;
    String calle;
    String colonia;
    String cP;
    String observaciones;
    String municipio;
    String estado;
    String telefono;
    String tipoSucursal;

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getaDomicilio() {
        return aDomicilio;
    }

    public void setaDomicilio(int aDomicilio) {
        this.aDomicilio = aDomicilio;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int antivo) {
        this.activo = antivo;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getcP() {
        return cP;
    }

    public void setcP(String cP) {
        this.cP = cP;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipoSucursal() {
        return tipoSucursal;
    }

    public void setTipoSucursal(String tipoSucursal) {
        this.tipoSucursal = tipoSucursal;
    }

    
    
    public ArrayList getListaSucursales() throws Exception{
        ArrayList lSucursales = new ArrayList();
        try{
            lSucursales = conexionBD.sucursalesDetalle();
        }catch(Exception ex){
            System.out.println("No se pudieron recuperar las sucursales " + ex.getMessage());
        }
        return lSucursales;
    }
    
    
}