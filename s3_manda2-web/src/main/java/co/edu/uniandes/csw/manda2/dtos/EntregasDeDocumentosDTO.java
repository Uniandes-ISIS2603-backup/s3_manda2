
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

import co.edu.uniandes.csw.manda2.entities.EntregasDeDocumentosEntity;
import co.edu.uniandes.csw.manda2.entities.ServicioEntity;


/**
 **Clase que representa el servicio de entrega de documentos
 * 
 * * EntregasDeDocumentosDTO. Los DTO contienen las
 * representaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
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
 * <pre>
 * 
 *   {
 *      "costoDeTransporte": 20000,
 *      "porcentajeExtra": 5000,
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
 *   }
 *
 * </pre>
 *        
 *   }
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

    
    
   

    
    public EntregasDeDocumentosDTO()
    {
        
    }

    public EntregasDeDocumentosDTO(ServicioEntity entityServicio) {
        //Completar
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
     *  @param costoDeTransporte el valor del transporte.
     */
    public void setCostoDeTransporte(Double costoDeTransporte) {
        this.costoDeTransporte = costoDeTransporte;
    }

       /**
     *Retorna el valor del costo extra que se adiciona por el servicio
     * @return porcentajeExtra el porcentaje extra
     */
    public Double getPorcentajeExtra() {
        return porcentajeExtra;
    }

    /**
     * Asigna el valor del costo extra que se adiciona por el servicio.
     *  @param porcentajeExtra el porcentaje extra.
     */ 
    public void setPorcentajeExtra(Double porcentajeExtra) {
        this.porcentajeExtra = porcentajeExtra;
    }
    @Override
    public EntregasDeDocumentosEntity toEntity() {
        //PendientePorHacer
        return null;
    }
}