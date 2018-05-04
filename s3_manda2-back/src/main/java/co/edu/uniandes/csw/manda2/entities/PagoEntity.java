/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.entities;

import co.edu.uniandes.csw.manda2.podam.DateStrategy;
import com.fasterxml.jackson.annotation.JsonIgnore;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author m.moreno
 */
@Entity
public class PagoEntity extends BaseEntity implements Serializable {

    /**
     * Indica el estado en el que se encuentra la transaccion.
     */
    private String estadoTransaccion;

    /**
     * Fecha en que se realiza el pago.
     */
    @Temporal(TemporalType.DATE)
    @PodamStrategyValue(DateStrategy.class)
    private Date fecha;

    /**
     * PayPal asociado al pago.
     */
    @PodamExclude
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = false)
    @JoinColumn(nullable = true)
    private PayPalEntity payPal;

    /**
     * PSE asociado al pago.
     */
    @PodamExclude
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = false)
    @JoinColumn(nullable = true)
    private PSEEntity pse;

    /**
     * Tarjeta de crédito asociada al pago.
     */
    @PodamExclude
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = false)
    @JoinColumn(nullable = true)
    private TarjetaCreditoEntity tarjetaDeCredito;

    /**
     * Atributo que modela el empleado conoce el pago
     *
     */
    @PodamExclude
    @ManyToOne
    private EmpleadoEntity empleado;

    /**
     * Atributo que modela el empleado conoce el pago
     *
     */
    @JsonIgnore
    @PodamExclude
    @OneToOne(mappedBy = "pago", fetch = FetchType.LAZY)
    private ServicioEntity servicio;
    /**
     * Atributo que modela el empleado conoce el pago
     *
     */
    @PodamExclude
    @ManyToOne
    private ClienteEntity cliente;

    /**
     * Retorna el estado de transaccion.
     *
     * @return estado de la transaccion.
     */
    public String getEstadoTransaccion() {
        return estadoTransaccion;
    }

    /**
     * Retorna la fecha del pago.
     *
     * @return fecha del pago.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Establece el estado de la transaccion.
     *
     * @param estado Nuevo estado de pago.
     */
    public void setEstadoTransaccion(String estado) {
        this.estadoTransaccion = estado;
    }

    /**
     * Establece la fecha dada.
     *
     * @param pFecha fecha de el pago.
     */
    public void setFecha(Date pFecha) {
        this.fecha = pFecha;
    }

    /**
     * @return the Cliente
     */
    public ClienteEntity getCliente() {
        return cliente;
    }

    /**
     * @param Cliente the cliente to set
     */
    public void setCliente(ClienteEntity Cliente) {
        this.cliente = Cliente;
    }

    /**
     * @return the Servicio
     */
    public ServicioEntity getServicio() {
        return servicio;
    }

    /**
     * @param servicio Servicio
     */
    public void setServicio(ServicioEntity servicio) {
        this.servicio = servicio;
    }

    /**
     * Retorna el empleado que recibe el pago.
     * @return empleado.
     */
    public EmpleadoEntity getEmpleado() {
        return empleado;
    }

    /**
     * Asigna el empleado
     * @param empleado 
     */
    public void setEmpleado(EmpleadoEntity empleado) {
        this.empleado = empleado;
    }

    /**
     * Retorna el PayPal
     * @return paypal
     */
    public PayPalEntity getPayPal() {
        return payPal;
    }

    /**
     * Asigna el PayPal al valor dado por parámetro.
     * @param payPal paypal
     */
    public void setPayPal(PayPalEntity payPal) {
        this.payPal = payPal;
    }

    /**
     * Retorna el pse
     * @return pse
     */
    public PSEEntity getPse() {
        return pse;
    }

    /**
     * Asigna el pse al valor dado por parámetro.
     * @param pse pse
     */
    public void setPse(PSEEntity pse) {
        this.pse = pse;
    }

    /**
     * Retorna la tarjeta de crédito.
     * @return tarjeta de crédito.
     */
    public TarjetaCreditoEntity getTarjetaDeCredito() {
        return tarjetaDeCredito;
    }

    /**
     * Asigna la tarjeta de crédito al valor dado por parámetro.
     * @param tarjetaDeCredito tarjeta de crédito.
     */
    public void setTarjetaDeCredito(TarjetaCreditoEntity tarjetaDeCredito) {
        this.tarjetaDeCredito = tarjetaDeCredito;
    }
}
