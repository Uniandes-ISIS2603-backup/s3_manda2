/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author dv.gonzalez10
 */
@Entity
public class EntregasDeDocumentosEntity  extends ServicioEntity  implements Serializable { 
    
    /*
    *El costo de transporte del servicio
    */
    private Double costoDeTransporte;
    /*
    *El porcentaje que se cobra extra por el servicio 
    */
    private Double porcentajeExtra;

    @OneToOne
    @PodamExclude
    private PagoEntity pago;
    
     /**
     *Retorna el valor asociado al transporte del servicio
     * @return costoDeTransporte
     */
    public Double getCostoDeTransporte() {
        return costoDeTransporte;
    }

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
     * Asigna el valor del costo del transporte
     *  @param costoDeTransporte el valor del transporte.
     */
    public void setCostoDeTransporte(Double costoDeTransporte) {
        this.costoDeTransporte = costoDeTransporte;
    }

    /**
     *Retorna el valor del costo extra que se adiciona por el servicio
     * @return porcentajeExtra el porcentaje extra
     */
    public Double getPorcentajeExtra() {
        return porcentajeExtra;
    }

     /**
     * Asigna el valor del costo extra que se adiciona por el servicio.
     *  @param porcentajeExtra el porcentaje extra.
     */ 
    public void setPorcentajeExtra(Double porcentajeExtra) {
        this.porcentajeExtra = porcentajeExtra;
    }
    
    
}
