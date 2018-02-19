/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

/**
 * BilleteraDTO Objeto de transferencia de datos de Billeteras. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "saldo": double,
 *      "puntosFidelidad": integer
 *   }
 * </pre>
 * Por ejemplo una billetera se representa asi:<br>
 * 
 * <pre>
 * 
 *   {
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
    
     /**
     * Crea una billetera.
     * @param saldo saldo en la billetera
     * @param puntosFidelidad puntos de fidelidad acumulados
     */
    public BilleteraDTO(Double saldo, Integer puntosFidelidad){
        this.puntosDeFidelidad = puntosFidelidad;
        this.saldo = saldo;
        
    }
    /**
     * Constructor por defecto
     */
    public BilleteraDTO(){
     this(0D,0);
    
    }
    /**
     * Retorna el saldo en la billetera.
     * @return saldo en la billetera.
     */
    
    public Double getSaldo(){
        return saldo;
    }
    /**
     * Establece el saldo en la billetera.
     * @param pSaldo.
     */
    public void setSaldo(double pSaldo){
        this.saldo = pSaldo;
    }
    /**
     * Retorna los puntos de fidelidad.
     * @return puntos de fidelidad.
     */
    public Integer getPuntosFidelidad(){
        return puntosDeFidelidad;
    }
    /**
     * Establece los puntos de fidelidad.
     * @param pPuntos puntos de fidelidad.
     */
    public void setPuntosFidelidad(Integer pPuntos){
        this.puntosDeFidelidad= puntosDeFidelidad + pPuntos;
    }
    
   
}
    