/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.resources;

import co.edu.uniandes.csw.manda2.dtos.EntregasDeDocumentosDTO;
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
 * URL: /api/entregasDeDocumentos
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "entregasDeDocumentos".</i>
 *
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio). 
 * </pre>
 * @author dv.gonzalez10
 */
@Path("entregasDeDocumentosResource")
@Produces("application/json")
@Consumes("application/json")
/**
 *
 * @author dv.gonzalez10
 */
public class EntregasDeDocumentosResource {
    
    
    /**
     * <h1>GET /api/entregasDeDocumentos : Obtener todos las entregasDeDocumentos.</h1>
     * 
     * <pre>Busca y devuelve todos las entregasDeDocumentos que existen en la aplicación.
     * 
     * Códigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos las entregasDeDocumentos de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link EntregasDeDocumentosDTO} - Las entregasDeDocumentos encontrados en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
     @GET
    public List<EntregasDeDocumentosDTO> getEntregasDeDocumentos(){
        return new ArrayList <> ();
    }
    
    /**
     * <h1>GET /api/entregasDeDocumentos/{id} : Obtener entregasDeDocumentos por id.</h1>
     * 
     * <pre>Busca la entregasDeDocumentos con el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve la entregasDeDocumentos correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un entregasDeDocumentos con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la entregasDeDocumentos que se está buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link entregasDeDocumentosDTO} - La entregasDeDocumentos buscada
     */
    @GET
    @Path("{id : \\d+}")
    public EntregasDeDocumentosDTO getEntregaDeDocumentos(@PathParam("id") long id){
        return null;
    }
     
    /**
     * <h1>POST /api/entregasDeDocumentos: Crear una entregasDeDocumentos.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link entregasDeDocumentos}.
     * 
     * Crea una nueva entregasDeDocumentos con la información que se recibe en el cuerpo de la petición
     * y se regresa un objeto idéntico con un id auto-generado por la base de datos.
     * 
     * Códigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó el nuevo entregasDeDocumentos.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe VueltasConDemoraEnOficina.
     * </code>
     * </pre>
     * @param entregasDeDocumentos {@link entregasDeDocumentos} - El entregasDeDocumentos que se desea guardar.
     * @return JSON {@link EntregasDeDocumentosDTO} - El entregasDeDocumentos guardado con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe el PayPal.
     */
     @POST
    public EntregasDeDocumentosDTO createEntregasDeDocumentos( EntregasDeDocumentosDTO entregasDeDocumentos){
        return entregasDeDocumentos;
    }
    /**
     * <h1>PUT /api/entregasDeDocumentos/{id} : Actualizar entregasDeDocumentos con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link EntregasDeDocumentosDTO }.
     * 
     * Actualiza entregasDeDocumentos con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza entregasDeDocumentos con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un entregasDeDocumentos con el id dado.
     * </code>
     * </pre>
     * @param id Identificador del vueltasConDemoraEnOficina que se desea actualizar. Este debe ser una cadena de dígitos.
     * @param entregasDeDocumentos  {@link EntregasDeDocumentosDTO}  entregasDeDocumentos  que se desea guardar.
     * @return JSON {@link entregasDeDocumentos} -  entregasDeDocumentos  guardado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar vueltasConDemoraEnOficina  porque ya existe uno con ese nombre.
     */
    @PUT
    @Path("{id : \\d+}")
    public EntregasDeDocumentosDTO updateEntregasDeDocumentos( @PathParam("id") long id, EntregasDeDocumentosDTO  entregasDeDocumentos ){
        return entregasDeDocumentos;

    }
    /**
     * <h1>DELETE /api/entregasDeDocumentos/{id} : Borrar entregasDeDocumentos por id.</h1>
     * 
     * <pre>Borra el entregasDeDocumentos con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina el entregasDeDocumentos correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un entregasDeDocumentos con el id dado.
     * </code>
     * </pre>
     * @param id Identificador de LA entregasDeDocumentos que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id : \\d+}")
    public void deleteEntregasDeDocumentos( @PathParam("id") Long id ){
        
    }
}
