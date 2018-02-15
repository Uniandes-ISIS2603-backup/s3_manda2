package co.edu.uniandes.csw.manda2.resources;

import co.edu.uniandes.csw.manda2.dtos.PayPalDTO;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.manda2.mappers.BusinessLogicExceptionMapper;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;

/**
 * <pre>Clase que implementa el recurso "paypals".
 * URL: /api/paypals
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "paypals".</i>
 *
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * </pre>
 * @author da.ramos
 */
@Path("paypals")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class PayPalResource {
    

    /**
     * <h1>GET /api/paypals : Obtener todos los PayPals.</h1>
     * 
     * <pre>Busca y devuelve todos los PayPals que existen en la aplicación.
     * 
     * Códigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los PayPals de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link PayPalDTO} - Los PayPals encontrados en la aplicación. Si no hay ninguno retorna una lista vacía.
     */
    @GET
    public List<PayPalDTO> getPayPals(){
        return new ArrayList<>();
    }
    
     /**
     * <h1>GET /api/paypals/{id} : Obtener PayPal por id.</h1>
     * 
     * <pre>Busca el PayPal con el id asociado recibido en la URL y la devuelve.
     * 
     * Códigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el PayPal correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un PayPal con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del PayPal que se está buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link PayPalDTO} - El PayPal buscado
     */
    @GET
    @Path("{id: \\d+}")
    public PayPalDTO getPayPal(@PathParam("id") long id){
        return null;
    }
    
     /**
     * <h1>POST /api/paypals : Crear un paypal.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link PayPalDTO}.
     * 
     * Crea un nuevo PayPal con la información que se recibe en el cuerpo de la petición
     * y se regresa un objeto idéntico con un id auto-generado por la base de datos.
     * 
     * Códigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó el nuevo PayPal.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe el PayPal.
     * </code>
     * </pre>
     * @param payPal {@link PayPalDTO} - El PayPal que se desea guardar.
     * @return JSON {@link PayPalDTO} - El PayPal guardado con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe el PayPal.
     */
    @POST
    public PayPalDTO createPayPal(PayPalDTO payPal) throws BusinessLogicException{
        return payPal;
    }
    
     /**
     * <h1>PUT /api/paypals/{id} : Actualizar PayPal con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link CityDetailDTO}.
     * 
     * Actualiza el PayPal con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza el PayPal con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un PayPal con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del PayPal que se desea actualizar. Este debe ser una cadena de dígitos.
     * @param payPal {@link PayPalDTO} El PayPal que se desea guardar.
     * @return JSON {@link PayPalDTO} - El PayPal guardado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar el PayPal porque ya existe uno con ese nombre.
     */
    @PUT
    @Path("{id: \\d+}")
    public PayPalDTO updatePayPal(@PathParam("id") long id, PayPalDTO payPal) throws BusinessLogicException{
        return payPal;
    }
    
    /**
     * <h1>DELETE /api/paypals/{id} : Borrar PayPal por id.</h1>
     * 
     * <pre>Borra el PayPal con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina el PayPal correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un PayPal con el id dado.
     * </code>
     * </pre>
     * @param id Identificador del PayPal que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deletePayPal(@PathParam("id") long id){
        
    }
}
