/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

/**
 *
 * @author m.moreno
 */
public class BilleteraDetailDTO extends BilleteraDTO {
    
    
    /**
     * Medio de pago para realizar la transaccion
     */
    private MedioPagoDTO medioPago;
    
     /**
     * Retorna el medio de pago.
     * @return Medio de pago.
     */
    public MedioPagoDTO getMedioPago(){
        return medioPago;
    }
    /**
     * Asigna el medio de pago con el que se realizara la transaccion.
     * @param pMedioPago.
     */
    public void setMedioPago(MedioPagoDTO pMedioPago){
        this.medioPago = pMedioPago;
    }
    
}
