/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;
import java.util.Date;

/**
 * Clase que extiende de {@link PagoDTO} para manejar la transformacion entre
 * los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido de la ciudad vaya a la documentacion de {@link PagoDTO}
 * @author m.moreno
 */
public class PagoDetailDTO extends PagoDTO {
    
    /**
     * Servicio por el que se realiza el pago
     */
    private ServicioDTO servicio;
    
     /**
     * Medio de pago para realizar la transaccion
     */
    private MedioPagoDTO medioPago;
    
     /**
     * Constructor de un nuevo Pago.
     * @param servicio servicio asociado al pago
     *  @param medio Medio de pago para realizar la transaccion
     *  @param id id del pago
     *  @param estado estado en que se encuentra el pago
     * @param fecha fecha de pago
     */
    public PagoDetailDTO (ServicioDTO servicio, MedioPagoDTO medio, Long id, String estado, Date fecha){
        super(id, estado, fecha);
        this.medioPago = medio;
        this.servicio = servicio;
    }
    public PagoDetailDTO()
    {
        
    }
    /**
     * Retorna el servicio relacionado al pago.
     * @return servicio relacionado al pago.
     */
    public ServicioDTO getServicio(){
        return servicio;
    }
    /**
     * Asigna el servicio por el que se realiza pago.
     * @param pServicio servicio por el que se realiza pago.
     */ 
    public void setServicio(ServicioDTO pServicio){
        this.servicio = pServicio;
    }
    
    /**
     * Retorna el medio de pago con el que se realiza el pago.
     * @return Medio de pago con el que se realiza el pago.
     */
    public MedioPagoDTO getMedioPago(){
        return medioPago;
    }
    /**
     * Asigna el medio de pago con el que se realiza la transaccion.
     * @param pMedioPago con el que se realiza el pago.
     */
    public void setMedioPago(MedioPagoDTO pMedioPago){
        this.medioPago = pMedioPago;
    }
    
}
