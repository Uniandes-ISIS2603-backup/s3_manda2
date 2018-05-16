/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.entities;


import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author dv.gonzalez10
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
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
    
    @OneToMany(mappedBy = "compraEnTienda",cascade = CascadeType.ALL, orphanRemoval = false)
    @PodamExclude
    @JoinColumn(nullable = true)
    private List<PagoEntity> pago;
    /**
     * Retorna los articulos de la compra
     * @return atiuclo(s) de la compra
     */
    public List<ArticuloEntity> getArticulo() {
        return articulo;
    }

    /**
     * Asigna los articulos a la compra
     * @param articulo 
     */
    public void setArticulo(List<ArticuloEntity> articulo) {
        this.articulo = articulo;
    }
    
    
    

    //Metodos
     /**
     * Retorna el pago asociado al servicio.
     * @return pago asociado al servicio.
     */
    public List<PagoEntity> getPago() {
        return pago;
    }

    /**
     * Asigna el pago al dado por parámetro
     * @param pago nuevo pago
     */
    public void setPago(List<PagoEntity> pago) {
        this.pago = pago;
    }
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

    public void setArticulo(ArticuloEntity articulo) {
        this.articulo =(List<ArticuloEntity>) articulo;
     }
    
    
    
}
