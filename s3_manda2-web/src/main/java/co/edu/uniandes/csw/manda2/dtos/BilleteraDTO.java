/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

import co.edu.uniandes.csw.manda2.entities.BilleteraEntity;

/**
 * BilleteraDTO Objeto de transferencia de datos de Billeteras. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": Long,
 *      "saldo": double,
 *      "puntosFidelidad": integer
 *   }
 * </pre>
 * Por ejemplo una billetera se representa asi:<br>
 * 
 * <pre>
 * 
 *   {
 *      "id": 12345,
 *      "saldo": 37000,
 *      "puntosFidelidad": "100"
 *   }
 *
 * </pre>
 * @author m.moreno
 */
public class BilleteraDTO {
    
    /**
     * Indica el saldo disponible en la billetera.
     */
    private Double saldo;
    /**
     * Indica los puntos de fidelidad acumulados.
     */
    private Integer puntosDeFidelidad;
    
    private Long id;
    
     /**
     * Crea una billetera
     */
    public BilleteraDTO(){
        //Cosntructor vacío.
    }
    
     /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param entity: Es la entidad que se va a convertir a DTO
     */
    public BilleteraDTO(BilleteraEntity entity)
    {
        if(entity != null){
            this.id = entity.getId();
            this.puntosDeFidelidad = entity.getPuntosFidelidad();
            this.saldo = entity.getSaldo();
            
        }
    }
    
    /**
     * Retorna el id de la billetera.
     * @return id de la billetera.
     */
    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Integer getPuntosDeFidelidad() {
        return puntosDeFidelidad;
    }

    public void setPuntosDeFidelidad(Integer puntosDeFidelidad) {
        this.puntosDeFidelidad = puntosDeFidelidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Convertir DTO a Entity
     *
     * @return Un Entity con los valores del DTO
     */
    public BilleteraEntity toEntity() {
        BilleteraEntity billetera = new BilleteraEntity();
        billetera.setId(this.id);
        billetera.setPuntosFidelidad(this.puntosDeFidelidad);
        billetera.setSaldo(this.saldo);
        return billetera;
    }
    
   
}
    