/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;
import java.util.Date;

/**
 *
 * @author mariana
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
    public PagoDetailDTO (ServicioDTO servicio, MedioPagoDTO medio, long id, String estado, Date fecha){
        super(id, estado, fecha);
        this.medioPago = medio;
        this.servicio = servicio;
    }
    /**
     * Retorna el servicio relacionado al pago.
     * @return servicio.
     */
    public ServicioDTO getServicio(){
        return servicio;
    }
    /**
     * Asigna el servicio por el que se realiza pago.
     * @param pServicio servicio.
     */
    public void setServicio(ServicioDTO pServicio){
        this.servicio = pServicio;
    }
    
    /**
     * Retorna el medio de pago.
     * @return Medio de pago.
     */
    public MedioPagoDTO getMedioPago(){
        return medioPago;
    }
    /**
     * Asigna el medio de pago con el que se realizara la transaccion.
     * @param pMedioPago.
     */
    public void setMedioPago(MedioPagoDTO pMedioPago){
        this.medioPago = pMedioPago;
    }
    
}
