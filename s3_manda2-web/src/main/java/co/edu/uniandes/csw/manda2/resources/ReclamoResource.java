/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.resources;

import co.edu.uniandes.csw.manda2.dtos.ReclamoDetailDTO;
import co.edu.uniandes.csw.manda2.ejb.ReclamoLogic;
import co.edu.uniandes.csw.manda2.entities.ReclamoEntity;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;

/**
 * <pre>Clase que implementa el recurso "reclamos".
 * URL: /api/reclamos
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "reclamos".</i>
 *
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * </pre>
 * @author n.bello
 */
@Path("reclamos")
@Consumes("application/json")
@Produces("application/json")
@RequestScoped
public class ReclamoResource {
    @Inject
    private ReclamoLogic logic;
     /**
     * <h1>GET /api/reclamos : Obtener todos los reclamos.</h1>
     * 
     * <pre>Busca y devuelve todos los reclamos que existen en la aplicación.
     * 
     * Códigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los reclamos de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link ReclamoDetailDTO} - Los reclamos encontrados en la aplicación. Si no hay ninguno retorna una lista vacía.
     */
    @GET
    public List<ReclamoDetailDTO> getReclamos(){
        return ListReclamoEntityDTO(logic.getReclamos());
    }
    /**
     * <h1>GET /api/reclamos/{numero} : Obtener reclamo por numero.</h1>
     * 
     * <pre>Busca el reclamo con el numero asociado recibido en la URL y la devuelve.
     * 
     * Códigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el reclamo correspondiente al numero.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un reclamo con el numero dado.
     * </code> 
     * </pre>
     * @param id Identificador del reclamo que se está buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link ReclamoDetailDTO} - El reclamo buscado
     */
    @GET
    @Path("{numero : \\d+}")
    public ReclamoDetailDTO getReclamo (@PathParam ("numero") Integer numero){
        ReclamoEntity entity = logic.getReclamoByNumero(numero);
        if (entity == null) {
            throw new WebApplicationException("El recurso /reclamos/" + numero + " no existe.", 404);
        }
        return new ReclamoDetailDTO(entity);
    }
     /**
     * <h1>POST /api/reclamos : Crear un reclamo.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link ReclamoDetailDTO}.
     * 
     * Crea un nuevo reclamo con la información que se recibe en el cuerpo de la petición
     * y se regresa un objeto idéntico con un id auto-generado por la base de datos.
     * 
     * Códigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó el nuevo reclamo.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe el reclamo.
     * </code>
     * </pre>
     * @param reclamo {@link ReclamoDetailDTO} - El reclamo que se desea guardar.
     * @return JSON {@link ReclamoDetailDTO} - El reclamo guardado con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicException} - Error de lógica que se genera cuando ya existe el PayPal.
     */
    
    @POST
    public ReclamoDetailDTO createReclamo( ReclamoDetailDTO reclamo) throws BusinessLogicException{
        return new ReclamoDetailDTO(logic.createReclamo(reclamo.toEntity()));
    }
    /**
     * <h1>PUT /api/reclamos/{numero} : Actualizar reclamos con el numero dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link ReclamoDetailDTO}.
     * 
     * Actualiza el reclamo con el numero recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza el reclamo con el numero dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un reclamo con el numero dado.
     * </code> 
     * </pre>
     * @param id Identificador del reclamo que se desea actualizar. Este debe ser una cadena de dígitos.
     * @param reclamo {@link ReclamoDetailDTO} El reclamo que se desea guardar.
     * @return JSON {@link ReclamoDetailDTO} - El reclamo guardado.
     * @throws BusinessLogicException {@link BusinessLogicException} - Error de lógica que se genera al no poder actualizar el PayPal porque ya existe uno con ese nombre.
     */
    @PUT
    @Path("{id : \\d+}")
    public ReclamoDetailDTO updateReclamo (@PathParam("id") Long id, ReclamoDetailDTO reclamo ) throws BusinessLogicException{
        ReclamoEntity entity = logic.getReclamo(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /reclamo/" + id + " no existe.", 404);
        }
       return new ReclamoDetailDTO (logic.updateReclamo(id, reclamo.toEntity()));
    }
     
    /**
     * <h1>DELETE /api/reclamos/{numero} : Borrar reclamo por numero.</h1>
     * 
     * <pre>Borra el reclamo con el numero asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina el reclamo correspondiente al numero dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un reclamo con el numero dado.
     * </code>
     * </pre>
     * @param id Identificador del Reclamo que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id : \\d+}")
    public void deleteReclamo( @PathParam("id") Long id ){
        ReclamoEntity entity = logic.getReclamo(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /reclamo/" + id + " no existe.", 404);
        }
        logic.deleteReclamo(id);
    }

    private List<ReclamoDetailDTO> ListReclamoEntityDTO(List<ReclamoEntity> reclamos) {
      List<ReclamoDetailDTO> list = new ArrayList();
      for (ReclamoEntity entity : reclamos) {
          list.add(new ReclamoDetailDTO(entity));
      }
      return list;
    }
}
