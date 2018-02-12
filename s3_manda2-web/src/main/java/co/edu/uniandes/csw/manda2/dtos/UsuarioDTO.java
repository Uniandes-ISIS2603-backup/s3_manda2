/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

import java.util.Date;

/**
 *
 * @author n.bello
 */
public class Usuario  {
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
    
    //CONSTRUCTOR
 
    //METODOS
    /**
     * retorna el nombre del ususario
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * asigna el nombre que llega por parametro
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * retorna la cedula del usuario
     * @return cedula
     */
    public String getCedula() {
        return cedula;
    }
    /**
     * asigna la cedula que llega por parametro
     * @param cedula 
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    /**
     * retorna la fecha de ingreso
     * @return fechaingreso
     */
    public Date getFechaingreso() {
        return fechaingreso;
    }
    /**
     * asigna la fecha de ingreso
     * @param fechaingreso 
     */
    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }
    /**
     * retorna la calificacion del usuario
     * @return calificacion
     */
    public Double getCalificacion() {
        return calificacion;
    }
    /**
     * asigna la calificacion que llega por parametro
     * @param calificacion 
     */
    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }
    
}
