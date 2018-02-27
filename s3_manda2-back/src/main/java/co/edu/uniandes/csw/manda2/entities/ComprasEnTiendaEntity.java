/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author dv.gonzalez10
 */
@Entity
public class ComprasEnTiendaEntity  extends ServicioEntity  implements Serializable{

    //Atributos    
     /*
    *El costo del transporte del servicio
    */
    private Double costoDeTransporte;
    
    @PodamExclude
    @OneToMany
    /*
    *Articulos
    */
    private List<ArticuloEntity>  articulo;
    
    
  
    

    //Metodos
    
     /**
     *Retorna el valor asociado al transporte del servicio
     * @return costoDeTransporte
     */
    public Double getCostoDeTransporte() {
        return costoDeTransporte;
    }
    
    
    /**
     * Asigna el valor del costo del transporte
     *  @param costoDeTransporte valor del transporte a modificar
     */
    public void setCostoDeTransporte(Double costoDeTransporte) {
        this.costoDeTransporte = costoDeTransporte;
    }
    
    
    
}
