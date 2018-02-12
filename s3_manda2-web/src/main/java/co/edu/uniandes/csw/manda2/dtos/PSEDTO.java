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
public class PSEDTO {
    //Parametros
    
    private String linkPse;
    
    private long id;
    //Constructor
    
    public PSEDTO(long pId , String pLinkPse)
    {
        id= pId;
        linkPse = pLinkPse;
        //super();
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
    
    
}
