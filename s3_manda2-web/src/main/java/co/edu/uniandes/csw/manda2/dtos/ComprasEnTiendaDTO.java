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
 *
 * Clase que representa el servicio de compras en tienda
 *
 * ComprasEnTiendaDTO. Los DTO contienen las representaciones de los JSON que se
 * transfieren entre el cliente y el servidor.
 *
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "costoDeTransporte": Double,
 *      "pago": PagoDTO,
 *      "cliente": ClienteDTO,
 *      "empleado": Empleado DTO,
 *      "id": Long,
 *      "nombre": String,
 *      "costo": Double,
 *      "puntoDeEncuentro": String,
 *      "puntoDeRealizacion": String,
 *      "exitoDiligencia": Boolean,
 *      "calification": Double,
 *      "descripcion": String,
 * }
 * </pre> Por ejemplo un servico de tipo Compras ent tienda se presenta asi :
 * <br>
 * </pre> { "costoDeTransporte": 10.000, "pago": PagoDTO, "cliente": pedro,
 * "empleado": Empleado1, "id": 345, "nombre": compra1, "costo": 30.000,
 * "puntoDeEncuentro":calle 44, "puntoDeRealizacion": Exito , "exitoDiligencia":
 * true, "calification": 5, "descripcion": estuvo bien , }
 *
 * </pre>
 *
 * @author dv.gonzalez10
 */
public class ComprasEnTiendaDTO extends ServicioDetailDTO implements Serializable {

    //Atributos
    /*
    *El costo del transporte del servicio
     */
    private Double costoDeTransporte;

    private List<ArticuloDTO> articulo;
    //TODO: DONE  Revisar por qué articulo extiende de 
    // ComprasenTienda y ComprasenTienda tiene un atributo dela clase articulo

    public ComprasEnTiendaDTO() {
        this(0D, null, null, null, 0L, "", 0D, "", "", false, 0D, "");
    }

    /**
     * Constructor
     *
     * @param costoDeTransporte costo relacionado con le costo del transporte
     * @param pago el pago que el cliente realiza por el servicio
     * @param cliente el cliente que obtiene el servicio
     * @param empleado empleado que realiza el servicio
     * @param id id del servicio
     * @param nombre nombre del servicio
     * @param costo costo del servicio
     * @param puntoDeEncuentro punto de encuentro del cliente y empleado
     * @param puntoDeRealizacion punto de realizacion del servicio
     * @param exitoDiligencia indica si la diligencia tuvo o no éxito
     * @param calificacion calificación del servicio.
     * @param descripcion descripción del servicio.
     */
    public ComprasEnTiendaDTO(Double costoDeTransporte, PagoDTO pago, ClienteDTO cliente, EmpleadoDTO empleado, Long id, String nombre, Double costo, String puntoDeEncuentro, String puntoDeRealizacion, Boolean exitoDiligencia, Double calificacion, String descripcion) {
        //super(pago, cliente, empleado, id, nombre, costo, puntoDeEncuentro, puntoDeRealizacion, exitoDiligencia, calificacion, descripcion);
        this.costoDeTransporte = costoDeTransporte;
    }

    public ComprasEnTiendaDTO(ComprasEnTiendaEntity entityServicio) {

        super();
        if (entityServicio != null) {
            this.id = entityServicio.getId();
            this.costoDeTransporte = entityServicio.getCostoDeTransporte();
        }
    }

    

    //METODOS
    /**
     * Retorna el valor asociado al transporte del servicio
     *
     * @return costoDeTransporte
     */
    public Double getCostoDeTransporte() {
        return costoDeTransporte;
    }

    /**
     * Asigna el valor del costo del transporte
     *
     * @param costoDeTransporte valor del transporte a modificar
     */
    public void setCostoDeTransporte(Double costoDeTransporte) {
        this.costoDeTransporte = costoDeTransporte;
    }

    public List<ArticuloDTO> getArticulo() {
        return articulo;
    }

    public void setArticulo(List<ArticuloDTO> articulo) {
        this.articulo = articulo;
    }

    
    /**
     * COnvierte el DTO en entity
     *
     * @return
     */
    @Override
    public ComprasEnTiendaEntity toEntity() {
        ComprasEnTiendaEntity entity = new ComprasEnTiendaEntity();
        ArrayList aentity = new ArrayList();
        
         
        entity.setCostoDeTransporte(costoDeTransporte);
        //TODO:DONE Esto no puede ser un cast a List<ArticuloEntity>
        // articulo es de tipo ArticuloEntity quien debe tener su propio toEntity
        
       for (ArticuloDTO articulo : articulo){
           aentity.add(articulo.toEntity());
       }
        entity.setArticulo(aentity);
        return entity;
    }
}
