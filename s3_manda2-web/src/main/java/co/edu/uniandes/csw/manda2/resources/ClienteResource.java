/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.resources;
import co.edu.uniandes.csw.manda2.dtos.ClienteDetailDTO;
import co.edu.uniandes.csw.manda2.dtos.ClienteDTO;
import co.edu.uniandes.csw.manda2.ejb.ClienteLogic;
import co.edu.uniandes.csw.manda2.entities.ClienteEntity;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
/**
 *
 * <pre>Clase que implementa el recurso "clientes".
 * URL: /api/clientes
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "clientes".</i>
 *
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * </pre>
 *
 *
 * @author na.caceres
 */
@Path("clientes")
@Consumes("application/json")
@Produces("application/json")
@RequestScoped
public class ClienteResource {
    @Inject
    private ClienteLogic clienteLogic;
    /**
     * <h1>GET /api/clientes : Obtener todos los clientes.</h1>
     * 
     * <pre>Busca y devuelve todos los clientes que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todas los clientes de la aplicacion.</code> 
     * </pre>
     * @return  Los clientes encontrados en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<ClienteDetailDTO> getClientes(){
        return listClienteEntityDetailDTO (clienteLogic.getClientes());
    }
    /**
     * <h1>GET /api/clientes/{id} : Obtener un cliente por id.</h1>
     * 
     * <pre>Busca un cliente con el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el cliente correspondiente correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un cliente con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del cliente que se esta buscando. Este debe ser una cadena de dígitos.
     * @return El cliente buscado
     */
    @GET
    @Path("{id : \\d+}")
    public ClienteDetailDTO getCliente(@PathParam ("id") long id){
        ClienteEntity entity = clienteLogic.getCliente(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /clientes/" + id + " no existe.", 404);
        }
        return new ClienteDetailDTO(entity);
    }
    
    /**
     * <h1>POST /api/clientes: Crear un cliente.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link ClienteDTO}.
     * 
     * Crea un nuevo cliente con la información que se recibe en el cuerpo de la petición
     * y se regresa un objeto idéntico con un id auto-generado por la base de datos.
     * 
     * Códigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó el nuevo cliente.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe el cliente.
     * </code>
     * </pre>
     * @param cliente {@link ClienteDTO} - El cliente que se desea guardar.
     * @return JSON {@link ClienteDTO} - El cliente guardado con el atributo id autogenerado.
     */
    @POST
    public ClienteDetailDTO createCliente( ClienteDetailDTO cliente) throws BusinessLogicException{
        return new ClienteDetailDTO(clienteLogic.createCliente(cliente.toEntity()));
    }
    /**
     * <h1>PUT /api/clientes/{id} : Actualizar el cliente con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link ClienteDTO}.
     * 
     * Actualiza el cliente con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza el cliente con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un cliente con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del cliente que se desea actualizar.Este debe ser una cadena de dígitos.
     * @param cliente {@link ClienteDTO} - El cliente que se desea guardar.
     * @return JSON {@link ClienteDTO} - El cliente guardado.
     */
    @PUT
    @Path("{id : \\d+}")
    public ClienteDetailDTO updateCliente (@PathParam("id") long id, ClienteDetailDTO cliente ) throws BusinessLogicException{
        cliente.setId(id);
        ClienteEntity entity = clienteLogic.getCliente(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /clientes/" + id + " no existe.", 404);
        }
        return new ClienteDetailDTO(clienteLogic.updateCliente(id, cliente.toEntity()));
    }
    /**
     * <h1>DELETE /api/clientes/{id} : Borrar un cliente por id.</h1>
     * 
     * <pre>Borra un cliente con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina el cliente correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un cliente con el id dado.
     * </code>
     * </pre>
     * @param id Identificador del clienteque se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id : \\d+}")
    public void deleteCliente( @PathParam("id") long id ){
        ClienteEntity entity = clienteLogic.getCliente(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /clientes/" + id + " no existe.", 404);
        }
        clienteLogic.deleteCliente(id);
    }
    /**
     * Metodo utilizado para convertir una lista de entidades en una lista de detail DTO´s.
    */
    private List<ClienteDetailDTO> listClienteEntityDetailDTO(List<ClienteEntity> entityList) {
        List<ClienteDetailDTO> list = new ArrayList();
        for (ClienteEntity entity : entityList) {
            list.add(new ClienteDetailDTO(entity));
        }
        return list;
    }
}
