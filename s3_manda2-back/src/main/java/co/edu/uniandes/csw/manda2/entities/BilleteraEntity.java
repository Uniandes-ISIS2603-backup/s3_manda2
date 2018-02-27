/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author m.moreno
 */
@Entity
public class BilleteraEntity extends BaseEntity implements Serializable {
    
     /**
     * Indica el saldo disponible en la billetera.
     */
    private Double saldo;
    /**
     * Indica los puntos de fidelidad acumulados.
     */
    private Integer puntosDeFidelidad;
    
     /**
     *  Atributo que modela el medio de pago de la billetera
     * 
     */
      //@OneToOne
    @PodamExclude
    private MedioPagoEntity medioPago;
    
    /**
     * Retorna el saldo en la billetera.
     * @return saldo en la billetera.
     */
    
    public Double getSaldo(){
        return saldo;
    }
    /**
     * Establece el saldo en la billetera.
     * @param pSaldo.
     */
    public void setSaldo(double pSaldo){
        this.saldo = pSaldo;
    }
    /**
     * Retorna los puntos de fidelidad.
     * @return puntos de fidelidad.
     */
    public Integer getPuntosFidelidad(){
        return puntosDeFidelidad;
    }
    /**
     * Establece los puntos de fidelidad.
     * @param pPuntos puntos de fidelidad.
     */
    public void setPuntosFidelidad(Integer pPuntos){
        this.puntosDeFidelidad= puntosDeFidelidad + pPuntos;
    }
    
    /**
     * @return the medio pago
     */
    public MedioPagoEntity getMedioPago() {
        return medioPago;
    }

    /**
     * @param medio the medioPago to set
     */
    public void setMedioPago(MedioPagoEntity medio) {
        this.medioPago =medio;
    }
}
