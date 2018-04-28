/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.resources;

import co.edu.uniandes.csw.manda2.dtos.VueltasConDemoraEnOficinaDTO;
import co.edu.uniandes.csw.manda2.ejb.VueltasConDemoraEnOficinaLogic;
import co.edu.uniandes.csw.manda2.entities.VueltasConDemoraEnOficinaEntity;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
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
 ** <pre>Clase que implementa el recurso "vueltasConDemoraEnOficina".
 * URL: /api/vueltasConDemoraEnOficina
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "vueltasConDemoraEnOficina".</i>
 *
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio). 
 * </pre>
 * @author dv.gonzalez10
 */
//TODO:DONE Hay que hacer el recurso
@Path("vueltascondemoraenoficina")
@Produces("application/json")
@Consumes("application/json")
public class VueltasConDemoraEnOficinaResource {
    
     @Inject
    private VueltasConDemoraEnOficinaLogic vueltasConDemoraEnOficinaLogic;
    
    /**
     * <h1>GET /api/vueltasConDemoraEnOficina : Obtener todos las vueltas.</h1>
     * 
     * <pre>Busca y devuelve todos las vueltas que existen en la aplicación.
     * 
     * Códigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos las vueltas de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link VueltasConDemoraEnOficinaDTO} - Las vueltasConDemoraEnOFicina encontrados en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<VueltasConDemoraEnOficinaDTO> getVueltasConDemoraEnOficina(){
        return listVueltas2DTO(vueltasConDemoraEnOficinaLogic.getVueltas());
    }
    
    /**
     * <h1>GET /api/vueltasConDemoraEnOficina/{id} : Obtener vueltasConDemoraEnOficina por id.</h1>
     * 
     * <pre>Busca la vueltasConDemoraEnOficina con el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve la vueltasConDemoraEnOficina correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un vueltasConDemoraEnOficina con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la vueltasConDemoraEnOficina que se está buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link VueltasConDemoraEnOficinaDTO} - La vueltasConDemoraEnOficina buscada
     */
    @GET
    @Path("{id : \\d+}")
    public VueltasConDemoraEnOficinaDTO getVueltaConDemoraEnOficina(@PathParam("id") long id){
        VueltasConDemoraEnOficinaEntity entity = vueltasConDemoraEnOficinaLogic.getVuelta(id);
       if( entity == null ){
          throw new WebApplicationException("El recurso /vueltasConDemoraEnOficina/" + id + " no existe", 404);
       }
       return new VueltasConDemoraEnOficinaDTO(entity);
    }
   
    /**
     * <h1>POST /api/vueltasConDemoraEnOficina: Crear una vueltasConDemoraEnOficina.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link VueltasConDemoraEnOficinaDTO}.
     * 
     * Crea una nueva vueltasConDemoraEnOficina con la información que se recibe en el cuerpo de la petición
     * y se regresa un objeto idéntico con un id auto-generado por la base de datos.
     * 
     * Códigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó el nuevo VueltasConDemoraEnOficina.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe VueltasConDemoraEnOficina.
     * </code>
     * </pre>
     * @param vueltaConDemoraEnOficina las vueltas con demora en oficina.
     * @return JSON {@link VueltasConDemoraEnOficinaDTO} - El vueltasConDemoraEnOficina guardado con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicException} - Error de lógica que se genera cuando ya existe el PayPal.
     */
    @POST
    public VueltasConDemoraEnOficinaDTO createVueltaConDemoraEnOficina( VueltasConDemoraEnOficinaDTO vueltaConDemoraEnOficina)throws BusinessLogicException{
        return new VueltasConDemoraEnOficinaDTO (vueltasConDemoraEnOficinaLogic.createVuelta(vueltaConDemoraEnOficina.toEntity()));
    }
    
    
    /**
     * <h1>PUT /api/vueltasConDemoraEnOficina/{id} : Actualizar VueltasConDemoraEnOficina con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link VueltasConDemoraEnOficinaDTO }.
     * 
     * Actualiza vueltasConDemoraEnOficina con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza VueltasConDemoraEnOficina con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un VueltasConDemoraEnOficina con el id dado.
     * </code>
     * </pre>
     * @param id Identificador del vueltasConDemoraEnOficina que se desea actualizar. Este debe ser una cadena de dígitos.
     * @param vueltaConDemoraEnOficina las vueltas con demora en oficina
     * @return JSON {@link VueltasConDemoraEnOficinaDTO} -  VueltasConDemoraEnOficina  guardado.
     * @throws BusinessLogicException {@link BusinessLogicException} - Error de lógica que se genera al no poder actualizar vueltasConDemoraEnOficina  porque ya existe uno con ese nombre.
     */
    @PUT
    @Path("{id : \\d+}")
    public VueltasConDemoraEnOficinaDTO  updateVueltaConDemoraEnOficina( @PathParam("id") long id, VueltasConDemoraEnOficinaDTO  vueltaConDemoraEnOficina ) throws BusinessLogicException{
        vueltaConDemoraEnOficina.setId(id);
       VueltasConDemoraEnOficinaEntity entity = vueltasConDemoraEnOficinaLogic.getVuelta(id);
       if( entity == null ){
           throw new WebApplicationException("El recurso /compras /" + id + " no existe", 404);
       }
       return new VueltasConDemoraEnOficinaDTO(vueltasConDemoraEnOficinaLogic.updateVuelta(id, vueltaConDemoraEnOficina.toEntity()));
    }
    
    /**
     * <h1>DELETE /api/vueltasConDemoraEnOficina/{id} : Borrar VueltasConDemoraEnOficina por id.</h1>
     * 
     * <pre>Borra el VueltasConDemoraEnOficina con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina el VueltasConDemoraEnOficina correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un VueltasConDemoraEnOficina con el id dado.
     * </code>
     * </pre>
     * @param id Identificador de LA VueltasConDemoraEnOficina que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id : \\d+}")
    public void deleteVueltaConDemoraEnOficina( @PathParam("id") Long id ){
        VueltasConDemoraEnOficinaEntity entity = vueltasConDemoraEnOficinaLogic.getVuelta(id);
        if( entity == null ){
            throw new WebApplicationException("El recurso / comprasEnTienda/" + id + " no existe", 404);
        }
        vueltasConDemoraEnOficinaLogic.deleteVuelta(id);
    }
    
    private List<VueltasConDemoraEnOficinaDTO> listVueltas2DTO( List<VueltasConDemoraEnOficinaEntity> entityList){
        List<VueltasConDemoraEnOficinaDTO> lista = new ArrayList<>();
        for( VueltasConDemoraEnOficinaEntity entity : entityList ){
            lista.add(new VueltasConDemoraEnOficinaDTO(entity));
        }
        return lista;
    }
    
}
