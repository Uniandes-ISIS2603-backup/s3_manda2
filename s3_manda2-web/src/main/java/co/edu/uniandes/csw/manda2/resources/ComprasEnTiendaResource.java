/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.resources;

import co.edu.uniandes.csw.manda2.dtos.ComprasEnTiendaDTO;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.LinkedList;
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
 *
 ** <pre>Clase que implementa el recurso "comprasEnTiendaResource".
 * URL: /api/comprasEnTienda
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "comprasEnTiendaResource".</i>
 *
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio). 
 * </pre>
 * @author dv.gonzalez10
 */
@Path("comprasentienda")
@Produces("application/json")
@Consumes("application/json")
public class ComprasEnTiendaResource {
    
    
    
    /**
     * <h1>GET /api/comprasEnTiendaResource : Obtener todos las comprasEnTiendaResource.</h1>
     * 
     * <pre>Busca y devuelve todos las comprasEnTiendaResource que existen en la aplicación.
     * 
     * Códigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos las comprasEnTiendaResource de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link ComprasEnTiendaDTO} - Las comprasEnTiendaResource encontrados en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
     @GET
    public List<ComprasEnTiendaDTO> getComprasEnTienda(){
        return new LinkedList<> ();
    }
    
    
    /**
     * <h1>GET /api/comprasEnTiendaResource/{id} : Obtener comprasEnTiendaResource por id.</h1>
     * 
     * <pre>Busca la comprasEnTiendaResource con el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve la comprasEnTiendaResource correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe una comprasEnTiendaResource con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la comprasEnTiendaResource que se está buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link comprasEnTiendaResource} - La comprasEnTiendaResource buscada
     */
    @GET
    @Path("{id : \\d+}")
    public ComprasEnTiendaDTO getComprasEnTienda(@PathParam("id") long id){
        return null;
    }
     
    /**
     * <h1>POST /api/comprasEnTiendaResource: Crear una comprasEnTiendaResource.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link comprasEnTiendaResource}.
     * 
     * Crea una nueva comprasEnTiendaResource con la información que se recibe en el cuerpo de la petición
     * y se regresa un objeto idéntico con un id auto-generado por la base de datos.
     * 
     * Códigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó el nuevo comprasEnTiendaResource.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe comprasEnTiendaResource.
     * </code>
     * </pre>
     * @param comprasEnTienda compras de la tienda
     * @return JSON {@link ComprasEnTiendaResourceDTO} - El comprasEnTiendaResource guardado con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe el PayPal.
     */
    @POST
    public ComprasEnTiendaDTO createComprasEnTienda( ComprasEnTiendaDTO comprasEnTienda) throws BusinessLogicException{
        return comprasEnTienda;
    }
    /**
     * <h1>PUT /api/comprasEnTiendaResource/{id} : ActualizarComprasEnTiendaResource con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link ComprasEnTiendaResource }.
     * 
     * Actualiza comprasEnTiendaResource con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza ComprasEnTiendaResource con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un ComprasEnTiendaResource con el id dado.
     * </code>
     * </pre>
     * @param id Identificador del comprasEnTiendaResource que se desea actualizar. Este debe ser una cadena de dígitos.
     * @param comprasEnTienda compras de la tienda
     * @return JSON {@link ComprasEnTiendaResourceDTO} -  ComprasEnTiendaResource  guardado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar vueltasConDemoraEnOficina  porque ya existe uno con ese nombre.
     */
    @PUT
    @Path("{id : \\d+}")
    public ComprasEnTiendaDTO  updateComprasEnTienda( @PathParam("id") long id, ComprasEnTiendaDTO  comprasEnTienda ) throws BusinessLogicException{
        return comprasEnTienda;

    }
    
    /**
     * <h1>DELETE /api/comprasEnTiendaResource/{id} : Borrar ComprasEnTiendaResource por id.</h1>
     * 
     * <pre>Borra el ComprasEnTiendaResource con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina el ComprasEnTiendaResource correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un ComprasEnTiendaResource con el id dado.
     * </code>
     * </pre>
     * @param id Identificador de LA ComprasEnTiendaResource que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id : \\d+}")
    public void deleteComprasEnTienda( @PathParam("id") Long id ){
        
    }
    
}
