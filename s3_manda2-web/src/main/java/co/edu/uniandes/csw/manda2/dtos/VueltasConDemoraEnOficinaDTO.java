/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

import co.edu.uniandes.csw.manda2.entities.ServicioEntity;
import co.edu.uniandes.csw.manda2.entities.VueltasConDemoraEnOficinaEntity;


/**
 * Clase que representa el servicio de vueltas con demora en oficina, como filas para bancos, etc ... 
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "costoDeDuracion": Double,
 *      "costoDeTransporte": Double,
 *      "porcentajeExtra": Double,
 *      "pago": PagoDTO,
 *      "cliente": ClienteDTO,
 *      "empleado": Empleado DTO,
 *      "id": Long,
 *      "nombre": String,
 *      "costo": Double,
 *      "puntoDeEncuentro": String,
 *      "puntoDeRealizacion": String,
 *      "puntoDeRealizacion": String,
 *      "exitoDiligencia": Boolean,
 *      "calification": Double,
 *      "descripcion": String,
 *  </pre>
 * Por ejemplo una ciudad se representa asi:<br>
 *
 * @author dv.gonzalez10
 */
public class VueltasConDemoraEnOficinaDTO extends ServicioDetailDTO {
    
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
        
        
        
    public VueltasConDemoraEnOficinaDTO(){
       
    }

    public VueltasConDemoraEnOficinaDTO(ServicioEntity entityServicio) {
        //completar
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
     * @param costoDuracion costoDuracion
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
     *  @param costoDeTransporte el costo del transporte
     */
    public void setCostoDeTransporte(Double costoDeTransporte) {
        this.costoDeTransporte = costoDeTransporte;
    }
  
    @Override
    public VueltasConDemoraEnOficinaEntity toEntity()
    {
        // pendiente por completar.
        return null;
    }     
}
