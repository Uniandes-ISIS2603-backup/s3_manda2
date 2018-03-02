/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author cv.trujillo
 */
@Entity

public class OrganizacionEntity extends ServicioEntity implements Serializable  {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
   @PodamExclude
    private Long id;
    
    
    private OrganizacionEntity organizacion;
    /**
     * Costo del transporte para hacer el mandado de éste tipo
     */
    @PodamExclude
    private Double costoDeTransporte;
    
    /** 
     * Costo que se le cobra al usuario, por la duración que se tiene
     * al hacer el servicio.
     */
    @PodamExclude
    private Double costoDeDuracion;
    
    /**
     * Representa si es necesario el desplazamiento de uno de nuestros trabajadores
     * con el fin de cumplir con la diligencia. 0
    */
    
   @PodamExclude
    private Boolean desplazamiento;
    
    /**
     * Identificacion del servicio de Organizacion
     */
  
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
}
