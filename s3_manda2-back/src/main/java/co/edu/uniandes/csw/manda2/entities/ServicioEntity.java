        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;


/**
 * Clase abstracta para la serialización de un servicio.
 * @author da.ramos
 */
@Entity
public class ServicioEntity extends BaseEntity{
    
    /**
     * Constante que indica que el estado del servicio es "en espera".
     */
    public final static String EN_ESPERA = "EN_ESPERA";
    
    /**
     * Constante que indica que el estado del servicio es "en desarrollo".
     */
    public final static String EN_DESARROLLO = "EN_DESARROLLO";
    
    /**
     * Constante que indica que el estado del servicio es "finalizado".
     */
    public final static String FINALIZADO = "FINALIZADO";
    
     /**
     * Nombre del servicio.
     */
    protected String nombre;
    
    /**
     * Costo del servicio.
     */
    protected Double costo;
    
    /**
     * Punto de encuentro del empleado con el cliente.
     */
    protected String puntoDeEncuentro;
    
    /**
     * Punto donde se tiene que hacer el servicio.
     */
    protected String puntoDeRealizacion;
    
    /**
     * Estado del servicio.
     */
    @PodamExclude
    private String estado;
    
    /**
     * Calificación del servicio.
     */
    protected Double calificacion;
    
    /**
     * Descripción del servicio.
     */
    protected String descripcion;
    
    
    @ManyToOne
    @PodamExclude
    private ClienteEntity cliente;
    
    @ManyToOne  
    @PodamExclude
    private EmpleadoEntity empleado;
    
        /**
     * Retorna el nombre del servicio.
     * @return nombre del servicio.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna el nombre del servicio al dado por parámetro.
     * @param nombre Nuevo nombre del servicio.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna el costo del servicio.
     * @return Costo del servicio.
     */
    public Double getCosto() {
        return costo;
    }

    /**
     * Asigna el costo del servicio al dado por parámetro.
     * @param costo Nuevo costo.
     */
    public void setCosto(Double costo) {
        this.costo = costo;
    }

    /**
     * Retorna el punto de encuentro del servicio.
     * @return Punto de encuentro del servicio.
     */
    public String getPuntoDeEncuentro() {
        return puntoDeEncuentro;
    }

    /**
     * Asigna el punto de encuentro del servicio al dado por parámetro.
     * @param puntoDeEncuentro Nuevo punto de encuentro.
     */
    public void setPuntoDeEncuentro(String puntoDeEncuentro) {
        this.puntoDeEncuentro = puntoDeEncuentro;
    }

    /**
     * Retorna el punto de realización del servicio. 
     * @return Punto de realización del servicio.
     */
    public String getPuntoDeRealizacion() {
        return puntoDeRealizacion;
    }

    /**
     * Asigna el punto de realización del servicio al dado por parámetro.
     * @param puntoDeRealizacion Nuevo punto de realización del servicio.
     */
    public void setPuntoDeRealizacion(String puntoDeRealizacion) {
        this.puntoDeRealizacion = puntoDeRealizacion;
    }

    /**
     * Retorna la calificación del servicio.
     * @return Calificación del servicio.
     */
    public Double getCalificacion() {
        return calificacion;
    }

    /**
     * Asigna la calificación del sevicio a la dada por parámetro.
     * @param calificacion Nueva calificación del servicio.
     */
    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * Retorna la descripción del servicio.
     * @return Descripción del servicio.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Asigna la descripción del servicio a la dada por parámetro.
     * @param descripcion Nueva descripción del servicio.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Retorna el estado del servicio
     * @return estado del servicio 
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Asigna el estado del servicio al dado por parámetro.
     * @param estado nuevo estado del servicio.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }


    /**
     * Retorna el cliente asociado al servicio.
     * @return cliente asociado al servicio.
     */
    public ClienteEntity getCliente() {
        return cliente;
    }

    /**
     * Asigna el cliente al dado por parámetro.
     * @param cliente nuevo cliente del servicio.
     */
    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    /**
     * Retorna el empleado asociado al servicio.
     * @return empleado asociado al servicio.
     */
    public EmpleadoEntity getEmpleado() {
        return empleado;
    }

    /**
     * Asigna el empleado al dado por parámetro.
     * @param empleado nuevo empleado del servicio.
     */
    public void setEmpleado(EmpleadoEntity empleado) {
        this.empleado = empleado;
    }
}
