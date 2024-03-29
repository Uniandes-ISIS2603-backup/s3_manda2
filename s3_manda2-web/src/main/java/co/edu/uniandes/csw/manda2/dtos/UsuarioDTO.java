/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

import co.edu.uniandes.csw.manda2.entities.EmpleadoEntity;
import co.edu.uniandes.csw.manda2.entities.UsuarioEntity;
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
    protected String nombre;
    /**
     * Atributo que representa la cedula del usuario
     */
    protected String  cedula;
    /**
     * Atributo representa la fecha de ingreso del usuario
     */
    protected Date fechaIngreso;
    /**
     * Atributo que representa la calificacion del usuario
     */
    protected Double calificacion;
     /**
     * Atributo que representa la id del usuario
     */
    protected Long id;
    /**
     * Atributo que modela el login del cliente
     */
    protected String login;
    
    //CONSTRUCTOR
    /**
     * genera un usuario
     */
    public UsuarioDTO()
    {
        
    }
    public UsuarioDTO(EmpleadoEntity entity){
        if(entity!= null)
        {
        nombre = entity.getNombre();
        cedula = entity.getCedula();
        fechaIngreso = entity.getFechaIngreso();
        calificacion = entity.getCalificacion();
        id = entity.getId();
        login = entity.getLogin();
        }
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
    public Date getFechaIngreso() {
        return fechaIngreso;
    }
    /**
     * asigna la fecha de ingreso
     * @param fechaingreso llega la fecha de ingreso que se le asignara al usuario 
     */
    public void setFechaIngreso(Date fechaingreso) {
        this.fechaIngreso = fechaingreso;
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
    public void setId(Long  id) {
        this.id = id;
    }
    public UsuarioEntity toEntity()
    {
        //completar
        return null;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
}
