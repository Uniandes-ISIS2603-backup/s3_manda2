package co.edu.uniandes.csw.manda2.resources;


import co.edu.uniandes.csw.manda2.dtos.OrganizacionDetailsDTO;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;
import java.util.ArrayList;
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
 * URL: /api/organizacións
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "organizacións".</i>
 *
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los organizacións de tipo de organización definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método del organización  tipo Organizacion. 
 * </pre>
 * @author cv.trujillo
 */
@Path ("organizaciones")
@Consumes("application/json")
@Produces("application/json")
public class OrganizacionResource 
{
     /**
     * <h1>GET /api/organizaicin: Obtener todos los organizacións de tipo Organización.</h1>
     * 
     * <pre>Busca y devuelve todos los organizacións de tipo Organización que existen en la aplicación.
     * 
     * Códigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los organizacións de la aplicacion.</code> 
     * </pre>
<<<<<<< HEAD
     * @return JSONArray {@link OrganizacionDetailsDTO} - Los organizacións encontrados en la aplicación. Si no hay ninguna retorna una lista vacía.
=======
     * @return JSONArray {@link OrganizacionDetailsDTO} - Los servicios encontrados en la aplicación. Si no hay ninguna retorna una lista vacía.
>>>>>>> 0837a4c2ad95b3caa10cefa28c020ae569554c53
     */
    @GET
    
    public List<OrganizacionDetailsDTO> getOrganizacion()
    {
        return new ArrayList<>();
    }
    
    /**
     * <h1>GET /api/organizacion/{id} : Obtener organización de organizacion por id.</h1>
     * 
     * <pre>Busca el organización con el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el organización de tipo organización correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un organización de tipo organización con el id dado.
     * </code> 
     * </pre>
<<<<<<< HEAD
     * @param id Identificador del organización de tipo organización que se está buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link OrganizacionDetailsDTO} - El organización buscada
=======
     * @param id Identificador del servicio de tipo organización que se está buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link OrganizacionDetailsDTO} - El servicio buscada
>>>>>>> 0837a4c2ad95b3caa10cefa28c020ae569554c53
     */
    
    @GET
    @Path("{id : \\d+}")


    public OrganizacionDetailsDTO getServiciosDeOrganizacion(@PathParam ("id") Long id)
    {
        return null;
    }
    
     /**
     * <h1>POST /api/organizacion: Crear un organización de tipo Organización.</h1>
     * 
<<<<<<< HEAD
     * <pre>Cuerpo de petición: JSON {@link organizaciónDTO}.
=======
     * <pre>Cuerpo de petición: JSON {@link OrganizacionDetailsDTO}.
>>>>>>> 0837a4c2ad95b3caa10cefa28c020ae569554c53
     * 
     * Crea un nuevo organización de tipo Organización con la información que se recibe en el cuerpo de la petición
     * y se regresa un objeto idéntico con un id auto-generado por la base de datos.
     * 
     * Códigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó el nuevo organización de tipo Organización.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe el organización de tipo Organización.
     * </code>
     * </pre>
<<<<<<< HEAD
     * @param organización {@link OrganizacionDetailsDTO} - El organización de tipo Organización que se desea guardar.
     * @return JSON {@link OrganizacionDetailsDTO} - El organización de tipo Organización fue guardado con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe el organización de tipo Organización.
=======
     * @param servicio {@link OrganizacionDetailsDTO} - El servicio de tipo Organización que se desea guardar.
     * @return JSON {@link OrganizacionDetailsDTO} - El servicio de tipo Organización fue guardado con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicException} - Error de lógica que se genera cuando ya existe el servicio de tipo Organización.
>>>>>>> 0837a4c2ad95b3caa10cefa28c020ae569554c53
     */
    @POST
    public OrganizacionDetailsDTO crearOrganizacion(OrganizacionDetailsDTO organización) throws BusinessLogicException
    {
        return organización;
        
    }
     
    /**
     * /**
<<<<<<< HEAD
     * <h1>PUT /api/organizacion/{id} : Actualizar organización de tipo Organización con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link CityDetailDTO}.
=======
     * <h1>PUT /api/organizacion/{id} : Actualizar servicio de tipo Organización con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link OrganizacionDetailsDTO}.
>>>>>>> 0837a4c2ad95b3caa10cefa28c020ae569554c53
     * 
     * Actualiza el organización de tipo Organización con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza el organización de tipo Organización con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un organización de tipo Organización con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del organización de tipo Organización que se desea actualizar. Este debe ser una cadena de dígitos.
     * @param organizacion la organizacion
<<<<<<< HEAD
     * @return JSON {@link organizaciónDTO} - El organización de tipo Organización guardado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar el organización de tipo Organización porque ya existe uno con ese nombre.
=======
     * @return JSON {@link OrganizacionDetailsDTO} - El servicio de tipo Organización guardado.
     * @throws BusinessLogicException {@link BusinessLogicException} - Error de lógica que se genera al no poder actualizar el servicio de tipo Organización porque ya existe uno con ese nombre.
>>>>>>> 0837a4c2ad95b3caa10cefa28c020ae569554c53
     */
    @PUT
    @Path("{id : \\d+}")
          
    public OrganizacionDetailsDTO actualizarOrganizacion(@PathParam("id") Long id, OrganizacionDetailsDTO organizacion) throws BusinessLogicException
    {
        return organizacion;
    }
    
       
    /**
     * <h1>DELETE /api/organizacion/{id} : Borrar organización de tipo Organización por id.</h1>
     * 
     * <pre>Borra el organización de tipo Organización con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina el organización de tipo Organización correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un organización de tipo Organización con el id dado.
     * </code>
     * </pre>
     * @param id Identificador del organización de tipo Organización que se desea borrar. Este debe ser una cadena de dígitos.
     * @param organizacion la organizacion
     */
    @DELETE
    @Path("{id : \\d+}")
    public void eliminarOrganizacion(@PathParam("id")Long id,OrganizacionDetailsDTO organizacion)
    {
            
    }
    
    
    

    
}
