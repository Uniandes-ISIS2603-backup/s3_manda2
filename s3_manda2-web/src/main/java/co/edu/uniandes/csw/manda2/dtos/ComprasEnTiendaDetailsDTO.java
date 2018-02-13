/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

/**
 *
 * @author dv.gonzalez10
 */
public class ComprasEnTiendaDetailsDTO {
    //atributos
    /**
    *Articulo que se quiere comprar en tienda
    */
    private ArticuloDTO articulo;

    public ComprasEnTiendaDetailsDTO(ArticuloDTO articulo) {
        this.articulo = articulo;
    }

    public ArticuloDTO getArticulo() {
        return articulo;
    }

    public void setArticulo(ArticuloDTO articulo) {
        this.articulo = articulo;
    }
    
    
   
}
