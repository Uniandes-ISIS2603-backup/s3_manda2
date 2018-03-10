/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

import co.edu.uniandes.csw.manda2.entities.OrganizacionEntity;
import co.edu.uniandes.csw.manda2.entities.ServicioEntity;

/**
*
 * OrganizacionDTO Servicios de tipo organización. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 *
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "costoTransporte": double,
 *      "costoDuracion": double,
 *      "desplazamiento": Boolean
 *     
 *   }
 * </pre> Por ejemplo un servicio de tipo organizacion se representa asi:<br>
 *
 * <pre>
 *
 *   {
 *      "costoTransporte":25.000,
 *      "costoDuracion": 6.5000,
 *      "desplazamiento": true
 *     
 *   }
 *
 * </pre>
 
 * @author cvtrujillo
 */
public class OrganizacionDTO extends ServicioDetailDTO
{

    public OrganizacionDTO(){
    }
    
//    public OrganizacionDTO(OrganizacionEntity entityServicio) {
//        this.costoDeTransporte = entityServicio.getCostoTransporte();
//        this.costoDeDuracion = entityServicio.getCostoDuracion();
//        this.desplazamiento = entityServicio.getDesplazamiento();
//        this.id = id;
//    }
    
    /**
     * Costo del transporte para hacer el mandado de éste tipo
     */
    private Double costoDeTransporte;
    
    /** 
     * Costo que se le cobra al usuario, por la duración que se tiene
     * al hacer el servicio.
     */
    private Double costoDeDuracion;
    
    /**
     * Representa si es necesario el desplazamiento de uno de nuestros trabajadores
     * con el fin de cumplir con la diligencia. 0
    */
    private Boolean desplazamiento;
    
    /**
     * Identificacion del servicio de Organizacion
     */
    protected Long id;

    public OrganizacionDTO(OrganizacionEntity entityServicio) {
        //Completar
        
         super();
        if(entityServicio!= null)
        {
        this.id = entityServicio.getId();
        this.costoDeDuracion=  entityServicio.getCostoDuracion();
        this.costoDeTransporte=  entityServicio.getCostoTransporte();

       
    
        }
    }
    /**
     * Retorna el costo del transporte del servicio
     * @return costoDeTransporte el costo del transporte.
    */
    public Double getCostoTransporte ()
    {
        return costoDeTransporte;
    }
    /**
     * Retorna el costo de la duración del servicio
     * @return costoDeDuracion retorna el costo de la duracion.
     */
    public Double getCostoDuracion()
    {
        return costoDeDuracion;
    }
    
    /**
     * Obtener el id del servicio organizacion
     * @return id el id de la organizacion
     */
    public Long getId()
    {
        return id;
    }
    
    /**
     * Establecer el costo del trasnporte a cobrar
     * @param costoDeTransporte el costo del transporte
     */
    public void setCostoTransporte (Double costoDeTransporte)
    {
        this.costoDeTransporte=costoDeTransporte;
    }
    /**
     * Establecer el costo del desplazamiento del servicio
     * @param costoDeDuracion el costo por la duracion.
    */
    public void setCostoDuracion(Double costoDeDuracion)
    {
        this.costoDeDuracion=costoDeDuracion;
    }
    /**
     * Establecer el id del servicio de organizacion
     *
     * @param id el id de la organizacion
     */
    public void setId(Long id)
    {
        this.id=id;
    }
    /**
     * Verifica si el sericio requiere de un desplazamiento
     * @return desplazamiento true si desplazo, false lo contrario
     */
    public Boolean isDesplazamiento()
    {
        return desplazamiento;
    }
    /**
     * Establecer el desplazamiento, en caso de ser requerido
     * @param desplazamiento a recorer
     */
    public void setDesplazamiento(Boolean desplazamiento)
    {
        this.desplazamiento=desplazamiento;
    }
       /**
     * Convertir DTO a Entity
     *
     * @return Un Entity con los valores del DTO
     */
    @Override
    public OrganizacionEntity toEntity() {
        OrganizacionEntity entity = new OrganizacionEntity();
        entity.setId(this.id);
        entity.setCostoDuracion(this.costoDeDuracion);
        entity.setCostoTransporte(this.costoDeTransporte);
        return entity;
    }
}
