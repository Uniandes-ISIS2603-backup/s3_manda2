
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.resources;

//TODO: Quitar los import que no se usan
import co.edu.uniandes.csw.manda2.dtos.ArticuloDTO;
import co.edu.uniandes.csw.manda2.ejb.ArticuloLogic;
import co.edu.uniandes.csw.manda2.ejb.ComprasEnTiendaLogic;
import co.edu.uniandes.csw.manda2.entities.ArticuloEntity;
import co.edu.uniandes.csw.manda2.entities.ComprasEnTiendaEntity;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author cv.trujillo
 */
@Path("articulos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class ArticuloResource {

    @Inject
    private ArticuloLogic articuloLogic;
    //TODO: Esta variable no se usa
    @Inject
    private ComprasEnTiendaLogic comprasLogic;

    /**
     * <h1>GET /api/articulos : Obtener todas los articulos.</h1>
     *
     * <pre>Busca y devuelve todas los articulos que existen en la aplicacion.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todas las ciudades de la aplicacion.</code>
     * </pre>
     *
     * @return JSONArray {@link ArticuloDTO} - Los articulo encontradas en la
     * aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<ArticuloDTO> getArticulos() {
        return listElementos(articuloLogic.getArticulos());
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
     *
     * @param id Identificador del articulos que se esta buscando. Este debe ser
     * una cadena de dígitos.
     * @return JSON {@link ArticuloDTO} - El articulos buscado
     */
    @GET
    @Path("{id : \\d+}")
    public ArticuloDTO getArticulo(@PathParam("id") Long id) {
        //TODO: Si no existe hay que disparar WebApplicationException
        ArticuloDTO nuevo = new ArticuloDTO(articuloLogic.getArticulo(id));
        return nuevo;
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
     *
     * @param articulos el articulo a construir
     * @return JSON {@link ArticuloDTO} - El articuloguardado con el atributo id
     * autogenerado.
     */
    @POST
    public ArticuloDTO createArticulos(ArticuloDTO articulos) throws BusinessLogicException {
        //ComprasEnTiendaEntity c = comprasLogic.createCompra(articulos.toEntity());
        //articulos.setId(c.getId());

        return new ArticuloDTO(articuloLogic.createArticulo(articulos.toEntity()));

    }

    private List<ArticuloDTO> listElementos(List<ArticuloEntity> entityList) {

        return entityList.stream().map(a -> new ArticuloDTO(a)).collect(Collectors.toList());

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
     *
     * @param id Identificador del articuloque se desea actualizar.Este debe ser
     * una cadena de dígitos.
     * @param articulo {@link ArticuloDTO} El articuloque se desea guardar.
     * @return JSON {@link ArticuloDTO} - El articuloguardado.
     */
    @PUT
    @Path("{id : \\d+}")
    public ArticuloDTO updateArticulos(@PathParam("id") Long id, ArticuloDTO articulo) throws BusinessLogicException {
        articulo.setId(id);
        ArticuloEntity entity = articuloLogic.getArticulo(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /articulos/" + id + " no existe.", 404);
        }
        return new ArticuloDTO(articuloLogic.updateArticulo(id, articulo.toEntity()));
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
     *
     * @param id Identificador del articulo que se desea borrar. Este debe ser
     * una cadena de dígitos.
     */
    @DELETE
    @Path("{id : \\d+}")
    public void deleteArticulos(@PathParam("id") long id) {
        ArticuloEntity entity = articuloLogic.getArticulo(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /pses/" + id + " no existe.", 404);
        }
        articuloLogic.deleteArticulo(id);
    }

}
