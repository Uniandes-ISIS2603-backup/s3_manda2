/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author dv.gonzalez10
 */
@Entity
public class VueltasConDemoraEnOficinaEntity extends ServicioEntity  implements Serializable {
     
    
     /*
        *El monto maximo que se puede entregar en efectivo para una vuelta 
        */
        public static final Double   MONTO_MAXIMO = 1000000.0;
        /*
        *El costo de la duracion del servicio en oficina
        */
        private Double costoDuracion;
        /*
        *El costo del transporte del servicio
        */
        private Double costoDeTransporte;
    @OneToOne
    @PodamExclude
    private PagoEntity pago;
        /**
     * Retorna el pago asociado al servicio.
     * @return pago asociado al servicio.
     */
    public PagoEntity getPago() {
        return pago;
    }

    /**
     * Asigna el pago al dado por parámetro
     * @param pago nuevo pago
     */
    public void setPago(PagoEntity pago) {
        this.pago = pago;
    }
    /**
     *Retorna el valor asociado a la duración del servicio
     * @return costoDeTransporte
     */    
    public Double getCostoDuracion() {
        return costoDuracion;
    }
    /**
     * Asigna el costo de duración.
     * @param costoDuracion costoDuracion
     */
    public void setCostoDuracion(Double costoDuracion) {
        this.costoDuracion = costoDuracion;
    }

     /**
     *Retorna el valor asociado al transporte del servicio
     * @return costoDeTransporte
     */
    public Double getCostoDeTransporte() {
        return costoDeTransporte;
    }

    /**
     * Asigna el valor del costo del transporte
     *  @param costoDeTransporte el costo del transporte
     */
    public void setCostoDeTransporte(Double costoDeTransporte) {
        this.costoDeTransporte = costoDeTransporte;
    }
        
        
        
    
}
