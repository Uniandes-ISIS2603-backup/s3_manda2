/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.resources;

import co.edu.uniandes.csw.manda2.dtos.EmpleadoDetailDTO;
import co.edu.uniandes.csw.manda2.ejb.EmpleadoLogic;
import co.edu.uniandes.csw.manda2.entities.EmpleadoEntity;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.inject.Inject;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.WebApplicationException;

/**
 *  <pre>Clase que implementa el recurso "empleados".
 * URL: /api/empleados
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "empleados".</i>
 *
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * </pre>
 * @author n.bello
 */
@Path("empleados")
@Consumes("application/json")
@Produces("application/json")
@RequestScoped
public class EmpleadoResource {
    @Inject
    private EmpleadoLogic logic;
    /**
     * <h1>GET /api/empleados : Obtener todos los empleados.</h1>
     * 
     * <pre>Busca y devuelve todos los empleados que existen en la aplicación.
     * 
     * Códigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los empleados de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link EmpleadoDetailDTO} - Los empleados encontrados en la aplicación. Si no hay ninguno retorna una lista vacía.
     */
    @GET
    public List<EmpleadoDetailDTO> getEmpleados(){
        return listEmpleafoEntityDTO (logic.getEmpleados());
    }
     /**
     * <h1>GET /api/empleados/{cedula} : Obtener empleado por cedula.</h1>
     * 
     * <pre>Busca el empleado con la cedula asociado recibido en la URL y la devuelve.
     * 
     * Códigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el empleado correspondiente a la cedula.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un empleado con la cedula dada.
     * </code> 
     * </pre>
     * @param id Identificador del cedula que se está buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link EmpleadoDetailDTO} - El empleado buscado
     */
    @GET
    @Path("{id : \\d+}")
    public EmpleadoDetailDTO getEmpleado(@PathParam ("id") Long id){
        EmpleadoEntity entity = logic.getEmpleado(id);
        if(entity == null)
        {
            throw new WebApplicationException("El recurso /empleados/" + id + " no existe.", 404);
        }
        return new EmpleadoDetailDTO(entity);
    }
    
    /**
     * <h1>POST /api/empleados : Crear un empleado.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link EmpleadoDetailDTO}.
     * 
     * Crea un nuevo empleado con la información que se recibe en el cuerpo de la petición
     * y se regresa un objeto idéntico con un id auto-generado por la base de datos.
     * 
     * Códigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó el nuevo empleado.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe el empleado.
     * </code>
     * </pre>
     * @param empleado {@link EmpleadoDetailDTO} - El empleado que se desea guardar.
     * @return JSON {@link EmpleadoDetailDTO} - El empleado guardado con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicException} - Error de lógica que se genera cuando ya existe el PayPal.
     */
    @POST
    public EmpleadoDetailDTO createEmpleado( EmpleadoDetailDTO empleado)throws BusinessLogicException{
        return new EmpleadoDetailDTO (logic.createEmpleado(empleado.toEntity()));
    }
    /**
     * <h1>PUT /api/empleados/{cedula} : Actualizar empleado con la cedula dada.</h1>
     * <pre>Cuerpo de petición: JSON {@link EmpleadoDetailDTO}.
     * 
     * Actualiza el empelado con la cedula recibida en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza el empleado con la cedula dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un PayPal con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del empleado que se desea actualizar. Este debe ser una cadena de dígitos.
     * @param empleado {@link EmpleadoDetailDTO} El empleado que se desea guardar.
     * @return JSON {@link EmpleadoDetailDTO} - El empleado guardado.
     * @throws BusinessLogicException {@link BusinessLogicException} - Error de lógica que se genera al no poder actualizar el PayPal porque ya existe uno con ese nombre.
     */
    @PUT
    @Path("{id : \\d+}")
    public EmpleadoDetailDTO updateEmpleado (@PathParam("id") Long id, EmpleadoDetailDTO empleado )throws BusinessLogicException{
       empleado.setId(id);
       EmpleadoEntity entity = logic.getEmpleado(id);
       if (entity == null) {
           throw new WebApplicationException("El recurso /empleados/" + id + " no existe.", 404);
       }
        return  new EmpleadoDetailDTO(logic.updateEmpleado(id, empleado.toEntity()));
    }
    /**
     * <h1>DELETE /api/empleados/{cedula} : Borrar empleado por cedula.</h1>
     * 
     * <pre>Borra el empleado con la cedula asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina el empelado correspondiente a la cedula dada.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un empelado con la cedula dad.
     * </code>
     * </pre>
     * @param id Identificador del empleado que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id : \\d+}")
    public void deleteEmpleado( @PathParam("id") Long id ){
        EmpleadoEntity entity = logic.getEmpleado(id);
        if (entity == null) {
           throw new WebApplicationException("El recurso /empleados/" + id + " no existe.", 404);
       }
        logic.deleteEmpleado(id);
    }

    private List<EmpleadoDetailDTO> listEmpleafoEntityDTO(List<EmpleadoEntity> empleados) {
        List<EmpleadoDetailDTO> list = new ArrayList();
        for (EmpleadoEntity entity : empleados)
        {
            list.add( new EmpleadoDetailDTO(entity));
        }
        return list;
    }
}
