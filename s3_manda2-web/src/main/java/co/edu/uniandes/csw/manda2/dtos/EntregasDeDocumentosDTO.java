/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

/**
 *
 * @author dv.gonzalez10
 */
public class EntregasDeDocumentosDTO {
    
    //Atributos
    /*
    *El costo de transporte del servicio
    */
    private Double costoDeTransporte;
    /*
    *El porcentaaje que se cobra extra por el servicio 
    */
    private Double porcentajeExtra;

    
    /**
     * Metodo constructor de el servicio entregas de documentos
     * @param costoDeTransporte
     * @param porcentajeExtra 
     */
    public EntregasDeDocumentosDTO(Double costoDeTransporte, Double porcentajeExtra) {
        this.costoDeTransporte = costoDeTransporte;
        this.porcentajeExtra = porcentajeExtra;
    }

   
    
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
     *  @param costoDeTransporte
     */
    public void setCostoDeTransporte(Double costoDeTransporte) {
        this.costoDeTransporte = costoDeTransporte;
    }

       /**
     *Retorna el valor del costo extra que se adiciona por el servicio
     * @return porcentajeExtra
     */
    public Double getPorcentajeExtra() {
        return porcentajeExtra;
    }

    /**
     * Asigna el valor del costo extra que se adiciona por el servicio.
     *  @param porcentajeExtra
     */ 
    public void setPorcentajeExtra(Double porcentajeExtra) {
        this.porcentajeExtra = porcentajeExtra;
    }
    
}