/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

/**
 * * MedioPagoDTO Objeto de transferencia de datos de Medio Pago. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": long,
 *      "nombreCliente: string
 *   }
 * </pre>
 * Por ejemplo una ciudad se representa asi:<br>
 * 
 * <pre>
 * 
 *   {
 *      "id": 91852,
 *      "nombreCliente: "Pepito Perez"
 *   }
 *
 * </pre>
 * @author m.moreno
 */
public class MedioPagoDTO {
    
    
    /**
     * Indica el id de medio pago.
     */
    private long id;
    /**
     * Indica el nombre del cliente que realiza pago.
     */
    private String nombreCliente;
     /**
     * Constructor de un nuevo MedioPago.
     *  @param id id de medio
     * @param nombreCliente nombre del cliente que realiza pago.
     */
    public MedioPagoDTO(long id, String nombreCliente){
        this.id = id;
        this.nombreCliente = nombreCliente;
    }
    /**
     * Retorna el nombre el cliente.
     * @return nombre cliente
     */
    public String getNombreCliente()
    {
        return nombreCliente;
    }
    /**
     * Establece el nombre del cliente.
     * @param pNombre.
     */
    public void setNombreCliente(String pNombre){
        this.nombreCliente = pNombre;
    }
    
     /**
     * Retorna el id del medio de pago.
     * @return id de medio de pago.
     */
     public long getId()
    {
        return id;
    }
    /**
     * Establece el nombre del cliente.
     * @param pNombre.
     */
    public void setId(long id){
        this.id = id;
    }
}
