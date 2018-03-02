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
        this(0D, 0D, false, 0L);
    }
    
    public OrganizacionDTO(Double costoDeTransporte, Double costoDeDuracion, Boolean desplazamiento, Long id) {
        this.costoDeTransporte = costoDeTransporte;
        this.costoDeDuracion = costoDeDuracion;
        this.desplazamiento = desplazamiento;
        this.id = id;
    }
    
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
    private Long id;

    public OrganizacionDTO(ServicioEntity entityServicio) {
        //Completar
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
    @Override
    public OrganizacionEntity toEntity()
    {
        // pendiente por completar.
        return null;
    }
}
