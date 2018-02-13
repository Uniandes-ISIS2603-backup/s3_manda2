/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

/**
 *
 * Clase que representa el servicio de compras en tienda
 * @author dv.gonzalez10
 */
public class ComprasEnTiendaDTO {
    
    //Atributos
    /*
    *El costo del transporte del servicio
    */
    private Double costoDeTransporte;
    /**
     * Id del objeto
     */
    private Long iD;

    
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
