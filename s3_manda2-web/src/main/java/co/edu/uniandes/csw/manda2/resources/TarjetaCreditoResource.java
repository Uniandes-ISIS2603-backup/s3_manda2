/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.resources;
import co.edu.uniandes.csw.manda2.dtos.PSEDTO;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import co.edu.uniandes.csw.manda2.dtos.TarjetaCreditoDTO;
/**
 *
 * @author na.caceres
 */
@Path("tarjetascredito")
@Produces("application/json")
@Consumes("application/json")
public class TarjetaCreditoResource {
   @GET
    public List<TarjetaCreditoDTO> getTarjetasCreditos() {
        return null;
    }

    @GET
    @Path("{id : \\d+}")
    public TarjetaCreditoDTO getTarjetaCredito(@PathParam("id") long id) {
        return null;
    }

    @POST
    public TarjetaCreditoDTO createTarjetaCredito(TarjetaCreditoDTO tarjetaCredito) {
        return null;
    }

    @PUT
    @Path("{id : \\d+}")
    public TarjetaCreditoDTO updateTarjetaCredito (@PathParam("id") long id, TarjetaCreditoDTO tarjetaCredito) {
        return null;
    }

    @DELETE
    @Path("{id : \\d+}")
    public void deleteTarjetaCredito(@PathParam("id") long id) {

    } 
}
