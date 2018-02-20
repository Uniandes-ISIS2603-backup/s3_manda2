package co.edu.uniandes.csw.manda2.entities;

import javax.persistence.Entity;

/**
 *
 * @author da.ramos
 */
@Entity
public class PayPalEntity extends MedioPagoEntity{
    
    private String linkPayPal;

    public String getLinkPayPal() {
        return linkPayPal;
    }

    public void setLinkPayPal(String linkPayPal) {
        this.linkPayPal = linkPayPal;
    }
}
