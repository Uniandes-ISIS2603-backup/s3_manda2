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
 * @author dv.gonzalez10
 */
@Entity
public class ComprasEnTiendaEntity  extends ServicioEntity  implements Serializable{
    
     /*
    *El costo del transporte del servicio
    */
    private Double costoDeTransporte;

    public Double getCostoDeTransporte() {
        return costoDeTransporte;
    }

    public void setCostoDeTransporte(Double costoDeTransporte) {
        this.costoDeTransporte = costoDeTransporte;
    }
    
    
    
}
