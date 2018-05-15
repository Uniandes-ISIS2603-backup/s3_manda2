/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

import co.edu.uniandes.csw.manda2.entities.MedioPagoEntity;

/**
 * * MedioPagoDTO Objeto de transferencia de datos de Medio Pago. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": Long,
 *      "nombreCliente": string
 *   }
 * </pre>
 * Por ejemplo una ciudad se representa asi:<br>
 * 
 * <pre>
 * 
 *   {
 *      "id": 91852,
 *      "nombreCliente": "Pepito Perez"
 *   }
 *
 * </pre>
 * @author m.moreno
 */
public class MedioPagoDTO {
    
    
    /**
     * Indica el id de medio pago.
     */
    protected Long id;
    /**
     * Indica el nombre del cliente que realiza pago.
     */
    protected String nombreCliente;
    
    public MedioPagoDTO(){
        
    }
    
     /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param entity: Es la entidad que se va a convertir a DTO
     */
    public MedioPagoDTO(MedioPagoEntity entity)
    {
        if(entity != null){
            this.id = entity.getId();
            this.nombreCliente= entity.getNombreCliente();
            
        }
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
     public Long getId()
    {
        return id;
    }
    /**
     * Establece el nombre del cliente.
     * @param id id
     */
    public void setId(Long id){
        this.id = id;
    }
    public MedioPagoEntity toEntity()
    {
        MedioPagoEntity medioPago = new MedioPagoEntity();
        medioPago.setId(this.id);
        medioPago.setNombreCliente(this.nombreCliente);
        return medioPago;
    }
}
