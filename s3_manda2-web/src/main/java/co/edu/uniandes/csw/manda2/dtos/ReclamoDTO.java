/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

import co.edu.uniandes.csw.manda2.entities.ReclamoEntity;

/**
 * 
 * Clase que representa los reclamos que se hacen.
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "mensaje": string, 
 *      "numero": number,
 *      "id": number
 *   }
 * </pre>
 * Por ejemplo de un reclamo se representa así:<br>
 * 
 * <pre>
 *   {
 *      "mensaje": "El servicio se demoro mucho", 
 *      "numero": 1,
 *      "id": 1
 *   }
 * </pre>
 * @author n.bello
 */
public class ReclamoDTO {
    //ATRIBUTOS
    /**
     * Atributo que representa el mensaje del reclamo
     */
    protected String mensaje;
    /**
     * Atributo qie representa el numero del reclamo
     */
    protected Integer numero;
    /**
     * Atributo qie representa el id del reclamo
     **/
    protected Long id;
    //CONSTRUCTOR
    /**
     * Se genera un reclamo
     */
    public ReclamoDTO()
    {
    }
    public ReclamoDTO (ReclamoEntity entity)
    {
       mensaje = entity.getMensaje();
       numero = entity.getNumero();
       id = entity.getId();
    }
    //METODOS
    /**
     * retorna el mensaje del reclamo
     * @return mensaje
     */
    public String getMensaje() {
        return mensaje;
    }
    /**
     * Asigna un mensaje al reclamo
     * @param mensaje llega el mensaje que se quiere asignar
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    /**
     * retorna el numero del reclamo
     * @return numero el numero del reclamo
     */
    public Integer getNumero() {
        return numero;
    }
    /**
     * se asigna el numero al reclamo
     * @param numero el numero del reclamo
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
     /**
     * retorna el id del reclamo
     * @return numero del id
     */
    public Long getId() {
        return id;
    }
    /**
     * se asigna el numero al reclamo
     * @param id el id que se le asigna al reclamo
     */
    public void setId(Long id) {
        this.id = id;
    }

    public ReclamoEntity toEntity() {
        ReclamoEntity entity = new ReclamoEntity();
        entity.setId(id);
        entity.setMensaje(mensaje);
        entity.setNumero(numero);
        return entity;
    }
}
