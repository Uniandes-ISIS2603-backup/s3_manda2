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
public class VueltasConDemoraEnOficinaEntity extends ServicioEntity  implements Serializable {
     
    
     /*
        *El monto maximo que se puede entregar en efectivo para una vuelta 
        */
        public static final Double   MONTO_MAXIMO = 1000000.0;
        /*
        *El costo de la duracion del servicio en oficina
        */
        private Double costoDuracion;
        /*
        *El costo del transporte del servicio
        */
        private Double costoDeTransporte;

    public Double getCostoDuracion() {
        return costoDuracion;
    }

    public void setCostoDuracion(Double costoDuracion) {
        this.costoDuracion = costoDuracion;
    }

    public Double getCostoDeTransporte() {
        return costoDeTransporte;
    }

    public void setCostoDeTransporte(Double costoDeTransporte) {
        this.costoDeTransporte = costoDeTransporte;
    }
        
        
        
    
}
