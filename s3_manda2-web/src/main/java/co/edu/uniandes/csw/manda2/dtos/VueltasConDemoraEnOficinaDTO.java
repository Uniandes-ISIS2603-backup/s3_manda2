/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

import java.util.Date;

/**
 * Clase que representa el servicio de vueltas con demora en oficina, como filas para bancos, etc ... 
 *
 * @author dv.gonzalez10
 */
public class VueltasConDemoraEnOficinaDTO {
    
        //Atributos
    
        /*
        *El monto maximo que se puede entregar en efectivo para una vuelta 
        */
        public static final Double   MONTO_MAXIMO = 1000000.0;
        /*
        *El costo de la duracion del servicio en oficina
        */
        private Date costoDuracion;
        /*
        *El costo del transporte del servicio
        */
        private Double costoDeTransporte;
        /**
        * Id del objeto
        */
        private Long  iD;

        
     /**
     *Retorna el valor asociado a la duración del servicio
     * @return costoDeTransporte
     */    
    public Date getCostoDuracion() {
        return costoDuracion;
    }

    /**
     * Asigna el costo de duración.
     * @param Date costoDuracion
     */
    public void setCostoDuracion(Date costoDuracion) {
        this.costoDuracion = costoDuracion;
    }

     /**
     *Retorna el valor asociado al transporte del servicio
     * @return costoDeTransporte
     */
    public Double getCostoDeTransporte() {
        return costoDeTransporte;
    }

        /**
     * Asigna el valor del costo del transporte
     *  @param costoDeTransporte
     */
    public void setCostoDeTransporte(Double costoDeTransporte) {
        this.costoDeTransporte = costoDeTransporte;
    }
    
     /**
     *Retorna el iD asociado al servicio de entregas de documentos
     * @return iD
     */
    public Long getiD() {
        return iD;
    }
    /**
     * Asigna el iD de el servicio de entrega de documento
     *  @param iD
     */
    public void setiD(Long iD) {
        this.iD = iD;
    }
        
        
            
}
