/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

import java.io.Serializable;

/**
 *
 * @author dv.gonzalez10
 */
public class ComprasEnTiendaDetailsDTO extends ComprasEnTiendaDTO implements Serializable{
    //atributos
    /**
    *Articulo que se quiere comprar en tienda
    */
    private ArticuloDTO articulo;

   //CONSTRUCTOR

    /**
     * Metodo constructor
     * @param articulo articulo que el cliente desea obtener
     * @param costoDeTransporte coso relacionado al transporte del servicio 
     * @param pago 
     * @param cliente
     * @param empleado
     * @param id id del servicio
     * @param nombre noombre del servicio
     * @param costo costo del servicio
     * @param puntoDeEncuentro punto de encuentro del cliente y empleado
     * @param puntoDeRealizacion punto de realizacion del servicio
     * @param exitoDiligencia indica si la diligencia tuvo o no éxito
     * @param calificacion calificación del servicio.
     * @param descripcion descripción del servicio.
     */
    public ComprasEnTiendaDetailsDTO(ArticuloDTO articulo, Double costoDeTransporte, PagoDTO pago, ClienteDTO cliente, EmpleadoDTO empleado, long id, String nombre, double costo, String puntoDeEncuentro, String puntoDeRealizacion, boolean exitoDiligencia, double calificacion, String descripcion) {
        super(costoDeTransporte, pago, cliente, empleado, id, nombre, costo, puntoDeEncuentro, puntoDeRealizacion, exitoDiligencia, calificacion, descripcion);
        this.articulo = articulo;
    }
    
    
  /**
     *Retorna el articulo 
     * @return costoDeTransporte
     */
    public ArticuloDTO getArticulo() {
        return articulo;
    }

    /**
     * Asigna el articulo 
     * @param articulo 
     */
    public void setArticulo(ArticuloDTO articulo) {
        this.articulo = articulo;
    }
    
    
   
}
