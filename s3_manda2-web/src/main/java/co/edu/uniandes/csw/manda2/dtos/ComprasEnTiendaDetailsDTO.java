/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

import co.edu.uniandes.csw.manda2.entities.ArticuloEntity;
import co.edu.uniandes.csw.manda2.entities.ComprasEnTiendaEntity;
import java.io.Serializable;
import java.util.ArrayList;
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
/**
     * Pago asociado al servicio.
     */
    private PagoDTO pago;
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
    
    public ComprasEnTiendaDetailsDTO(){
            super ();
    }

    
    public ComprasEnTiendaDetailsDTO(ComprasEnTiendaEntity entity){
    super(entity);
        if (entity != null){
            if(entity.getArticulo()!= null){
                this.articulo = new ArrayList();
                for (ArticuloEntity articuloEntity: entity.getArticulo()){
                    articulo.add(new ArticuloDTO (articuloEntity));
                }
            }
            if (entity.getCliente() != null) {
                this.cliente = new ClienteDTO(entity.getCliente());
            }
            if (entity.getEmpleado() != null) {
                this.empleado = new EmpleadoDTO(entity.getEmpleado());
            }
            if(entity.getPago()!= null)
            {
                this.pago = new PagoDTO (entity.getPago());
            }
        }
    }

            
    public List<ArticuloDTO> getArticulo() {
        return articulo;
    }

    public void setArticulo(List<ArticuloDTO> articulo) {
        this.articulo = articulo;
    }

    public PagoDTO getPago() {
        return pago;
    }

    public void setPago(PagoDTO pago) {
        this.pago = pago;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public EmpleadoDTO getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoDTO empleado) {
        this.empleado = empleado;
    }
    
     @Override
    public ComprasEnTiendaEntity toEntity() {
        ComprasEnTiendaEntity entity = new ComprasEnTiendaEntity();
        
        
         if (articulo != null) {
            List<ArticuloEntity> articuloEntity = new ArrayList();
            for (ArticuloDTO dtoArticulo : articulo) {
                articuloEntity.add(dtoArticulo.toEntity());
            }
            entity.setArticulo(articuloEntity);
         }
         if (empleado != null) {
            entity.setEmpleado(empleado.toEntity());
        }
        if (cliente != null) {
            entity.setCliente(cliente.toEntity());
        }
        if (pago != null) {
            entity.setPago(pago.toEntity());
        }
        
        return entity;
   
 
    }
    
    
   
}
