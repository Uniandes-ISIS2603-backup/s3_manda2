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
public class ReclamoDTO {
    //ATRIBUTOS
    /**
     * Atributo que representa el mensaje del reclamo
     */
    private String mensaje;
    /**
     * Atributo qie representa el numero del reclamo
     */
    private Integer numero;
    /**
     * Atributo qie representa el id del reclamo
     **/
    private Long id;
    //CONSTRUCTOR
    /**
     * Se genera un reclamo
     * 
     */
    public ReclamoDTO()
    {
      mensaje = "";
      numero = 0;
      id = new Long(0);
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
     * @param mensaje 
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    /**
     * retorna el numero del mansahe
     * @return numero
     */
    public Integer getNumero() {
        return numero;
    }
    /**
     * se asigna el numero al reclamo
     * @param numero 
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
     /**
     * retorna el numero del mansahe
     * @return numero
     */
    public Long getId() {
        return id;
    }
    /**
     * se asigna el numero al reclamo
     * @param numero 
     */
    public void setNumero(Long id) {
        this.id = id;
    }
}
