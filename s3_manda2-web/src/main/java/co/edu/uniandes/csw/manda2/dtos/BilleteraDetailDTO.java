/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

/**
 * Clase que extiende de {@link BilleteraDTO} para manejar la transformacion entre
 * los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido de la ciudad vaya a la documentacion de {@link BilleteraDTO}
 * @author m.moreno
 */
public class BilleteraDetailDTO extends BilleteraDTO {
    
    
    
    /**
     * Constructor de la billetera.
     * @param medioPago Medio de pago para realizar la transaccion
     * @param saldo saldo disponible en billetera
     * @param puntosFidelidad puntos acumulados en billetera
     */
    
    public BilleteraDetailDTO(()
    {
        
    }
    
    
    /**
     * Medio de pago para realizar la transaccion
     */
    private MedioPagoDTO medioPago;
    
     /**
     * Retorna el medio de pago.
     * @return Medio de pago con el que se realizara la transaccion.
     */
    public MedioPagoDTO getMedioPago(){
        return medioPago;
    }
    /**
     * Asigna el medio de pago con el que se realizara la transaccion.
     * @param pMedioPago con el que se realizara la transaccion.
     */
    public void setMedioPago(MedioPagoDTO pMedioPago){
        this.medioPago = pMedioPago;
    }
    
}
