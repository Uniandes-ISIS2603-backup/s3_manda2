/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
     * Lista de PayPals de la billetera.
     */
    @PodamExclude
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(nullable = true)
    private List<PayPalEntity> payPals;

    /**
     * Lista de PSEs de la billetera.
     */
    @PodamExclude
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(nullable = true)
    private List<PSEEntity> pses;

    /**
     * Lista de tarjetas de crédito de la billetera.
     */
    @PodamExclude
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(nullable = true)
    private List<TarjetaCreditoEntity> tarjetasDeCredito;


    /**
     * Retorna el saldo en la billetera.
     *
     * @return saldo en la billetera.
     */
    public Double getSaldo() {
        return saldo;
    }

    /**
     * Establece el saldo en la billetera.
     *
     * @param pSaldo .
     */
    public void setSaldo(double pSaldo) {
        this.saldo = pSaldo;
    }

    /**
     * Retorna los puntos de fidelidad.
     *
     * @return puntos de fidelidad.
     */
    public Integer getPuntosFidelidad() {
        return puntosDeFidelidad;
    }

    /**
     * Establece los puntos de fidelidad.
     *
     * @param pPuntos puntos de fidelidad.
     */
    public void setPuntosFidelidad(Integer pPuntos) {
        this.puntosDeFidelidad = pPuntos;
    }

    /**
     * Retorna los paypals asociados a la billetera.
     *
     * @return paypals asociados a la billetera.
     */
    public List<PayPalEntity> getPayPals() {
        return payPals;
    }

    /**
     * Asigna los paypals al valor dado por parámetro.
     *
     * @param payPals lista de paypals
     */
    public void setPayPals(List<PayPalEntity> payPals) {
        this.payPals = payPals;
    }

    /**
     * Retorna los pses asociados a la billetera.
     *
     * @return pses asociados a la billetera.
     */
    public List<PSEEntity> getPses() {
        return pses;
    }

    /**
     * Asigna los pses al valor dado por parámetro.
     *
     * @param pses lista de pses
     */
    public void setPses(List<PSEEntity> pses) {
        this.pses = pses;
    }

    /**
     * Retorna las tarjetas de crédito asociados a la billetera.
     *
     * @return paypals asociados a la billetera.
     */
    public List<TarjetaCreditoEntity> getTarjetasDeCredito() {
        return tarjetasDeCredito;
    }

    /**
     * Asigna las tarjetas de crédito al valor dado por parámetro.
     *
     * @param tarjetasDeCredito lista de tarjetas de crédito
     */
    public void setTarjetasDeCredito(List<TarjetaCreditoEntity> tarjetasDeCredito) {
        this.tarjetasDeCredito = tarjetasDeCredito;
    }

}
