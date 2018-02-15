/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.resources;


import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import co.edu.uniandes.csw.manda2.dtos.PSEDTO;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
/**
 *
 * <pre>Clase que implementa el recurso "pses".
 * URL: /api/pses
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "pses".</i>
 *
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio). 
 * </pre>
 * @author na.caceres
 */
@Path("pses")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class PSEResource {
     /**
     * <h1>GET /api/pses : Obtener todas los pses.</h1>
     * 
     * <pre>Busca y devuelve todas los pses que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todas las ciudades de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link PSEDTO} - Los pses encontradas en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<PSEDTO> getPSEs() {
        return new ArrayList<>();
    }
 /**
     * <h1>GET /api/pses/{id} : Obtener pse por id.</h1>
     * 
     * <pre>Busca el pse con el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el pse correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un pse con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del pse que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link PSEDTO} - El pse buscado
     */
    @GET
    @Path("{id : \\d+}")
    public PSEDTO getPSE(@PathParam("id") long id) {
        return null;
    }
/**
     * <h1>POST /api/pses : Crear un pse.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link PSEDTO}.
     * 
     * Crea un nuevo PSE con la información que se recibe en el cuerpo de la petición
     * y se regresa un objeto idéntico con un id auto-generado por la base de datos.
     * 
     * Códigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó el nuevo Pse.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe el Pse.
     * </code>
     * </pre>
     * @param pse {@link PSEDTO} - El PSE que se desea guardar.
     * @return JSON {@link PSEDTO} - El PSE guardado con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe el PSE.
     */
    @POST
    public PSEDTO createPSE(PSEDTO pse) {
        return pse;
    }
/**
     * <h1>PUT /api/pses/{id} : Actualizar pse con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link PSEDTO}.
     * 
     * Actualiza el pse con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza el pse con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe unpse con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del pse que se desea actualizar.Este debe ser una cadena de dígitos.
     * @param pse {@link PSEDTO} El pse que se desea guardar.
     * @return JSON {@link PSEDTO} - El pse guardado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar el pse porque ya existe uno con ese nombre.
     */
    @PUT
    @Path("{id : \\d+}")
    public PSEDTO updatePSE(@PathParam("id") long id, PSEDTO pse) {
        return pse;
    }
/**
     * <h1>DELETE /api/pses/{id} : Borrar un pse por id.</h1>
     * 
     * <pre>Borra el pse con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina el pse correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe el pse con el id dado.
     * </code>
     * </pre>
     * @param id Identificador del pseque se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id : \\d+}")
    public void deletePSE(@PathParam("id") long id) {

    }
}
