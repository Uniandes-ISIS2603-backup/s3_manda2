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
import co.edu.uniandes.csw.manda2.dtos.TarjetaCreditoDTO;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
/**
 *
 * <pre>Clase que implementa el recurso "tarjetascreditos".
 * URL: /api/tarjetascreditos
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "tarjetascreditos".</i>
 *
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio). 
 * </pre>
 *
 * @author na.caceres
 */
@Path("tarjetascreditos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped

public class TarjetaCreditoResource {
    /**
     * <h1>GET /api/tarjetascreditos : Obtener todas las tarjetas de credito.</h1>
     * 
     * <pre>Busca y devuelve todas las tarjetas de credito que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todas las ciudades de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link TarjetaCreditoDTO} - Las tarjetas de credito encontradas en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
   @GET
    public List<TarjetaCreditoDTO> getTarjetasCreditos() {
        return new ArrayList<>();
    }
/**
     * <h1>GET /api/tarjetascreditos/{id} : Obtener una tarjeta de credito por id.</h1>
     * 
     * <pre>Busca la tarjeta de credito con el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve la tarjeta correspondiente correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe una tarjeta de credito con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la tarjeta de credito que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link TarjetaCreditoDTO} - La tarjeta de credito buscada
     */
    @GET
    @Path("{id : \\d+}")
    public TarjetaCreditoDTO getTarjetaCredito(@PathParam("id") long id) {
        return null;
    }
/**
     * <h1>POST /api/tarjetascreditos : Crear una tarjeta de credito.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link TarjetaCreditoDTO}.
     * 
     * Crea una nueva tarjeta de credito con la información que se recibe en el cuerpo de la petición
     * y se regresa un objeto idéntico con un id auto-generado por la base de datos.
     * 
     * Códigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó la nueva tarjeta de credito.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe la tarjeta de credito.
     * </code>
     * </pre>
     * @param tarjetaCredito {@link TarjetaCreditoDTO} - La tarjeta de credito que se desea guardar.
     * @return JSON {@link TarjetaCreditoDTO} - La tarjeta de credito guardada con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicException} - Error de lógica que se genera cuando ya existe la tarjeta de credito.
     */
    @POST
    public TarjetaCreditoDTO createTarjetaCredito(TarjetaCreditoDTO tarjetaCredito) throws BusinessLogicException {
        return null;
    }
/**
     * <h1>PUT /api/tarjetascreditos/{id} : Actualizar la tarjeta de credito con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link TarjetaCreditoDTO}.
     * 
     * Actualiza la tarjeta de credito con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza la tarjeta de credito con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una tarjeta de credito con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la tarjeta de credito que se desea actualizar.Este debe ser una cadena de dígitos.
     * @param tarjetaCredito {@link TarjetaCreditoDTO} - La tarjeta de credito que se desea guardar.
     * @return JSON {@link TarjetaCreditoDTO} - La tarjeta de credito guardada.
     * @throws BusinessLogicException {@link BusinessLogicException} - Error de lógica que se genera al no poder actualizar el pse porque ya existe uno con ese nombre.
     */
    @PUT
    @Path("{id : \\d+}")
    public TarjetaCreditoDTO updateTarjetaCredito (@PathParam("id") long id, TarjetaCreditoDTO tarjetaCredito) throws BusinessLogicException {
        return null;
    }
/**
     * <h1>DELETE /api/tarjetascreditos/{id} : Borrar una tarjeta de credito por id.</h1>
     * 
     * <pre>Borra la tarjeta de credito con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina la tarjeta de credito correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe la tarjeta de credito con el id dado.
     * </code>
     * </pre>
     * @param id Identificador de la tarjeta de credito que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id : \\d+}")
    public void deleteTarjetaCredito(@PathParam("id") long id) {

    } 
}
