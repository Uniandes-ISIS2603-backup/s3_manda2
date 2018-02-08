/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

import java.util.Date;

/**
 *
 * @author dv.gonzalez10
 */
public class VueltasConDemoraEnOficinaDTO {
    
        public static final Double   MONTO_MAXIMO = 1000000.0;
        private Date costoDuracion;
        private Double costoDeTransporte;
        private Long  iD;

    public Date getCostoDuracion() {
        return costoDuracion;
    }

    public void setCostoDuracion(Date costoDuracion) {
        this.costoDuracion = costoDuracion;
    }

    public Double getCostoDeTransporte() {
        return costoDeTransporte;
    }

    public void setCostoDeTransporte(Double costoDeTransporte) {
        this.costoDeTransporte = costoDeTransporte;
    }

    public Long getiD() {
        return iD;
    }

    public void setiD(Long iD) {
        this.iD = iD;
    }
        
        
            
}
