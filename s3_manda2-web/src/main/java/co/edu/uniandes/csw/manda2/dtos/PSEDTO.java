/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

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
 *      "linkPSE": string
 *   }
 * </pre>
 * Por ejemplo un pse se representa asi:<br>
 * 
 * <pre>
 * 
 *   {
 *      "nombreCliente": "carlos bello",
 *      "id": 01234566789,
 *      "linkPSE": "https://www.pse.com.co/inicio"
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
    
    public PSEDTO(){
       
    }
    //Constructor
    /**
     * Constructor por defecto
     * @param pLinkPse
     * @param id
     * @param nombreCliente
    */
   public PSEDTO(String pLinkPse, Long id, String nombreCliente)
   {
       super(id, nombreCliente);
       linkPse = pLinkPse;
        
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

    
    
    
}
