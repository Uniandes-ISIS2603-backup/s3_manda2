/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author na.caceres
 */
@Entity
public class ClienteEntity extends UsuarioEntity implements Serializable {

    //Atributos
    /**
     * boolean que representa si un cliente tiene dinero en su billetera virtual
    */
    private Boolean pagoAnticipado;
    /**
     * numero que representa las horas de servicio que tiene un cliente semanalmente
     */
    private Integer horasDeServicioSemanal;

    //Metodos

    /**
     * @return the pagoAnticipado
     */
    public Boolean isPagoAnticipado() {
        return pagoAnticipado;
    }

    /**
     * @param pagoAnticipado the pagoAnticipado to set
     */
    public void setPagoAnticipado(Boolean pagoAnticipado) {
        this.pagoAnticipado = pagoAnticipado;
    }

    /**
     * @return the horasDeServicioSemanal
     */
    public Integer getHorasDeServicioSemanal() {
        return horasDeServicioSemanal;
    }

    /**
     * @param horasDeServicioSemanal the horasDeServicioSemanal to set
     */
    public void setHorasDeServicioSemanal(Integer horasDeServicioSemanal) {
        this.horasDeServicioSemanal = horasDeServicioSemanal;
    }
    
}
