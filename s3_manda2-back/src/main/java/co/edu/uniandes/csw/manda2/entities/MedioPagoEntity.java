/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author m.moreno
 */
@Entity
public class MedioPagoEntity extends BaseEntity implements Serializable{
 
     /**
     * Indica el id de medio pago.
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
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
    
     /**
     * Retorna el id del medio de pago.
     * @return id de medio de pago.
     */
    @Override
     public Long getId()
    {
        return id;
    }
    /**
     * Establece el nombre del cliente.
     * @param id id
     */
    @Override
    public void setId(Long id){
        this.id = id;
    }
}
