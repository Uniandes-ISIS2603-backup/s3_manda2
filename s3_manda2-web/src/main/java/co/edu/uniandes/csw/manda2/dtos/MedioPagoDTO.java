/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

/**
 *
 * @author m.moreno
 */
public class MedioPagoDTO {
    
    
    /**
     * Indica el id de medio pago.
     */
    private long id;
    /**
     * Indica el nombre del cliente que realiza pago.
     */
    private String nombreCliente;
    
    /**
     * Retorna el nombre el cliente.
     * @return nombre cliente
     */
    public String getNombreCliente()
    {
        return nombreCliente;
    }
    /**
     * Establece el nombre del cliente.
     * @param pNombre.
     */
    public void setNombreCliente(String pNombre){
        this.nombreCliente = pNombre;
    }
     public long getId()
    {
        return id;
    }
    /**
     * Establece el nombre del cliente.
     * @param pNombre.
     */
    public void setId(long id){
        this.id = id;
    }
}
