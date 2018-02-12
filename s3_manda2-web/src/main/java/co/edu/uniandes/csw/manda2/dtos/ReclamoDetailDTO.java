/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

/**
 *
 * @author n.bello
 */
public class ReclamoDetailDTO extends ReclamoDTO {
    
    //ATRIBUTOS
    /**
     * Atributo que representa el empleado conectado con el reclamo
     */
    private EmpleadoDTO empleado;
    /**
     * Atributo que representa el servicio conectado con el reclamo
     */
    private ServicioDTO servicio;
    
    //CONSTRUCTOR
    
    /**
     * se general el reclamo
     * @param pEmpleado
     * @param pServicio 
     */
    public ReclamoDetailDTO(EmpleadoDTO pEmpleado, ServicioDTO pServicio)
    {
        super;
        empleado = pEmpleado;
        servicio = pServicio;
    }
    
    //METODOS
    
    /**
     * retorna al empleado del reclamo
     * @return empleado
     */
    public EmpleadoDTO getEmpleado() {
        return empleado;
    }
    /**
     * asigna empleado al reclamo
     * @param empleado 
     */
    public void setEmpleado(EmpleadoDTO empleado) {
        this.empleado = empleado;
    }
    /**
     * retorna el servicio del reclamo  
     * @return servicio
     */
    public ServicioDTO getServicio() {
        return servicio;
    }
    /**
     * asigna el servicio al reclamo
     * @param servicio 
     */
    public void setServicio(ServicioDTO servicio) {
        this.servicio = servicio;
    }
    
}
