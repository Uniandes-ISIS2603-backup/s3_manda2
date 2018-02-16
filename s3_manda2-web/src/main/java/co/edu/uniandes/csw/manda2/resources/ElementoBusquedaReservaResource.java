/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.resources;

import co.edu.uniandes.csw.manda2.dtos.ElementoBusquedaReservaDTO;
import co.edu.uniandes.csw.manda2.dtos.ElementoBusquedaReservaDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author cv.trujillo
 */
public class ElementoBusquedaReservaResource {
    
       /**
     * <h1>GET /api/elementoBusqueda : Obtener todas los elementoBusqueda.</h1>
     * 
     * <pre>Busca y devuelve todas los elementoBusqueda que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todas las ciudades de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link ElementoBusquedaReservaDTO} - Los elemetoBusquedas encontradas en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<ElementoBusquedaReservaDTO> getElementoBusquedas() {
        return new ArrayList<>();
    }
 /**
     * <h1>GET /api/elementoBusqueda/{id} : Obtener elementoBusqueda por id.</h1>
     * 
     * <pre>Busca el elementoBusqueda con el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el elementoBusqueda correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un elementoBusqueda con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del elementoBusqueda que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link ElementoBusquedaReservaDTO} - El ElementoBusquedas buscado
     */
    @GET
    @Path("{id : \\d+}")
    public ElementoBusquedaReservaDTO getElementoBusquedas(@PathParam("id") long id) {
        return null;
    }
/**
     * <h1>POST /api/elementoBusqueda : Crear un elementoBusqueda.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link ElementoBusquedaReservaDTO}.
     * 
     * Crea un nuevo artículo con la información que se recibe en el cuerpo de la petición
     * y se regresa un objeto idéntico con un id auto-generado por la base de datos.
     * 
     * Códigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó el nuevo elementoBusqueda.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe el elementoBusqueda.
     * </code>
     * </pre>
     * @param elementoBusqueda {@link ElementoBusquedaReservaDTO} - El ElementoBusqueda que se desea guardar.
     * @return JSON {@link ElementoBusquedaReservaDTO} - El elemetoBusqueda guardado con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe el elemetoBusqueda.
     */
    @POST
    public ElementoBusquedaReservaDTO createElementoBusquedas(ElementoBusquedaReservaDTO ElementoBusquedas) {
        return ElementoBusquedas;
    }
/**
     * <h1>PUT /api/elemetoBusqueda/{id} : Actualizar ElementoBusqueda con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link ElementoBusquedaReservaDTO}.
     * 
     * Actualiza el ElementoBusqueda con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza el elemetoBusqueda con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe unelemetoBusqueda con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del elemetoBusqueda que se desea actualizar.Este debe ser una cadena de dígitos.
     * @param ElementoBusqueda {@link ElementoBusquedaReservaDTO} El elemetoBusqueda que se desea guardar.
     * @return JSON {@link ElementoBusquedaReservaDTO} - El elemetoBusqueda guardado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar el elemetoBusqueda porque ya existe uno con ese nombre.
     */
    @PUT
    @Path("{id : \\d+}")
    public ElementoBusquedaReservaDTO updateElementoBusquedas(@PathParam("id") long id, ElementoBusquedaReservaDTO ElementoBusqueda) {
        return ElementoBusqueda;
    }
/**
     * <h1>DELETE /api/elemetoBusqueda/{id} : Borrar un ElementoBusqueda por id.</h1>
     * 
     * <pre>Borra el ElementoBusqueda con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina el ElementoBusqueda correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe el ElementoBusqueda con el id dado.
     * </code>
     * </pre>
     * @param id Identificador del elemetoBusquedaque se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id : \\d+}")
    public void deleteElementoBusquedas(@PathParam("id") long id) {

    }
}
