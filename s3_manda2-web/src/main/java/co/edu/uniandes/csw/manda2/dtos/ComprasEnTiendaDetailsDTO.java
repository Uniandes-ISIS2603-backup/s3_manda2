/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

import java.io.Serializable;
import java.util.List;

/**
 ** Clase que extiende de {@link ComprasEnTiendaDTO} para manejar la transformacion entre
 * los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido de la ciudad vaya a la documentacion de {@link ComprasEnTiendaDTO}
 * @author dv.gonzalez10
 */
public class ComprasEnTiendaDetailsDTO extends ComprasEnTiendaDTO implements Serializable{
    //atributos
    /**
     * 
     * 
     * 
    *Articulo que se quiere comprar en tienda
    */
    private List<ArticuloDTO> articulo;

   //CONSTRUCTOR
   

    /**
     * Metodo constructor
     * @param articulo articulo que el cliente desea obtener
     * @param costoDeTransporte costo relacionado al transporte del servicio 
     * @param pago el pago que el cliente realiza por el servicio 
     * @param cliente el cliente que obtiene el servicio 
     * @param empleado empleado que realiza el servicio
     * @param id id del servicio
     * @param nombre noombre del servicio
     * @param costo costo del servicio
     * @param puntoDeEncuentro punto de encuentro del cliente y empleado
     * @param puntoDeRealizacion punto de realizacion del servicio
     * @param exitoDiligencia indica si la diligencia tuvo o no éxito
     * @param calificacion calificación del servicio.
     * @param descripcion descripción del servicio.
     */
    public ComprasEnTiendaDetailsDTO(List<ArticuloDTO>  articulo, Double costoDeTransporte, PagoDTO pago, ClienteDTO cliente, EmpleadoDTO empleado, Long id, String nombre, Double costo, String puntoDeEncuentro, String puntoDeRealizacion, Boolean exitoDiligencia, Double calificacion, String descripcion) {
        super(costoDeTransporte, pago, cliente, empleado, id, nombre, costo, puntoDeEncuentro, puntoDeRealizacion, exitoDiligencia, calificacion, descripcion);
        this.articulo = articulo;
    }

    public List<ArticuloDTO> getArticulo() {
        return articulo;
    }

    public void setArticulo(List<ArticuloDTO> articulo) {
        this.articulo = articulo;
    }
    
    
  /**
     *Retorna el articulo 
     * @return costoDeTransporte
     */
    
    

    /**
     * Asigna el articulo 
     * @param articulo articulo de la compra
     */
   
    
    
   
}
