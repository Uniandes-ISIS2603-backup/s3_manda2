/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

import co.edu.uniandes.csw.manda2.entities.ServicioEntity;

/**
 * Clase abstracta que representa un servicio de la aplicación.
 *
 * @author da.ramos
 */
public abstract class ServicioDTO {

    /**
     * Id del objeto
     */
    protected Long id;

    /**
     * Constante que indica que el estado del servicio es "en espera".
     */
    public static final String EN_ESPERA = "EN_ESPERA";

    /**
     * Constante que indica que el estado del servicio es "en desarrollo".
     */
    public static final String EN_DESARROLLO = "EN_DESARROLLO";

    /**
     * Constante que indica que el estado del servicio es "finalizado".
     */
    public static final String FINALIZADO = "FINALIZADO";

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
     * Indica estado del servicio.
     */
    protected String estado;

    /**
     * Calificación del servicio.
     */
    protected Double calificacion;

    /**
     * Descripción del servicio.
     */
    protected String descripcion;

    /**
     * Constructor vacío.
     */
    public ServicioDTO() {
        //Constructor vacío.
    }

    /**
     * Constructor a partir de un ServicioEntity
     *
     * @param entity ServicioEntity
     */
    public ServicioDTO(ServicioEntity entity) {
        if (entity != null) {
            this.calificacion = entity.getCalificacion();
            this.costo = entity.getCosto();
            this.descripcion = entity.getDescripcion();
            this.estado = entity.getEstado();
            this.id = entity.getId();
            this.nombre = entity.getNombre();
            this.puntoDeEncuentro = entity.getPuntoDeEncuentro();
            this.puntoDeRealizacion = entity.getPuntoDeRealizacion();
        }
    }

    /**
     * Método para convertir el ServicioDTO a un ServicioEntity.
     *
     * @return ServicioEntity.
     */
    public ServicioEntity toEntity() {
        ServicioEntity entity = new ServicioEntity();
        entity.setCalificacion(calificacion);
        entity.setCosto(costo);
        entity.setDescripcion(descripcion);
        entity.setEstado(estado);
        entity.setId(id);
        entity.setNombre(nombre);
        entity.setPuntoDeEncuentro(puntoDeEncuentro);
        entity.setPuntoDeRealizacion(puntoDeRealizacion);
        return entity;
    }

    /**
     * Retorna el id.
     *
     * @return Id
     */
    public Long getId() {
        return id;
    }

    /**
     * Asigna el id al dado por parámetro.
     *
     * @param id Nuevo id.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna el nombre del servicio.
     *
     * @return nombre del servicio.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna el nombre del servicio al dado por parámetro.
     *
     * @param nombre Nuevo nombre del servicio.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna el costo del servicio.
     *
     * @return Costo del servicio.
     */
    public Double getCosto() {
        return costo;
    }

    /**
     * Asigna el costo del servicio al dado por parámetro.
     *
     * @param costo Nuevo costo.
     */
    public void setCosto(Double costo) {
        this.costo = costo;
    }

    /**
     * Retorna el punto de encuentro del servicio.
     *
     * @return Punto de encuentro del servicio.
     */
    public String getPuntoDeEncuentro() {
        return puntoDeEncuentro;
    }

    /**
     * Asigna el punto de encuentro del servicio al dado por parámetro.
     *
     * @param puntoDeEncuentro Nuevo punto de encuentro.
     */
    public void setPuntoDeEncuentro(String puntoDeEncuentro) {
        this.puntoDeEncuentro = puntoDeEncuentro;
    }

    /**
     * Retorna el punto de realización del servicio.
     *
     * @return Punto de realización del servicio.
     */
    public String getPuntoDeRealizacion() {
        return puntoDeRealizacion;
    }

    /**
     * Asigna el punto de realización del servicio al dado por parámetro.
     *
     * @param puntoDeRealizacion Nuevo punto de realización del servicio.
     */
    public void setPuntoDeRealizacion(String puntoDeRealizacion) {
        this.puntoDeRealizacion = puntoDeRealizacion;
    }

    /**
     * Retorna la calificación del servicio.
     *
     * @return Calificación del servicio.
     */
    public Double getCalificacion() {
        return calificacion;
    }

    /**
     * Asigna la calificación del sevicio a la dada por parámetro.
     *
     * @param calificacion Nueva calificación del servicio.
     */
    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * Retorna la descripción del servicio.
     *
     * @return Descripción del servicio.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Asigna la descripción del servicio a la dada por parámetro.
     *
     * @param descripcion Nueva descripción del servicio.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Retorna el estado del servicio
     *
     * @return estado del servicio
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Asigna el estado del servicio al dado por parámetro.
     *
     * @param estado nuevo estado del servicio.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
