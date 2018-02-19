/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.resources;
import co.edu.uniandes.csw.manda2.dtos.BilleteraDetailDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.*;
/**
 * <pre>Clase que implementa el recurso "billeteras".
 * URL: /api/billeteras 
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "billeteras".</i>
 *
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio). 
 * </pre>
 * @author m.moreno
 */

@Path("billeteras")
@Produces("application/json")
@Consumes("application/json")

public class BilleteraResource {
    
    
    
        /**
     * <h1>GET /api/billeteras/{cedula} : Obtener billetera por cedula.</h1>
     * 
     * <pre>Busca la billetera con la cedula asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve la billetera correspondiente a la cedula.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe una billetera con la cedula dada.
     * </code> 
     * </pre>
     * @param cedula cedula de la persona
     * @return JSON {@link BilleteraDetailDTO} - La ciudad buscada
     */
    @GET
    @Path("{cedula: \\d+}")
    public BilleteraDetailDTO getSaldo(@PathParam("cedula") String cedula){
        return null;
    }
    
      /**
     * <h1>GET /api/billeteras : Obtener todas las billeteras.</h1>
     * 
     * <pre>Busca y devuelve todas las billeteras que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todas las billeteras de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link BilleteraDetailDTO} - Las billeteras encontradas en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<BilleteraDetailDTO> getBilletera(){
        return new ArrayList<>();
    }
    
      /**
     * <h1>POST /api/billeteras : Crear una billetera.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link BilleteraDetailDTO}.
     * 
     * Crea una nueva billetera con la informacion que se recibe en el cuerpo 
     * de la petición y se regresa un objeto identico con un id auto-generado 
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó la nueva billetera .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe la billetera.
     * </code>
     * </pre>
     * @param billetera {@link BilleteraDetailDTO} - La billetera que se desea guardar.
     * @return JSON {@link BilleteraDetailDTO}  - La billetera guardada con el atributo id autogenerado.
     */
    @POST
    public BilleteraDetailDTO createBilletera(BilleteraDetailDTO billetera){
        return null;
    }
    
    
        /**
     * <h1>PUT /api/billeteras/{id} : Actualizar billetera con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link BilleteraDetailDTO}.
     * 
     * Actualiza la billetera con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza la billetera con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una billetera con el id dado.
     * </code> 
     * </pre>
     * @param cedula cedula de la persona
     * @param billetera {@link BilleteraDetailDTO} La billetera que se desea guardar.
     * @return JSON {@link BilleteraDetailDTO} - La billetera guardada.
     */
    @PUT
    @Path("{cedula : \\d+}")
    public BilleteraDetailDTO updateBilletera(@PathParam("cedula") String cedula, BilleteraDetailDTO billetera){
        return null;
    }
    
       /**
     * <h1>DELETE /api/billeteras/{cedula} : Borrar billetera por cedula.</h1>
     * 
     * <pre>Borra la billetera con el cedula asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina la billetera correspondiente al cedula dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una billetera con el cedula dado.
     * </code>
     * </pre>
     * @param cedula cedula de la persona
     */
    @DELETE
    @Path("{cedula : \\d+}")
    public void deleteBilletera(@PathParam("cedula") String cedula){
        
    }
 
}
