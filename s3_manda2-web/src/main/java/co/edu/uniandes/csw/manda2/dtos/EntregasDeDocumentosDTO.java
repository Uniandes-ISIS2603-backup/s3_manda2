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
    
    
    private Double costoDeTransporte;
    private Double porcentajeExtra;
    private Long iD;

    public Double getCostoDeTransporte() {
        return costoDeTransporte;
    }

    public void setCostoDeTransporte(Double costoDeTransporte) {
        this.costoDeTransporte = costoDeTransporte;
    }

    public Double getPorcentajeExtra() {
        return porcentajeExtra;
    }

    public void setPorcentajeExtra(Double porcentajeExtra) {
        this.porcentajeExtra = porcentajeExtra;
    }

    public Long getiD() {
        return iD;
    }

    public void setiD(Long iD) {
        this.iD = iD;
    }
    
    
}
