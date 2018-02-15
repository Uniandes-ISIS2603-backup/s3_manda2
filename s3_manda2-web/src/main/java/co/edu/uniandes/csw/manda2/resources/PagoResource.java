/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.resources;

import co.edu.uniandes.csw.manda2.dtos.PagoDetailDTO;
import java.util.List;
import javax.ws.rs.*;
import java.util.ArrayList;

/**
 *
 ** <pre>Clase que implementa el recurso "pagos".
 * URL: /api/pagos
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "pagos".</i>
 *
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (pagos). 
 * </pre>
 * @author m.moreno
 */

@Path("pagos")
@Produces("application/json")
@Consumes("application/json")

public class PagoResource {
    
    
    /**
     * <h1>POST /api/pagos : Crear un pago.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link PagoDetailDTO}.
     * 
     * Crea un nuevo pago con la informacion que se recibe en el cuerpo 
     * de la petición y se regresa un objeto identico con un id auto-generado 
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó un pago .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe el pago.
     * </code>
     * </pre>
     * @param pago {@link PagoDetailDTO} - El pago que se desea guardar.
     * @return JSON {@link PagoDetailDTO}  - El pago guardado con el atributo id autogenerado.
     */
    @POST
    public PagoDetailDTO createPago (PagoDetailDTO pago){
        return null;
    }
    
    
     /**
     * <h1>GET /api/pagos : Obtener todos los pagos.</h1>
     * 
     * <pre>Busca y devuelve todos los pagos que existen en la aplicación.
     * 
     * Códigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los pagos de de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link PagoDetailDTO} - Los pagos encontrados en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<PagoDetailDTO> getPagos(){
        return new ArrayList<>();
    }
    
    
     /**
     * <h1>GET /api/pagos/{id} : Obtener pagos por id.</h1>
     * 
     * <pre>Busca ek pago con el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el pago correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un pago con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del pago que se está buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link PagoDetailDTO} - El pago buscado
     */
    @GET
    @Path("{id: \\d+}")
    public PagoDetailDTO getPagoId(@PathParam("id") Long id){
        return null;
    }
    
    /**
     * <h1>PUT /api/pagos/{id} : Actualizar pago con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link PagoDetailDTO}.
     * 
     * Actualiza el pago con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza el pago con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un pago con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del pago que se desea actualizar.Este debe ser una cadena de dígitos.
     * @param pago {@link PagoDetailDTO} El pago que se desea guardar.
     * @return JSON {@link PagoDetailDTO} - El pago guardado.
     */ 
    @PUT 
    @Path("{id: \\d+}")
    public PagoDetailDTO updatePago(@PathParam("id") long id, PagoDetailDTO pago){
        return null;
    }
    
    
    /**
     * <h1>DELETE /api/pagos/{id} : Borrar pago por id.</h1>
     * 
     * <pre>Borra el pago con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina el pago correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un pago con el id dado.
     * </code>
     * </pre>
     * @param id Identificador del pago que se desea borrar. Este debe ser una cadena de dígitos.
     */
    
    @DELETE
    @Path("{id : \\d+}")
    public void eliminarPago(@PathParam("id") long id)
    {
    }
}
