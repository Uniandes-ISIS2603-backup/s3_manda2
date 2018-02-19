/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.resources;
import co.edu.uniandes.csw.manda2.dtos.MedioPagoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.*;

/**
 * <pre>Clase que implementa el recurso "mediospago".
 * URL: /api/mediospago
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "mediospago".</i>
 *
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio). 
 * </pre>
 * @author m.moreno
 */

 @Path("mediospago")
@Produces("application/json")
@Consumes("application/json")
public class MedioPagoResource {
    
    

        /**
     * <h1>GET /api/mediospago/{id} : Obtener ciudad por id.</h1>
     * 
     * <pre>Busca el medio de pago con el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el medio de pago correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un medio de pago con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del medio de pago que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link MedioPagoDTO} - el medio de pago buscado
     */
    @GET
    @Path("{id: \\d+}")
    public MedioPagoDTO getMedioPago(@PathParam("id") long id){
        return null;
    }
    
      /**
     * <h1>GET /api/mediospago : Obtener todos los medios de pago.</h1>
     * 
     * <pre>Busca y devuelve todos los medios de pago que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los medios de pago de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link MedioPagoDTO} - Los medios de pago encontradas en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<MedioPagoDTO> getMediosPago(){
        return new ArrayList<>();
    }
    
      /**
     * <h1>POST /api/mediospago : Crear un medio de pago.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link MedioPagoDTO}.
     * 
     * Crea un nuevo medio de pago con la informacion que se recibe en el cuerpo 
     * de la petición y se regresa un objeto identico con un id auto-generado 
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó el nuevo medio de pago .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe el medio de pago.
     * </code>
     * </pre>
     * @param medioPago el medio de pago
     * @return JSON {@link MedioPagoDTO}  - El medio de pago guardado con el atributo id autogenerado.
     */
    @POST
    public MedioPagoDTO createMedioPago(MedioPagoDTO medioPago){
        return null;
    }
    
    
        /**
     * <h1>PUT /api/mediospago/{id} : Actualizar el medio de pago con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link MedioPagoDTO}.
     * 
     * Actualiza el medio de pago con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza el medio de pago con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un medio de pago con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del medio de pagque se desea actualizar.Este debe ser una cadena de dígitos.
     * @param medioPago {@link MedioPagoDTO} el medio de pago que se desea guardar.
     * @return JSON {@link MedioPagoDTO} - el medio de pago  guardado.
     */
    @PUT
    @Path("{id : \\d+}")
    public MedioPagoDTO updateMedioPago(@PathParam("id") long id, MedioPagoDTO medioPago){
        return null;
    }
    
    
       /**
     * <h1>DELETE /api/mediospago/{id} : Borrar medio de pago id.</h1>
     * 
     * <pre>Borra medio de pago con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina medio de pago correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un medio de pago con el id dado.
     * </code>
     * </pre>
     * @param id Identificador del medio de pago que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id : \\d+}")
    public void deleteMedioPago(@PathParam("id") long id){
        
    }
 
}