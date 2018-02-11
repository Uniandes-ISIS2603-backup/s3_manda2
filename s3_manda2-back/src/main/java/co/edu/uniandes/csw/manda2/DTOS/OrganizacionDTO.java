/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.DTOS;

/**
 *
 * @author cvtrujillo
 */
public abstract class OrganizacionDTO 
{
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
    private boolean desplazamiento;
    
    /**
     * Identificacion del servicio de Organizacion
     */
    private Long id;
    /**
     * Retorna el costo del transporte del servicio
    */
    public Double getCostoTransporte ()
    {
        return costoDeTransporte;
    }
    /**
     * Retorna el costo de la duración del servicio
     */
    public Double getCostoDuracion()
    {
        return costoDeDuracion;
    }
    
    /**
     * Obtener el id del servicio organizacion
     * @return 
     */
    public Long getId()
    {
        return id;
    }
    
    /**
     * Establecer el costo del trasnporte a cobrar
     * @param el costo de transporte a asignar
     */
    public void setCostoTransporte (Double costoDeTransporte)
    {
        this.costoDeTransporte=costoDeTransporte;
    }
    /**
     * Establecer el costo del desplazamiento del servicio
     * @param el costo de la duración del servicio
    */
    public void setCostoDuracion(Double costoDeDuracion)
    {
        this.costoDeDuracion=costoDeDuracion;
    }
    /**
     * Establecer el id del servicio de organizacion
     * */
    public void setId(Long id)
    {
        this.id=id;
    }
    /**
     * Verifica si el sericio requiere de un desplazamiento
     * @return 
     */
    public boolean isDesplazamiento()
    {
        return desplazamiento;
    }
    /**
     * Establecer el desplazamiento, en caso de ser requerido
     * @param desplazamiento a recorer
     */
    public void setDesplazamiento(boolean desplazamiento)
    {
        this.desplazamiento=desplazamiento;
    }
}
