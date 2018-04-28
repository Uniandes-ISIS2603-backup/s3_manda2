/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.resources;

import co.edu.uniandes.csw.manda2.dtos.BilleteraDTO;
import co.edu.uniandes.csw.manda2.dtos.BilleteraDetailDTO;
import co.edu.uniandes.csw.manda2.ejb.BilleteraLogic;
import co.edu.uniandes.csw.manda2.entities.BilleteraEntity;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
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
 *
 * @author m.moreno
 */

@Path("billeteras")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class BilleteraResource {

    @Inject
    private BilleteraLogic billeteraLogic;


    /**
     * <h1>GET /api/billeteras/{id} : Obtener billetera por id.</h1>
     *
     * <pre>Busca la billetera con el id asociado recibido en la URL y la devuelve.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve la billetera correspondiente al id.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe una billetera con el id dado.
     * </code>
     * </pre>
     *
     * @param id id  de la billetera
     * @return JSON {@link BilleteraDetailDTO} - La billetera buscada
     */
    @GET
    @Path("{id: \\d+}")
    public BilleteraDetailDTO getBilletera(@PathParam("id") Long id) {
        BilleteraEntity entity = billeteraLogic.getBilletera(id);

        if (entity == null) {
            throw new WebApplicationException("El recurso /billeteras/" + id + " no existe.", 404);
        }
        return new BilleteraDetailDTO(entity);
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
     *
     * @return JSONArray {@link BilleteraDetailDTO} - Las billeteras encontradas en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<BilleteraDetailDTO> getBilletera() {
        return listBilleteraEntityDetailDTO(billeteraLogic.getBilleteras());
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
     *
     * @param billetera {@link BilleteraDetailDTO} - La billetera que se desea guardar.
     * @return JSON {@link BilleteraDetailDTO}  - La billetera guardada con el atributo id autogenerado.
     */
    @POST
    public BilleteraDetailDTO createBilletera(BilleteraDetailDTO billetera) throws BusinessLogicException {
        return new BilleteraDetailDTO(billeteraLogic.createBilletera(billetera.toEntity()));
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
     *
     * @param id        id de la persona
     * @param billetera {@link BilleteraDetailDTO} La billetera que se desea guardar.
     * @return JSON {@link BilleteraDetailDTO} - La billetera guardada.
     */
    @PUT
    @Path("{id : \\d+}")
    public BilleteraDetailDTO updateBilletera(@PathParam("id") Long id, BilleteraDetailDTO billetera) throws BusinessLogicException {
        billetera.setId(id);
        BilleteraEntity entity = billeteraLogic.getBilletera(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /billeteras/" + id + " no existe.", 404);
        }
        return new BilleteraDetailDTO(billeteraLogic.updateBilletera(id, billetera.toEntity()));
    }

    /**
     * <h1>DELETE /api/billeteras/{id} : Borrar billetera por id.</h1>
     *
     * <pre>Borra la billetera con el id asociado recibido en la URL.
     *
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina la billetera correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una billetera con el id dado.
     * </code>
     * </pre>
     *
     * @param id de la billetera
     */
    @DELETE
    @Path("{id : \\d+}")
    public void deleteBilletera(@PathParam("id") Long id) {
        BilleteraEntity entity = billeteraLogic.getBilletera(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /billeteras/" + id + " no existe.", 404);
        }
        billeteraLogic.deleteBilletera(id);
    }


    private List<BilleteraDetailDTO> listBilleteraEntityDetailDTO(List<BilleteraEntity> billeteraList) {
        List<BilleteraDetailDTO> list = new ArrayList<>();
        for (BilleteraEntity entity : billeteraList) {
            list.add(new BilleteraDetailDTO(entity));
        }
        return list;
    }
}
