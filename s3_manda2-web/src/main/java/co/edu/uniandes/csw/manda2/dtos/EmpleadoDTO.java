/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

import co.edu.uniandes.csw.manda2.entities.EmpleadoEntity;

/**
 * Clase que representa el empleado.
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "nombre": string, 
 *      "cedula": string,
 *      "fechaingreso": date,
 *      "calificacion": double,
 *      "id": number,
 *      "identificacion": string,
 *      "foto": string,
 *      "eps: string
 *   }
 * </pre>
 * Por ejemplo un PayPal se representa así:<br>
 * 
 * <pre>
 *   {
 *      "nombre": "nicolas_caceres", 
 *      "cedula": "1014563321",
 *      "fechaingreso": date,
 *      "calificacion": 5.0,
 *      "id": 001,
 *      "identificacion": "nicolascaceres001",
 *      "foto": "nicolascaceres.jpg",
 *      "eps: "millossaludprepagada"
 *   }
 * </pre>
 * @author n.bello
 */
public class EmpleadoDTO extends UsuarioDTO{
    //ATRIBUTOS
    /**
     * Atributo que identifica a un empleado
     */
    public String identificacion;
    /**
     * Atributo que muestra la foto del empleado
     */
    public String  foto;
    /**
     * Atributo quemuestra la EPS a la que esta afiliado el empleado
     */
    public String EPS;
    //CONSTRUCTOR
    /**
     * Genera un empleado
     *
     */
    public EmpleadoDTO()
    {
       
    }
    
    public EmpleadoDTO(EmpleadoEntity entity){
        super(entity);
        if(entity != null){
        identificacion = entity.getIdentificacion();
        foto = entity.getFoto();
        EPS = entity.getEPS();
        this.calificacion = entity.getCalificacion();
        this.login = entity.getLogin();
        }
    }
    //METODOS
     /**
     * retorna la identificacion del em pleado
     * @return identificacion del empleado
     */
    public String getIdentificacion() {
        return identificacion;
    }
    /**
     * asigna la identificacion al empleado 
     * @param identificacion Llega la identificacion del empleado
     **/
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    /**
     * retorna la foto del empleado
     * @return foto del empleado
     */
    public String getFoto() {
        return foto;
    }
     /**
     * asigna la foto al empleado 
     * @param foto llega la foto que se le asigna al empleado
     **/
    public void setFoto(String foto) {
        this.foto = foto;
    }
    /**
     * retorna la EPS del empleado
     * @return EPS retorna la EPS a la que esta afiliado el empleado
     */
    public String getEPS() {
        return EPS;
    }
     /**
     * asigna la EPS al empleado 
     * @param EPS Llega la EPS a la que esta afiliado el empleado
     **/
    public void setEPS(String EPS) {
        this.EPS = EPS;
    }
    @Override
    public EmpleadoEntity toEntity(){
        EmpleadoEntity entity = new EmpleadoEntity();
        entity.setId(this.id);
        entity.setNombre(this.nombre);
        entity.setCedula(this.cedula);
        entity.setFechaIngreso(this.fechaIngreso);
        entity.setIdentificacion(this.identificacion);
        entity.setEPS(this.EPS);
        entity.setFoto(this.foto);
        entity.setCalificacion(this.calificacion);
        entity.setLogin(this.login);
        return entity;
    }
}
