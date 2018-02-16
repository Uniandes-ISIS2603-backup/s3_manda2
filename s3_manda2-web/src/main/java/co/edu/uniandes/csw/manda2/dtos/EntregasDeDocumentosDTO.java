
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

import java.io.Serializable;

/**
 *
 * @author dv.gonzalez10
 */
public class EntregasDeDocumentosDTO  extends ServicioDetailDTO implements Serializable{
    
    //Atributos
    /*
    *El costo de transporte del servicio
    */
    private Double costoDeTransporte;
    /*
    *El porcentaaje que se cobra extra por el servicio 
    */
    private Double porcentajeExtra;
    
    
    //Constructor

    
    public EntregasDeDocumentosDTO(){
        this(0D, 0D, null, null, null, 0L, "", 0D, "", "", false, 0D, "");
    }
    
    /**
     * Constructor
     * @param costoDeTransporte
     * @param porcentajeExtra
     * @param pago
     * @param cliente
     * @param empleado
     * @param id
     * @param nombre
     * @param costo
     * @param puntoDeEncuentro
     * @param puntoDeRealizacion
     * @param exitoDiligencia
     * @param calificacion
     * @param descripcion 
     */
    public EntregasDeDocumentosDTO(Double costoDeTransporte, Double porcentajeExtra, PagoDTO pago, ClienteDTO cliente, EmpleadoDTO empleado, Long id, String nombre, Double costo, String puntoDeEncuentro, String puntoDeRealizacion, Boolean exitoDiligencia, Double calificacion, String descripcion) {
        super(pago, cliente, empleado, id, nombre, costo, puntoDeEncuentro, puntoDeRealizacion, exitoDiligencia, calificacion, descripcion);
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