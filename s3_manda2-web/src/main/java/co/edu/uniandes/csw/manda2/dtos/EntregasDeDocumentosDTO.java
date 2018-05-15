
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
 * * EntregasDeDocumentosDTO. Los DTO contienen las representaciones de los
 * JSON que se transfieren entre el cliente y el servidor.
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
 * </pre> Por ejemplo una entrega se representa asi:<br>
 *
 * <pre>
 *
 *   {
 *      "costoDeTransporte": 10.000,
 *      "pago": PagoDTO,
 *      "cliente": pedro,
 *      "empleado": Empleado1,
 *      "id": 345,
 *      "nombre": compra1,
 *      "costo": 30.000,
 *      "puntoDeEncuentro":calle 44,
 *      "puntoDeRealizacion": Exito ,
 *      "exitoDiligencia": true,
 *      "calification": 5,
 *      "descripcion": estuvo bien ,
 *   }
 *
 * </pre>
 *
 * }
 *
 * @author dv.gonzalez10
 */
public class EntregasDeDocumentosDTO extends ServicioDetailDTO {

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
     * Constructor vacio
     */
    public EntregasDeDocumentosDTO() {

    }

    public EntregasDeDocumentosDTO(EntregasDeDocumentosEntity entity) {
        super(entity);
        if (entity != null) {
            this.id = entity.getId();
            this.porcentajeExtra = entity.getPorcentajeExtra();
            this.costoDeTransporte = entity.getCostoDeTransporte();
            this.calificacion = entity.getCalificacion();
            this.costo = entity.getCosto();
            this.descripcion = entity.getDescripcion();
            this.estado = entity.getEstado();
            this.nombre = entity.getNombre();
            this.puntoDeEncuentro = entity.getPuntoDeEncuentro();
            this.puntoDeRealizacion = entity.getPuntoDeRealizacion();
        }
    }

    //Metodos 
    /**
     * Retorna el valor asociado al transporte del servicio
     *
     * @return costoDeTransporte
     */
    public Double getCostoDeTransporte() {
        return costoDeTransporte;
    }

    /**
     * Asigna el valor del costo del transporte
     *
     * @param costoDeTransporte el valor del transporte.
     */
    public void setCostoDeTransporte(Double costoDeTransporte) {
        this.costoDeTransporte = costoDeTransporte;
    }

    /**
     * Retorna el valor del costo extra que se adiciona por el servicio
     *
     * @return porcentajeExtra el porcentaje extra
     */
    public Double getPorcentajeExtra() {
        return porcentajeExtra;
    }

    /**
     * Asigna el valor del costo extra que se adiciona por el servicio.
     *
     * @param porcentajeExtra el porcentaje extra.
     */
    public void setPorcentajeExtra(Double porcentajeExtra) {
        this.porcentajeExtra = porcentajeExtra;
    }

    /**
     * Convierte un DTO a entity
     *
     * @return Un entity con los valores del DTO
     */
    @Override
    public EntregasDeDocumentosEntity toEntity() {
        EntregasDeDocumentosEntity entity = new EntregasDeDocumentosEntity();
        entity.setId(this.id);
        entity.setCostoDeTransporte(this.getCostoDeTransporte());
        entity.setPorcentajeExtra(this.getPorcentajeExtra());
        entity.setCalificacion(calificacion);
        entity.setCosto(costo);
        entity.setDescripcion(descripcion);
        entity.setEstado(estado);
        entity.setId(id);
        entity.setNombre(nombre);
        entity.setPuntoDeEncuentro(puntoDeEncuentro);
        entity.setPuntoDeRealizacion(puntoDeRealizacion);
        //Ciclo 3 problemas con las entidades
        /**
        if(this.cliente != null){
            entity.setCliente(this.cliente.toEntity());
        }
        //TODO: Qué pasa si this.pago es null? 
        if(this.pago != null){
            entity.setPago(this.pago.toEntity());
        }
        if(this.empleado != null)
        {
            //entity.setEmpleado((this.empleado.toEntity());
        }
        */
        return entity;
        
    }
}
