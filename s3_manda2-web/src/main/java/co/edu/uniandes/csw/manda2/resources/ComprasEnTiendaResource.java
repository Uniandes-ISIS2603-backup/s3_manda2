/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.resources;

import co.edu.uniandes.csw.manda2.dtos.ComprasEnTiendaDTO;
import co.edu.uniandes.csw.manda2.dtos.ComprasEnTiendaDetailsDTO;
import co.edu.uniandes.csw.manda2.ejb.ComprasEnTiendaLogic;
import co.edu.uniandes.csw.manda2.entities.ComprasEnTiendaEntity;
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
    
    @Inject
    private ComprasEnTiendaLogic comprasEnTiendaLogic;
    
    //TODO:DONE HAY QUE HACE EL RECURSO
    /**
     * <h1>GET /api/comprasEnTiendaResource : Obtener todos las compras.</h1>
     * 
     * <pre>Busca y devuelve todos las compras que existen en la aplicación.
     * 
     * Códigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos las comprasEnTiendaResource de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link ComprasEnTiendaDTO} - Las comprasEnTiendaResource encontrados
     * en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
     @GET
    public List<ComprasEnTiendaDetailsDTO> getComprasEnTienda(){
        return listComprasEntity2DTO(comprasEnTiendaLogic.getCompras());
    }
    
    
    /**
     * <h1>GET /api/comprasEnTiendaResource/{id} : Obtener compra por id.</h1>
     * 
     * <pre>Busca la compra con el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve la compra correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe una compra con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la compra que se está buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link ComprasEnTiendaResource} - La compra buscada
     */
    @GET
    @Path("{id : \\d+}")
    public ComprasEnTiendaDTO getComprasEnTienda(@PathParam("id") long id){
        ComprasEnTiendaEntity entity = comprasEnTiendaLogic.getCompra(id);
       if( entity == null ){
          throw new WebApplicationException("El recurso /compras en tienda/" + id + " no existe", 404);
       }
       return new ComprasEnTiendaDetailsDTO(entity);
    }
     
    /**
     * <h1>POST /api/comprasEnTiendaResource: Crear una compra.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link ComprasEnTiendaDTO}.
     * 
     * Crea una nueva compra con la información que se recibe en el cuerpo de la petición
     * y se regresa un objeto idéntico con un id auto-generado por la base de datos.
     * 
     * Códigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó la nueva compra.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe la compra.
     * </code>
     * </pre>
     * @param comprasEnTienda {@link ComprasEnTiendaDTO} compra que desea crear 
     * @return JSON {@link ComprasEnTiendaDTO} - La compra guardada con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicException} - Error de lógica que se genera cuando ya existe la compra
     */
    @POST
    public ComprasEnTiendaDTO createComprasEnTienda( ComprasEnTiendaDetailsDTO comprasEnTienda) throws BusinessLogicException{
        return new ComprasEnTiendaDetailsDTO (comprasEnTiendaLogic.createCompra(comprasEnTienda.toEntity()));
    }
    /**
     * <h1>PUT /api/comprasEnTienda/{id} : ActualizarComprasEnTienda con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link ComprasEnTiendaDTO }.
     * 
     * Actualiza la compra con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza la compra con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe ua compra con el id dado.
     * </code>
     * </pre>
     * @param id Identificador de la compra que se desea actualizar. Este debe ser una cadena de dígitos.
     * @param comprasEnTienda {@link ComprasEnTiendaDTO}  compras de la tienda
     * @return JSON {@link ComprasEnTiendaDTO} - la commpra  guardada.
     * @throws BusinessLogicException {@link BusinessLogicException} - Error de lógica que se genera al no poder actualizar la comrpa porque ya existe uno con ese nombre.
     */
    @PUT
    @Path("{id : \\d+}")
    public ComprasEnTiendaDTO  updateComprasEnTienda( @PathParam("id") long id, ComprasEnTiendaDetailsDTO  comprasEnTienda ) throws BusinessLogicException{
         comprasEnTienda.setId(id);
       ComprasEnTiendaEntity entity = comprasEnTiendaLogic.getCompra(id);
       if( entity == null ){
           throw new WebApplicationException("El recurso /compras /" + id + " no existe", 404);
       }
       return new ComprasEnTiendaDetailsDTO(comprasEnTiendaLogic.updateCompra(id, comprasEnTienda.toEntity()));
    }
    
    /**
     * <h1>DELETE /api/comprasEnTienda/{id} : Borrar la compra dada  por id.</h1>
     * 
     * <pre>Borra la compra con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina la compra correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una compra con el id dado.
     * </code>
     * </pre>
     * @param id Identificador de la compra que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id : \\d+}")
    public void deleteComprasEnTienda( @PathParam("id") Long id ){
        ComprasEnTiendaEntity entity = comprasEnTiendaLogic.getCompra(id);
        if( entity == null ){
            throw new WebApplicationException("El recurso / comprasEnTienda/" + id + " no existe", 404);
        }
        comprasEnTiendaLogic.deleteCompra(id);
    }
    
    
    private List<ComprasEnTiendaDetailsDTO> listComprasEntity2DTO( List<ComprasEnTiendaEntity> entityList){
        List<ComprasEnTiendaDetailsDTO> lista = new ArrayList();
        for( ComprasEnTiendaEntity entity : entityList ){
            lista.add(new ComprasEnTiendaDetailsDTO(entity));
        }
        return lista;
    }
}