/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

/**
 * Clase abstracta que representa un servicio de la aplicación.
 * @author da.ramos
 */
public abstract class ServicioDTO {
    
    
     /**
     * Id del objeto
     */
    private Long id;
    
    /**
     * Constante que indica que el estado del servicio es "en espera".
     */
    public static String EN_ESPERA = "EN_ESPERA";
    
    /**
     * Constante que indica que el estado del servicio es "en desarrollo".
     */
    public static String EN_DESARROLLO = "EN_DESARROLLO";
    
    /**
     * Constante que indica que el estado del servicio es "finalizado".
     */
    public static String FINALIZADO = "FINALIZADO";
    
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
    
    public ServicioDTO(){
        this(0L, "", 0D, "", "", false, 0D, "");
    }
    
    /**
     * Crea un nuevo servicio.
     * @param id id del servicio
     * @param nombre noombre del servicio
     * @param costo costo del servicio
     * @param puntoDeEncuentro punto de encuentro del cliente y empleado
     * @param puntoDeRealizacion punto de realizacion del servicio
     * @param exitoDiligencia indica si la diligencia tuvo o no éxito
     * @param calificacion calificación del servicio.
     * @param descripcion descripción del servicio.
     */
    public ServicioDTO(Long id, String nombre, Double costo, String puntoDeEncuentro, String puntoDeRealizacion, Boolean exitoDiligencia, Double calificacion, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.costo = costo;
        this.puntoDeEncuentro = puntoDeEncuentro;
        this.puntoDeRealizacion = puntoDeRealizacion;
        this.exitoDiligencia = exitoDiligencia;
        this.calificacion = calificacion;
        this.descripcion = descripcion;
    }
    
     /**
     * Retorna el id.
     * @return Id
     */
    public Long getId() {
        return id;
    }

    /**
     * Asigna el id al dado por parámetro.
     * @param id Nuevo id.
     */
    public void setId(Long id) {
        this.id = id;
    }

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
