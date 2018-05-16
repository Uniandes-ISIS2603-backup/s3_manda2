/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

import co.edu.uniandes.csw.manda2.entities.PagoEntity;
import co.edu.uniandes.csw.manda2.entities.VueltasConDemoraEnOficinaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author na.caceres
 */
public class VueltasConDemoraEnOficinaDetailDTO extends ServicioDetailDTO {
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
        
        /**
     * Pago asociado al servicio.
     */
    private List<PagoDTO> pago;
        
    public VueltasConDemoraEnOficinaDetailDTO(){
       super ();
    }

    public VueltasConDemoraEnOficinaDetailDTO(VueltasConDemoraEnOficinaEntity entityServicio) {
        super(entityServicio);
        if(entityServicio!= null)
        {
        this.id = entityServicio.getId();
        this.calificacion = entityServicio.getCalificacion();
        this.costo = entityServicio.getCosto();
        this.descripcion = entityServicio.getDescripcion();
        this.estado = entityServicio.getEstado();
        this.nombre = entityServicio.getNombre();
        this.puntoDeEncuentro = entityServicio.getPuntoDeEncuentro();
        this.puntoDeRealizacion = entityServicio.getPuntoDeRealizacion();
        this.costoDuracion=  entityServicio.getCostoDuracion();
        this.costoDeTransporte=  entityServicio.getCostoDeTransporte();
        if (entityServicio.getCliente() != null) {
                this.cliente = new ClienteDTO(entityServicio.getCliente());
            }
            if (entityServicio.getEmpleado() != null) {
                this.empleado = new EmpleadoDTO(entityServicio.getEmpleado());
            }
            if (entityServicio.getPago() != null) {
                this.pago = new ArrayList();
                for (PagoEntity entityPago : entityServicio.getPago()) {
                    pago.add(new PagoDTO(entityPago));
                }
            }
        }
    }
   
public List<PagoDTO> getPago() {
        return pago;
    }

    public void setPago(List<PagoDTO> pago) {
        this.pago = pago;
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
  
      /**
     * Convertir DTO a Entity
     *
     * @return Un Entity con los valores del DTO
     */
    @Override
    public VueltasConDemoraEnOficinaEntity toEntity()
    {
        VueltasConDemoraEnOficinaEntity entity = new VueltasConDemoraEnOficinaEntity();
        entity.setId(this.id);
        entity.setCostoDuracion(this.getCostoDuracion());
        entity.setCostoDeTransporte(this.getCostoDeTransporte());
        entity.setCalificacion(calificacion);
        entity.setCosto(costo);
        entity.setDescripcion(descripcion);
        entity.setEstado(estado);
        entity.setId(id);
        entity.setNombre(nombre);
        entity.setPuntoDeEncuentro(puntoDeEncuentro);
        entity.setPuntoDeRealizacion(puntoDeRealizacion);
        if (this.cliente != null) {
            entity.setCliente(this.cliente.toEntity());
        }

       if (pago != null) {
            List<PagoEntity> pagosEntity = new ArrayList();
            for (PagoDTO dtoPago : pago) {
                pagosEntity.add(dtoPago.toEntity());
            }
            entity.setPago(pagosEntity);
        }
        if(this.empleado != null)
        {
            entity.setEmpleado(this.empleado.toEntity());
        }
        return entity;
    
    }
}
