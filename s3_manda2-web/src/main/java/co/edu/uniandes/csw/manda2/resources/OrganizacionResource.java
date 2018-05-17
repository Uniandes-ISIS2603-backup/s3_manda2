package co.edu.uniandes.csw.manda2.resources;

//TODO: Borrar los import que no usan
import co.edu.uniandes.csw.manda2.dtos.OrganizacionDTO;
import co.edu.uniandes.csw.manda2.dtos.OrganizacionDetailDTO;
import co.edu.uniandes.csw.manda2.dtos.VueltasConDemoraEnOficinaDetailDTO;
import co.edu.uniandes.csw.manda2.ejb.OrganizacionLogic;
import co.edu.uniandes.csw.manda2.entities.OrganizacionEntity;
import co.edu.uniandes.csw.manda2.entities.VueltasConDemoraEnOficinaEntity;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.Path;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * * <pre>Clase que implementa el recurso "Organizacion".
 * URL: /api/organizacións
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta
 * "/api" y este recurso tiene la ruta "organizacións".</i>
 *
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los organizacións de tipo de organización definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método del organización  tipo Organizacion.
 * </pre>
 *
 * @author cv.trujillo
 */
@Path("organizaciones")
@Consumes("application/json")
@Produces("application/json")
@RequestScoped
public class OrganizacionResource {

    @Inject
    private OrganizacionLogic organizacionLogic;

    /**
     * <h1>GET /api/organizaicin: Obtener todos los organizacións de tipo
     * Organización.</h1>
     *
     * <pre>Busca y devuelve todos los organizacións de tipo Organización que existen en la aplicación.
     *
     * Códigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los organizacións de la aplicacion.</code>
     * </pre>
     *
     * @return JSONArray {@link OrganizacionDetailDTO} - Los servicios
     * encontrados en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    @Path("{id : \\d+}")
    public OrganizacionDetailDTO getOrganizacion(@PathParam("id") long id) {
        OrganizacionDetailDTO nuevo = new OrganizacionDetailDTO(organizacionLogic.getOrganizacion(id));
        if (nuevo == null) {
            throw new WebApplicationException("El recurso /organizaciones/" + id + " no existe.", 404);
        }
        return nuevo;
    }

    /**
     * <h1>GET /api/organizacion/{id} : Obtener organización de organizacion por
     * id.</h1>
     *
     * <pre>Busca el organización con el id asociado recibido en la URL y la devuelve.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el organización de tipo organización correspondiente al id.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un organización de tipo organización con el id dado.
     * </code>
     * </pre>
     *
     * @param id Identificador del organización de tipo organización que se está
     * buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link OrganizacionDetailDTO} - El organización buscada
     */
    @GET
    public List<OrganizacionDetailDTO> getorganizacionBusquedas() {

        return listorganizacions(organizacionLogic.getOrganizaciones());

    }
//TODO: Revisar este código. De qué se trata?
    //DONE: Es para tener una lista de las organizaciones, el código está escrito de forma acortada
    private List<OrganizacionDetailDTO> listorganizacions(List<OrganizacionEntity> entityList) {

        return listVueltas2DTO(organizacionLogic.getOrganizaciones());

    }

    /**
     * <h1>POST /api/organizacion: Crear un organización de tipo
     * Organización.</h1>
     *
     * <pre>Cuerpo de petición: JSON {@link organizaciónDTO}.
     * <pre>Cuerpo de petición: JSON {@link OrganizacionDetailDTO}.
     *
     * Crea un nuevo organización de tipo Organización con la información que se recibe en el cuerpo de la petición
     * y se regresa un objeto idéntico con un id auto-generado por la base de datos.
     *
     * Códigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó el nuevo organización de tipo Organización.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe el organización de tipo Organización.
     * </code>
     * </pre>
     *
     * @param organizacion {@link OrganizacionDetailDTO} - El servicio de tipo
     * Organización que se desea guardar.
     * @return JSON {@link OrganizacionDetailDTO} - El servicio de tipo
     * Organización fue guardado con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicException} - Error de
     * lógica que se genera cuando ya existe el servicio de tipo Organización.
     *
     */
    @POST
    public OrganizacionDetailDTO crearOrganizacion(OrganizacionDetailDTO organizacion) throws BusinessLogicException {
        return new OrganizacionDetailDTO(organizacionLogic.createOrganizacion(organizacion.toEntity()));
    }

    /**
     * /**
     *
     * <h1>PUT /api/organizacion/{id} : Actualizar servicio de tipo Organización
     * con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link OrganizacionDetailDTO}.
     *
     *
     * Actualiza el organización de tipo Organización con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza el organización de tipo Organización con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un organización de tipo Organización con el id dado.
     * </code>
     * </pre>
     *
     * @param id Identificador del organización de tipo Organización que se
     * desea actualizar. Este debe ser una cadena de dígitos.
     * @param organizacion la organizacion
     * @return JSON {@link OrganizacionDetailDTO} - El servicio de tipo
     * Organización guardado.
     * @throws BusinessLogicException {@link BusinessLogicException} - Error de
     * lógica que se genera al no poder actualizar el servicio de tipo
     * Organización porque ya existe uno con ese nombre.
     */
    @PUT
    @Path("{id : \\d+}")

    public OrganizacionDetailDTO actualizarOrganizacion(@PathParam("id") Long id, OrganizacionDetailDTO organizacion) throws BusinessLogicException {
        OrganizacionEntity entity = organizacionLogic.getOrganizacion(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /organizacions/" + id + " no existe.", 404);
        }
        return new OrganizacionDetailDTO(organizacionLogic.updateOrganizacion(id, organizacion.toEntity()));

    }

    /**
     * <h1>DELETE /api/organizacion/{id} : Borrar organización de tipo
     * Organización por id.</h1>
     *
     * <pre>Borra el organización de tipo Organización con el id asociado recibido en la URL.
     *
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina el organización de tipo Organización correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un organización de tipo Organización con el id dado.
     * </code>
     * </pre>
     *
     * @param id Identificador del organización de tipo Organización que se
     * desea borrar. Este debe ser una cadena de dígitos.
     * @param organizacion la organizacion
     */
    @DELETE
    @Path("{id : \\d+}")
    public void eliminarOrganizacion(@PathParam("id") Long id, OrganizacionDTO organizacion) {
        OrganizacionEntity entity = organizacionLogic.getOrganizacion(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /organizaciones/" + id + " no existe.", 404);
        }
        organizacionLogic.deleteOrganizacion(id);
    }

    private List<OrganizacionDetailDTO> listVueltas2DTO( List<OrganizacionEntity> entityList){
        List<OrganizacionDetailDTO> lista = new ArrayList();
        for( OrganizacionEntity entity : entityList ){
            lista.add(new OrganizacionDetailDTO(entity));
        }
        return lista;
    }
}
