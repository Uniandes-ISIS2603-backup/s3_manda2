/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

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
    private int numeroTarjeta;
    
    public TarjetaCreditoDTO(){
        this(0,0L,"");
    }
    //Constructor
    /**
     * constructor por defecto.
     * @param pNumeroTarjeta
     * @param id
     * @param nombreCliente 
     */
    public TarjetaCreditoDTO(Integer pNumeroTarjeta, Long id,  String nombreCliente)
    {
        super(id, nombreCliente);
        numeroTarjeta = pNumeroTarjeta;
        //super();
    }
    //Metodos

    /**
     * @return the numeroTarjeta
     */
    public Integer getNumeroTarjeta() {
        return numeroTarjeta;
    }

    /**
     * @param numeroTarjeta the numeroTarjeta to set
     */
    public void setNumeroTarjeta(Integer numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }
    
}
