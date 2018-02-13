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
public class BilleteraDTO {
    
    /**
     * Indica el saldo disponible en la billetera.
     */
    private double saldo;
    /**
     * Indica los puntos de fidelidad acumulados.
     */
    private Integer puntosDeFidelidad;
    
     /**
     * Crea una billetera.
     * @param saldo saldo en la billetera
     * @param puntosFidelidad puntos de fidelidad acumulados
     */
    
    public BilleteraDTO(double saldo, Integer puntosFidelidad){
        this.puntosDeFidelidad = puntosFidelidad;
        this.saldo = saldo;
    }
    
    /**
     * Retorna el saldo en la billetera.
     * @return saldo.
     */
    
    public double getSaldo(){
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
    