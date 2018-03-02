/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

import co.edu.uniandes.csw.manda2.entities.TarjetaCreditoEntity;

/**
 * TarjetaCreditoDTO Objeto de transferencia de datos de Tarjetas de cretito. Los DTO contienen las
 * representaciones de los JSON que se transfieren entre el cliente y el
 * servidor, ademas hereda la clase (@link MedioPagoDTO), dirijase a ella para mas
 * informacion
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "nombreCliente": string,
 *      "id": number,
 *      "numeroTarjeta": number
 *   }
 * </pre>
 * Por ejemplo una tarjeta de credito se representa asi:<br>
 * 
 * <pre>
 * 
 *   {
 *      "nombreCliente": "carlos bello",
 *      "id": 01234566789,
 *      "numeroTarjeta": 0123456987124568
 *   }
 *
 * </pre>
 *

 *
 * @author na.caceres
 */
public class TarjetaCreditoDTO extends MedioPagoDTO {
    
    //Atributos
    /**
     * Atributo que representa el numero de la tarjeta.
     */
    private String numeroTarjeta;
    
    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param tarjeta: Es la entidad que se va a convertir a DTO
     */
    public TarjetaCreditoDTO(TarjetaCreditoEntity tarjeta) {
        this.id = tarjeta.getId();
        this.nombreCliente = tarjeta.getNombreCliente();
        this.numeroTarjeta = tarjeta.getNumeroTarjeta();

    }
    //Constructor
    /**
     * constructor por defecto.
     */
    public TarjetaCreditoDTO()
    {
       
    }
    //Metodos

    /**
     * @return the numeroTarjeta
     */
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    /**
     * @param numeroTarjeta the numeroTarjeta to set
     */
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }
    /**
     * Convertir DTO a Entity
     *
     * @return Un Entity con los valores del DTO
     */
    public TarjetaCreditoEntity toEntity() {
        TarjetaCreditoEntity entity = new TarjetaCreditoEntity();
        entity.setId(this.id);
        entity.setNombreCliente(this.nombreCliente);
        entity.setNumeroTarjeta(this.numeroTarjeta);
        return entity;
    }
}
