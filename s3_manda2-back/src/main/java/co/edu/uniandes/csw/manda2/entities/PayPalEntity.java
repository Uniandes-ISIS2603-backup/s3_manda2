/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.entities;

import javax.persistence.Entity;

/**
 *
 * @author da.ramos
 */
@Entity
public class PayPalEntity extends MedioDePagoEntity{
    
    private String linkPayPal;

    public String getLinkPayPal() {
        return linkPayPal;
    }

    public void setLinkPayPal(String linkPayPal) {
        this.linkPayPal = linkPayPal;
    }
    
}
