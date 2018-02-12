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
public class TarjetaCreditoDTO extends MedioPagoDTO {
    
    //Atributos
    private long id;
    
    private int numeroTarjeta;
    //Constructor
    public TarjetaCreditoDTO(long pId, int pNumeroTarjeta)
    {
        id = pId;
        numeroTarjeta = pNumeroTarjeta;
        //super();
    }
    //Metodos

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the numeroTarjeta
     */
    public int getNumeroTarjeta() {
        return numeroTarjeta;
    }

    /**
     * @param numeroTarjeta the numeroTarjeta to set
     */
    public void setNumeroTarjeta(int numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }
    
}
