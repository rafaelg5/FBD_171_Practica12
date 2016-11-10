/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;

/**
 *
 * @author erick
 */
public class Cliente extends Control{

    int id;
    String monedero;
    double saldo;
    String fecha_reg;
    int idPersona;

    public int getId() {
        return id;
    }

    public String getMonedero() {
        return monedero;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getFecha_reg() {
        return fecha_reg;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMonedero(String monedero) {
        this.monedero = monedero;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setFecha_reg(String fecha_reg) {
        this.fecha_reg = fecha_reg;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }
    
    public int newCliente(String monedero, double saldo, String fechaRegistro, int idPersona) throws Exception{
        int b = 0;
        try{
            b = conexionBD.setCliente(monedero,saldo,fechaRegistro, idPersona);
        }catch(Exception ex){
            System.out.println("No se pudo registrar el Estado " + ex.getMessage());
        }
        return b;
    }
    
    public ArrayList getClientes() throws Exception{
        ArrayList clientes = new ArrayList();
        try{
            clientes = conexionBD.getClientes();
        }catch(Exception ex){
            System.out.println("No se pudieron recuperar las personas " + ex.getMessage());
        }
        return clientes;
    }
}
