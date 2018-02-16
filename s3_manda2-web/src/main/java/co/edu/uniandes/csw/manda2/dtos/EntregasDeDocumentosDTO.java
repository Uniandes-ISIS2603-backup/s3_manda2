
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
public class EntregasDeDocumentosDTO  extends ServicioDetailDTO{
    
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

    
    
    /**
     * Constructor
     * @param costoDeTransporte costo asociado con el transporte del servicio 
     * @param porcentajeExtra el porcentaje extra por el servicio
     * @param pago el pago que el cliente realiza por el servicio 
     * @param cliente el cliente que obtiene el servicio 
     * @param empleado empleado que realiza el servicio
     * @param id  id del servicio
     * @param nombre nombre del servicio
     * @param costo costo del servicio
     * @param puntoDeEncuentro punto de encuentro del cliente y empleado
     * @param puntoDeRealizacion punto de realizacion del servicio
     * @param exitoDiligencia indica si la diligencia tuvo o no éxito
     * @param calificacion calificación del servicio.
     * @param descripcion descripción del servicio.
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