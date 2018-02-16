/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

import java.io.Serializable;

/**
 *
 * Clase que representa el servicio de compras en tienda
 * @author dv.gonzalez10
 */
public class ComprasEnTiendaDTO /*extends ServicioDetailDTO */ implements Serializable{
    
    //Atributos
    /*
    *El costo del transporte del servicio
    */
    private Double costoDeTransporte;
  

    public ComprasEnTiendaDTO(){
        this(0D, null, null, null, 0L, "", 0D, "", "", false, 0D, "");
    }
    
    /**
     * Constructor
     * @param costoDeTransporte
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
    public ComprasEnTiendaDTO(Double costoDeTransporte, PagoDTO pago, ClienteDTO cliente, EmpleadoDTO empleado, Long id, String nombre, Double costo, String puntoDeEncuentro, String puntoDeRealizacion, Boolean exitoDiligencia, Double calificacion, String descripcion) {
        // super(pago, cliente, empleado, id, nombre, costo, puntoDeEncuentro, puntoDeRealizacion, exitoDiligencia, calificacion, descripcion);
        this.costoDeTransporte = costoDeTransporte;
    }

    
    //METODOS
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
}
