package control;

import java.util.ArrayList;

public class OrdenCliente extends Control {

    private int idOrden;
    private float total;
    private String aDomicilio;
    
    public void setIdOrden(int idOrden){
        this.idOrden = idOrden;
    }
    
    public void setTotal(float total){
        this.total = total;
    }
    
    public void setADomicilio(String aDomicilio){
        this.aDomicilio = aDomicilio;
    }
    
    public int getIdOrden(){
        return idOrden;
    }
    
    public float getTotal(){
        return total;
    }
    
    public String getADomicilio(){
        return aDomicilio;
    }
    
    public ArrayList getOrdenCliente(int id) {
        ArrayList oc = new ArrayList<>();
        try {
            oc = conexionBD.getOrdenCliente(id);
        } catch (Exception ex) {
            System.out.println("No se pudo recuperar la orden" + ex.getMessage());
        }
        return oc;
    }
}
