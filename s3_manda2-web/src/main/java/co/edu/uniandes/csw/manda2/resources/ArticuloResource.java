/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.resources;

import co.edu.uniandes.csw.manda2.dtos.ArticuloDTO;
import co.edu.uniandes.csw.manda2.dtos.ArticuloDTO;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
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
 * @author cv.trujillo
 */
 
@Path("articulos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class ArticuloResource {
      /**
     * <h1>GET /api/articulos : Obtener todas los articulos.</h1>
     * 
     * <pre>Busca y devuelve todas los articulos que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todas las ciudades de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link ArticuloDTO} - Los articulo encontradas en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<ArticuloDTO> getArticulos() {
        return new ArrayList<>();
    }
 /**
     * <h1>GET /api/articulos/{id} : Obtener articulos por id.</h1>
     * 
     * <pre>Busca el articulocon el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el articulos correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un articulos con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del articulos que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link ArticuloDTO} - El articulos buscado
     */
    @GET
    @Path("{id : \\d+}")
    public ArticuloDTO getArticulos(@PathParam("id") long id) {
        return null;
    }
/**
     * <h1>POST /api/articulo : Crear un articulos.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link ArticuloDTO}.
     * 
     * Crea un nuevo artículo con la información que se recibe en el cuerpo de la petición
     * y se regresa un objeto idéntico con un id auto-generado por la base de datos.
     * 
     * Códigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó el nuevo articulo
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe el articulo.
     * </code>
     * </pre>
     * @param articulo{@link ArticuloDTO} - El articulo que se desea guardar.
     * @return JSON {@link ArticuloDTO} - El articuloguardado con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe el articulo
     */
    @POST
    public ArticuloDTO createArticulos(ArticuloDTO articulos) {
        return articulos;
    }
/**
     * <h1>PUT /api/articulo/{id} : Actualizar articulo con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link ArticuloDTO}.
     * 
     * Actualiza el articulo con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza el articulocon el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe unarticulocon el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del articuloque se desea actualizar.Este debe ser una cadena de dígitos.
     * @param articulo {@link ArticuloDTO} El articuloque se desea guardar.
     * @return JSON {@link ArticuloDTO} - El articuloguardado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar el articuloporque ya existe uno con ese nombre.
     */
    @PUT
    @Path("{id : \\d+}")
    public ArticuloDTO updateArticulos(@PathParam("id") long id, ArticuloDTO articulo) {
        return articulo;
    }
/**
     * <h1>DELETE /api/articulo/{id} : Borrar un articulo por id.</h1>
     * 
     * <pre>Borra el articulo con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina el articulo correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe el articulo con el id dado.
     * </code>
     * </pre>
     * @param id Identificador del articulo que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id : \\d+}")
    public void deleteArticulos(@PathParam("id") long id) {

    }
    
}
