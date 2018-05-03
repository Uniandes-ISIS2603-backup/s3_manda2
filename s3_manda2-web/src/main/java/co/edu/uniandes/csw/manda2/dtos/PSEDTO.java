/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

import co.edu.uniandes.csw.manda2.entities.PSEEntity;

/**
 * PSEDTO Objeto de transferencia de datos de Pses. Los DTO contienen las
 * representaciones de los JSON que se transfieren entre el cliente y el
 * servidor, ademas hereda la clase (@link MedioPagoDTO), dirijase a ella para mas
 * informacion
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "nombreCliente": string,
 *      "id": number,
 *      "linkPse": string
 *   }
 * </pre>
 * Por ejemplo un pse se representa asi:<br>
 * 
 * <pre>
 * 
 *   {
 *      "nombreCliente": "carlos bello",
 *      "id": 01234566789,
 *      "linkPse": "https://www.pse.com.co/inicio"
 *   }
 *
 * </pre>
 *
 * @author na.caceres
 */
public class PSEDTO extends MedioPagoDTO {
    //Atributos
    /**
     * Atributo que representa el link correspondiente a la transaccion.
     */
    private String linkPse;
    //Constructor
    /**
     * Constructor por defecto
    */
    public PSEDTO(){
       
    }
    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param pse: Es la entidad que se va a convertir a DTO
     */
    public PSEDTO(PSEEntity pse) {
        super();
        if(pse!= null)
        {
        this.id = pse.getId();
        this.nombreCliente = pse.getNombreCliente();
        this.linkPse = pse.getLinkPse();
        }

    }
    
    //Metodos
    /**
     * @return the linkPse
     */
    public String getLinkPse() {
        return linkPse;
    }

    /**
     * @param linkPse the linkPse to set
     */
    public void setLinkPse(String linkPse) {
        this.linkPse = linkPse;
    }

    /**
     * Convertir DTO a Entity
     *
     * @return Un Entity con los valores del DTO
     */
    @Override
    public PSEEntity toEntity() {
        PSEEntity entity = new PSEEntity();
        entity.setId(this.id);
        entity.setNombreCliente(this.nombreCliente);
        entity.setLinkPse(this.linkPse);
        return entity;
    }  
}
