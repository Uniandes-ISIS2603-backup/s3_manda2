/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.entities;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author na.caceres
 */
@Entity
public class PSEEntity extends MedioPagoEntity implements Serializable{
    //Atributos
    /**
     * Atributo que representa el link de la transaccion.
     */
    private String linkPse;

    //Metodos
    /**
     * @return the linkPse
     */
    public String getLinkPse() {
        return linkPse;
    }

    /**
     * @param linkPse the linkPse to set
     */
    public void setLinkPse(String linkPse) {
        this.linkPse = linkPse;
    }
    
    
}
