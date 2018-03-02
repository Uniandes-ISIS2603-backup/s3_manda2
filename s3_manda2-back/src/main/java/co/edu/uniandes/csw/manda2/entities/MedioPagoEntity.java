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
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author m.moreno
 */
@Entity
public class MedioPagoEntity extends BaseEntityAlternativo  implements Serializable{
 
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
     *  Atributo que modela el medio de pago
     * 
     */
     //@PodamExclude
    //@OneToOne
   
    //private PagoEntity pago;
    
    /**
     *  Atributo que modela la billetera relacionada al pago
     * 
     */
      //@PodamExclude
    //@OneToOne
    
    //private BilleteraEntity billetera;
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
     public Long getId()
    {
        return id;
    }
    /**
     * Establece el nombre del cliente.
     * @param id id
     */
    public void setId(Long id){
        this.id = id;
    }
}
