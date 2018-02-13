/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.resources;

import co.edu.uniandes.csw.manda2.dtos.VueltasConDemoraEnOficinaDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


/**
 ** <pre>Clase que implementa el recurso "vueltasConDemoraEnOficina".
 * URL: /api/vueltasConDemoraEnOficina
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "vueltasConDemoraEnOficina".</i>
 *
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio). 
 * </pre>
 * @author dv.gonzalez10
 */
@Path("vueltasConDemoraEnOficina")
@Produces("application/json")
@Consumes("application/json")
public class VueltasConDemoraEnOficinaResource {
    
    
    /**
     * <h1>GET /api/vueltasConDemoraEnOficina : Obtener todos las vueltasConDemoraEnOFicina.</h1>
     * 
     * <pre>Busca y devuelve todos las vueltasConDemoraEnOFicina que existen en la aplicación.
     * 
     * Códigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos las vueltasConDemoraEnOFicina de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link PayPalDTO} - Las vueltasConDemoraEnOFicina encontrados en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<VueltasConDemoraEnOficinaDTO> getVueltasConDemoraEnOficina(){
        return new ArrayList <> ();
    }
    
    /**
     * <h1>GET /api/vueltasConDemoraEnOficina/{id} : Obtener vueltasConDemoraEnOficina por id.</h1>
     * 
     * <pre>Busca la vueltasConDemoraEnOficina con el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve la vueltasConDemoraEnOficina correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un PayPal con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la vueltasConDemoraEnOficina que se está buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link VueltasConDemoraEnOficinaDTO} - La vueltasConDemoraEnOficina buscada
     */
    @GET
    @Path("{id : \\d+}")
    public VueltasConDemoraEnOficinaDTO getVueltaConDemoraEnOficina(@PathParam("id") long id){
        return null;
    }
    
    
    /**
     * <h1>POST /api/vueltasConDemoraEnOficina: Crear una vueltasConDemoraEnOficina.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link VueltasConDemoraEnOficinaDTO}.
     * 
     * Crea una nueva vueltasConDemoraEnOficina con la información que se recibe en el cuerpo de la petición
     * y se regresa un objeto idéntico con un id auto-generado por la base de datos.
     * 
     * Códigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó el nuevo VueltasConDemoraEnOficina.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe VueltasConDemoraEnOficina.
     * </code>
     * </pre>
     * @param vueltasConDemoraEnOficina {@link VueltasConDemoraEnOficinaDTO} - El VueltasConDemoraEnOficina que se desea guardar.
     * @return JSON {@link VueltasConDemoraEnOficinaDTO} - El vueltasConDemoraEnOficina guardado con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe el PayPal.
     */
    @POST
    public VueltasConDemoraEnOficinaDTO createVueltaConDemoraEnOficina( VueltasConDemoraEnOficinaDTO vueltaConDemoraEnOficina){
        return vueltaConDemoraEnOficina;
    }
    
    
    /**
     * <h1>PUT /api/paypals/{id} : Actualizar VueltasConDemoraEnOficina con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link VueltasConDemoraEnOficinaDTO }.
     * 
     * Actualiza vueltasConDemoraEnOficina con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza VueltasConDemoraEnOficina con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un VueltasConDemoraEnOficina con el id dado.
     * </code>
     * </pre>
     * @param id Identificador del vueltasConDemoraEnOficina que se desea actualizar. Este debe ser una cadena de dígitos.
     * @param VueltasConDemoraEnOficina  {@link VueltasConDemoraEnOficinaDTO}  VueltasConDemoraEnOficina  que se desea guardar.
     * @return JSON {@link VueltasConDemoraEnOficinaDTO} -  ueltasConDemoraEnOficina  guardado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar vueltasConDemoraEnOficina  porque ya existe uno con ese nombre.
     */
    @PUT
    @Path("{id : \\d+}")
    public VueltasConDemoraEnOficinaDTO  updateVueltaConDemoraEnOficina( @PathParam("id") long id, VueltasConDemoraEnOficinaDTO  vueltaConDemoraEnOficina ){
        return vueltaConDemoraEnOficina;

    }
    
    /**
     * <h1>DELETE /api/vueltasConDemoraEnOficina/{id} : Borrar VueltasConDemoraEnOficina por id.</h1>
     * 
     * <pre>Borra el VueltasConDemoraEnOficina con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina el VueltasConDemoraEnOficina correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un VueltasConDemoraEnOficina con el id dado.
     * </code>
     * </pre>
     * @param id Identificador de LA VueltasConDemoraEnOficina que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id : \\d+}")
    public void deleteVueltaConDemoraEnOficina( @PathParam("id") Long id ){
        
    }
    
}
