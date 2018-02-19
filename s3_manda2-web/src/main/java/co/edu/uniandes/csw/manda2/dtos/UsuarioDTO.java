/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

import java.util.Date;

/**
 *  Clase abstracta que representa un usuario
 * @author n.bello
 */
public abstract class UsuarioDTO  {
    //ATRIBUTOS
    /**
     * Atributo que representa el nombre del usuario
     */
    private String nombre;
    /**
     * Atributo que representa la cedula del usuario
     */
    private String  cedula;
    /**
     * Atributo representa la fecha de ingreso del usuario
     */
    private Date fechaingreso;
    /**
     * Atributo que representa la calificacion del usuario
     */
    private Double calificacion;
     /**
     * Atributo que representa la id del usuario
     */
    private Long id;
    
    
    //CONSTRUCTOR
    /**
     * genera un usuario
     */
    public UsuarioDTO()
    {
        nombre = "";
        cedula = "";
        //fechaingreso = null;
        calificacion = 5.0;
        id = new Long(0);
    }
   /**
    * genera un usuario 
    * @param pNombre nombre para asignarle al usuario 
    * @param pCedula cedula para asignarle al usuario
    * @param pFechaingreso fecha de ingreso del usuario
    * @param pId id que se le asigna al ususario
    */
    
    public UsuarioDTO(String pNombre, String pCedula, Date pFechaingreso, Long pId)
    {
        nombre = pNombre;
        cedula = pCedula;
        fechaingreso = pFechaingreso;
        calificacion = 5.0;
        id = pId;
    }
    //METODOS
    /**
     * retorna el nombre del ususario
     * @return nombre del usuario
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * asigna el nombre que llega por parametro
     * @param nombre llega el nombre del ususario que se le va a asignar 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * retorna la cedula del usuario
     * @return cedula retorna la cedula del usuario 
     */
    public String getCedula() {
        return cedula;
    }
    /**
     * asigna la cedula que llega por parametro
     * @param cedula llega el numero de cedula del usuario
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    /**
     * retorna la fecha de ingreso
     * @return fechaingreso retorna la fecha de ingreso del usuario
     */
    public Date getFechaingreso() {
        return fechaingreso;
    }
    /**
     * asigna la fecha de ingreso
     * @param fechaingreso llega la fecha de ingreso que se le asignara al usuario 
     */
    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }
    /**
     * retorna la calificacion del usuario
     * @return calificacion retorna la calificacion del usuario
     */
    public Double getCalificacion() {
        return calificacion;
    }
    /**
     * asigna la calificacion que llega por parametro
     * @param calificacion llega la calificacion que se le va a asignar al ususario
     */
    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }
    /**
     * retorna el id del ususario
     * @return id retoruna el id del usuario
     */
    
    public Long getId() {
        return id;
    }
    /**
     * asigna el id que llega por parametro
     * @param id llega el id que se le asignara al ususario por parametro 
     */
    public void setID(Long  id) {
        this.id = id;
    }
}
