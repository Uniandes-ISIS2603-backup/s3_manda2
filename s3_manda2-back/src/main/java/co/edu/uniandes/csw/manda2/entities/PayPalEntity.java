package co.edu.uniandes.csw.manda2.entities;

import javax.persistence.Entity;

/**
 * Clase para la serialización del PayPal.
 * @author da.ramos
 */
@Entity
public class PayPalEntity extends MedioPagoEntity{
    
    /**
     * Link asociado con la cuenta de PayPal.
     */
    private String linkPayPal;

    /**
     * Retorna el link.
     * @return link del PayPal.
     */
    public String getLinkPayPal() {
        return linkPayPal;
    }

    /**
     * Asigna el link del PayPal al valor dado por parámetro.
     * @param linkPayPal nuevo link del PayPal.
     */
    public void setLinkPayPal(String linkPayPal) {
        this.linkPayPal = linkPayPal;
    }
}
