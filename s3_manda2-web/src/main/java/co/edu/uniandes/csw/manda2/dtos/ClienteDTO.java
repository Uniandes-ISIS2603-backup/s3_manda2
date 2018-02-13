/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

/**
 *
 * @author na.caceres
 */
public class ClienteDTO extends UsuarioDTO {
    
    //Atributos
    private boolean pagoAnticipado;
    
    private int horasDeServicioSemanal;
    //Constructor
    
    public ClienteDTO()
    {
        super();
        pagoAnticipado =false;
        horasDeServicioSemanal =0;
    }
    //Metodos

    /**
     * @return the pagoAnticipado
     */
    public boolean isPagoAnticipado() {
        return pagoAnticipado;
    }

    /**
     * @param pagoAnticipado the pagoAnticipado to set
     */
    public void setPagoAnticipado(boolean pagoAnticipado) {
        this.pagoAnticipado = pagoAnticipado;
    }

    /**
     * @return the horasDeServicioSemanal
     */
    public int getHorasDeServicioSemanal() {
        return horasDeServicioSemanal;
    }

    /**
     * @param horasDeServicioSemanal the horasDeServicioSemanal to set
     */
    public void setHorasDeServicioSemanal(int horasDeServicioSemanal) {
        this.horasDeServicioSemanal = horasDeServicioSemanal;
    }
    
}
