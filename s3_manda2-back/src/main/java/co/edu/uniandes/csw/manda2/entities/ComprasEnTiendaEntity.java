/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author dv.gonzalez10
 */
@MappedSuperclass
public class ComprasEnTiendaEntity  extends ServicioEntity  implements Serializable{

    //Atributos    
     /*
    *El costo del transporte del servicio
    */
    private Double costoDeTransporte;

    //Metodos
    
     /**
     *Retorna el valor asociado al transporte del servicio
     * @return costoDeTransporte
     */
    public Double getCostoDeTransporte() {
        return costoDeTransporte;
    }
    
    
    /**
     * Asigna el valor del costo del transporte
     *  @param costoDeTransporte valor del transporte a modificar
     */
    public void setCostoDeTransporte(Double costoDeTransporte) {
        this.costoDeTransporte = costoDeTransporte;
    }
    
    
    
}
