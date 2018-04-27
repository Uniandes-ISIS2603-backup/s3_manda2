package co.edu.uniandes.csw.manda2.entities;

import java.util.Objects;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PayPalEntity other = (PayPalEntity) obj;
        return true;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.linkPayPal);
        return hash;
    }  
}
