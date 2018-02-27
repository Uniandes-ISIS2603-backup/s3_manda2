/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.entities;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author m.moreno
 */

@Entity
public class PagoEntity extends BaseEntity implements Serializable {
    
 /**
     * Id del pago
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

  /**
     * Indica el estado en el que se encuentra la transaccion
     */
    private String estadoTransaccion;
    
     /**
     * Fecha en que se realiza el pago
     */
    private Date fecha; 
    
  /**
     * Retorna el id del pago.
     * @return id de pago.
     */
    public Long getId(){
        return id;
    }
    
    /**
     * Retorna el estado de transaccion.
     * @return estado de la transaccion.
     */
    public String getEstadoTransaccion(){
        return estadoTransaccion;
    }
    /**
     * Retorna la fecha del pago.
     * @return fecha del pago.
     */
    public Date getFecha(){
        return fecha;
    }
     /**
     * Establece el id del pago.
     * @param id del pago.
     */
    public void setId(Long id){
        this.id = id;
    }
     /**
     * Establece el  estado de la transaccion.
     * @param estado Nuevo estado de pago.
     */
    public void setEstadoTransaccion(String estado)
    {
        this.estadoTransaccion = estado;
    }
    /**
     * Establece la fecha dada.
     * @param pFecha fecha de el pago.
     */
    public void setFecha (Date pFecha){
        this.fecha = pFecha;
    }
}