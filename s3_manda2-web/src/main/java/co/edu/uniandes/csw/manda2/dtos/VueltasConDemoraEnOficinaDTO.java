/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase que representa el servicio de vueltas con demora en oficina, como filas para bancos, etc ... 
 *
 * @author dv.gonzalez10
 */
public class VueltasConDemoraEnOficinaDTO extends ServicioDetailDTO implements Serializable {
    
        //Atributos
    
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
     

        
        //Constructor
    /**
     * Constructor
     * @param costoDuracion
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
    public VueltasConDemoraEnOficinaDTO(Double costoDuracion, Double costoDeTransporte, PagoDTO pago, ClienteDTO cliente, EmpleadoDTO empleado, long id, String nombre, double costo, String puntoDeEncuentro, String puntoDeRealizacion, boolean exitoDiligencia, double calificacion, String descripcion) {
        super(pago, cliente, empleado, id, nombre, costo, puntoDeEncuentro, puntoDeRealizacion, exitoDiligencia, calificacion, descripcion);
        this.costoDuracion = costoDuracion;
        this.costoDeTransporte = costoDeTransporte;
    }

    /**
     *Retorna el valor asociado a la duración del servicio
     * @return costoDeTransporte
     */    
    public Double getCostoDuracion() {
        return costoDuracion;
    }

    /**
     * Asigna el costo de duración.
     * @param Double costoDuracion
     */
    public void setCostoDuracion(Double costoDuracion) {
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
  
            
}
