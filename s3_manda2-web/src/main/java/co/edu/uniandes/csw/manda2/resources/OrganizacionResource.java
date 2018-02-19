package co.edu.uniandes.csw.manda2.resources;


import co.edu.uniandes.csw.manda2.dtos.OrganizacionDetailsDTO;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.Path;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * * <pre>Clase que implementa el recurso "Organizacion".
 * URL: /api/servicios
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "servicios".</i>
 *
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios de tipo de organización definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método del servicio  tipo Organizacion. 
 * </pre>
 * @author cv.trujillo
 */
@Path ("organizaciones")
@Consumes("application/json")
@Produces("application/json")
public class OrganizacionResource 
{
     /**
     * <h1>GET /api/organizaicin: Obtener todos los servicios de tipo Organización.</h1>
     * 
     * <pre>Busca y devuelve todos los servicios de tipo Organización que existen en la aplicación.
     * 
     * Códigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los servicios de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link ServicioDetailDTO} - Los servicios encontrados en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    
    public List<OrganizacionDetailsDTO> getOrganizacion()
    {
        return null;
    }
    
    /**
     * <h1>GET /api/organizacion/{id} : Obtener servicio de organizacion por id.</h1>
     * 
     * <pre>Busca el servicio con el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el servicio de tipo organización correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un servicio de tipo organización con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del servicio de tipo organización que se está buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link ServicioDetailDTO} - El servicio buscada
     */
    
    @GET
    @Path("{id : \\d+}")
    public OrganizacionDetailsDTO getServiciosDeOrganizacion(@PathParam ("id") Long id)
    {
        return null;
    }
    
     /**
     * <h1>POST /api/organizacion: Crear un servicio de tipo Organización.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link servicioDTO}.
     * 
     * Crea un nuevo servicio de tipo Organización con la información que se recibe en el cuerpo de la petición
     * y se regresa un objeto idéntico con un id auto-generado por la base de datos.
     * 
     * Códigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó el nuevo servicio de tipo Organización.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe el servicio de tipo Organización.
     * </code>
     * </pre>
     * @param servicio {@link ServicioDetailDTO} - El servicio de tipo Organización que se desea guardar.
     * @return JSON {@link ServicioDetailDTO} - El servicio de tipo Organización fue guardado con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe el servicio de tipo Organización.
     */
    @POST
    public OrganizacionDetailsDTO crearOrganizacion(OrganizacionDetailsDTO servicio) throws BusinessLogicException
    {
        return null;
    }
     
    /**
     * /**
     * <h1>PUT /api/organizacion/{id} : Actualizar servicio de tipo Organización con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link CityDetailDTO}.
     * 
     * Actualiza el servicio de tipo Organización con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza el servicio de tipo Organización con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un servicio de tipo Organización con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del servicio de tipo Organización que se desea actualizar. Este debe ser una cadena de dígitos.
     * @param servicio {@link servicioDTO} - El servicio de tipo Organización que se desea guardar.
     * @return JSON {@link servicioDTO} - El servicio de tipo Organización guardado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar el servicio de tipo Organización porque ya existe uno con ese nombre.
     
     * @param 
     * @param id
     * @param organizacion
     * @return
     */
    @PUT
    @Path("{id : \\d+}")
          
    public OrganizacionDetailsDTO actualizarOrganizacion(@PathParam("id") Long id, OrganizacionDetailsDTO organizacion) throws BusinessLogicException
    {
        return null;
    }
    
       
    /**
     * <h1>DELETE /api/organizacion/{id} : Borrar servicio de tipo Organización por id.</h1>
     * 
     * <pre>Borra el servicio de tipo Organización con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina el servicio de tipo Organización correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un servicio de tipo Organización con el id dado.
     * </code>
     * </pre>
     * @param id Identificador del servicio de tipo Organización que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id : \\d+}")
    public void eliminarOrganizacion(@PathParam("id")Long id,OrganizacionDetailsDTO organizacion)
    {
            
    }
    
    
    

    
}
