/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

/**
 * Clase que representa el medio de pago de PayPal.
 * @author da.ramos
 */
public class PayPalDTO extends MedioPagoDTO{
    
    /**
     * Id del objeto
     */
    private long id;
    
    /**
     * Link de PayPal.
     */
    private String linkPayPal;

    /**
     * Retorna el link de PayPal.
     * @return Link de PayPal.
     */
    public String getLinkPayPal() {
        return linkPayPal;
    }

    /**
     * Asigna el link de PayPal al dado por parámetro.
     * @param linkPayPal Nuevo link de PayPal.
     */
    public void setLinkPayPal(String linkPayPal) {
        this.linkPayPal = linkPayPal;
    }

    /**
     * Retorna el id.
     * @return Id
     */
    public long getId() {
        return id;
    }

    /**
     * Asigna el id al dado por parámetro.
     * @param id Nuevo id.
     */
    public void setId(long id) {
        this.id = id;
    }
}
