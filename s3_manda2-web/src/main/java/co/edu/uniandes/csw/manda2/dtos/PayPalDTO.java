/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

/**
 * Clase que representa el medio de pago de PayPal.
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": number, 
 *      "nombreCliente": string,
 *      "linkPayPal": string
 *   }
 * </pre>
 * Por ejemplo un PayPal se representa así:<br>
 * 
 * <pre>
 *   {
 *      "id": 19846, 
 *      "nombreCliente": "Juan Perez",
 *      "linkPayPal": "http://www.paypal.com/users/juanperez"
 *   }
 * </pre>
 * @author da.ramos
 */
public class PayPalDTO extends MedioPagoDTO{
    
     public PayPalDTO(){
        super();
    }
     
    public PayPalDTO(Long id, String linkPayPal, String nombreCliente) {
        super(id, nombreCliente);
        this.linkPayPal = linkPayPal;
    }
    
    /**
     * Link de PayPal.
     */
    private String linkPayPal;

    /**
     * Retorna el link de PayPal.
     * @return Link de PayPal.
     */
    public String getLinkPayPal() {
        return linkPayPal;
    }

    /**
     * Asigna el link de PayPal al dado por parámetro.
     * @param linkPayPal Nuevo link de PayPal.
     */
    public void setLinkPayPal(String linkPayPal) {
        this.linkPayPal = linkPayPal;
    }
}
