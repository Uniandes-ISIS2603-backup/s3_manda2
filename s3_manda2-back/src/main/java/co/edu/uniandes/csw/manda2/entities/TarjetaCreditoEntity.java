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
public class TarjetaCreditoEntity extends MedioPagoEntity implements Serializable {
    
    //Atributos
    /**
     * Atributo que representa el numero de una tarjeta de credito.
     */
    private String numeroTarjeta;
    //Metodos

    /**
     * @return the numeroTarjeta
     */
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    /**
     * @param numeroTarjeta the numeroTarjeta to set
     */
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }
}
