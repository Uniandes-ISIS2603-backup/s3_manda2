package co.edu.uniandes.csw.manda2.resources;

import co.edu.uniandes.csw.manda2.dtos.ServicioDetailDTO;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;
import java.util.List;
import javax.ws.rs.*;

/**
 * <pre>Clase que implementa el recurso "servicio".
 * URL: /api/servicios
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "servicios".</i>
 *
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio). 
 * </pre>
 * @author da.ramos
 */
@Path("servicios")
@Consumes("application/json")
@Produces("application/json")
public class ServicioResource {
    
     /**
     * <h1>GET /api/servicios : Obtener todos los servicios.</h1>
     * 
     * <pre>Busca y devuelve todos los servicios que existen en la aplicación.
     * 
     * Códigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los servicios de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link ServicioDetailDTO} - Los servicios encontrados en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<ServicioDetailDTO> getServicios(){
        return null;
    }
    
     /**
     * <h1>GET /api/servicios/{id} : Obtener servicio por id.</h1>
     * 
     * <pre>Busca el servicio con el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el servicio correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un servicio con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del servicio que se está buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link ServicioDetailDTO} - El servicio buscada
     */
    @GET
    @Path("{id : \\d+}")
    public ServicioDetailDTO getServicio(@PathParam ("id") long id){
        return null;
    }
    
     /**
     * <h1>POST /api/servicios : Crear un servicio.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link servicioDTO}.
     * 
     * Crea un nuevo servicio con la información que se recibe en el cuerpo de la petición
     * y se regresa un objeto idéntico con un id auto-generado por la base de datos.
     * 
     * Códigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó el nuevo servicio.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe el servicio.
     * </code>
     * </pre>
     * @param servicio {@link ServicioDetailDTO} - El servicio que se desea guardar.
     * @return JSON {@link ServicioDetailDTO} - El servicio guardado con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe el servicio.
     */
    @POST
    public ServicioDetailDTO createServicio( ServicioDetailDTO servicio)throws BusinessLogicException{
        return servicio;
    }
    
     /**
     * <h1>PUT /api/servicios/{id} : Actualizar servicio con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link CityDetailDTO}.
     * 
     * Actualiza el servicio con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza el servicio con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un servicio con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del servicio que se desea actualizar. Este debe ser una cadena de dígitos.
     * @param servicio {@link servicioDTO} - El servicio que se desea guardar.
     * @return JSON {@link servicioDTO} - El servicio guardado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar el servicio porque ya existe uno con ese nombre.
     */
    @PUT
    @Path("{id : \\d+}")
    public ServicioDetailDTO updateServicio( @PathParam("id") long id, ServicioDetailDTO servicio ) throws BusinessLogicException{
        return servicio;
    }
    
    /**
     * <h1>DELETE /api/servicios/{id} : Borrar servicio por id.</h1>
     * 
     * <pre>Borra el servicio con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina el servicio correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un servicio con el id dado.
     * </code>
     * </pre>
     * @param id Identificador del servicio que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id : \\d+}")
    public void deleteServicio( @PathParam("id") long id ){
        
    }
}
