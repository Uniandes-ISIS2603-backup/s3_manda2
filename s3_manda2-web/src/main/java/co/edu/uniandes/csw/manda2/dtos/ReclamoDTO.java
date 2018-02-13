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
    //CONSTRUCTOR
    /**
     * Se genera un reclamo
     * @param pMensaje
     * @param pNumero 
     */
    public ReclamoDTO(String pMensaje,Integer pNumero)
    {
      mensaje = pMensaje;
      numero = pNumero;
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
    
}
