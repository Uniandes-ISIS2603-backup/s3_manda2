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
public class PSEDTO extends MedioPagoDTO {
    //Parametros
    
    private String linkPse;
    
    //Constructor
    
    public PSEDTO(String pLinkPse)
    {
        super();
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
