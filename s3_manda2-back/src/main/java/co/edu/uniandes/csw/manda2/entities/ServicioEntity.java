/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.entities;

import javax.persistence.Entity;

/**
 *
 * @author da.ramos
 */
@Entity
public abstract class ServicioEntity extends BaseEntity{
    
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
     * Indica si la diligencia tuvo éxito.
     */
    protected Boolean exitoDiligencia;
    
    /**
     * Calificación del servicio.
     */
    protected Double calificacion;
    
    /**
     * Descripción del servicio.
     */
    protected String descripcion;
    
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
     * Indica si la diligencia tuvo éxito.
     * @return true si la diligencia tuvo éxito, false de lo contrario.
     */
    public Boolean isExitoDiligencia() {
        return exitoDiligencia;
    }

    /**
     * Asigna el exito de la diligencia al dado por parámetro.
     * @param exitoDiligencia exito de la diligencia.
     */
    public void setExitoDiligencia(Boolean exitoDiligencia) {
        this.exitoDiligencia = exitoDiligencia;
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
}
