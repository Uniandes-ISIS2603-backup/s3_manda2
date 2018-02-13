/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.resources;

import co.edu.uniandes.csw.manda2.dtos.PagoDetailDTO;
import java.util.List;
import javax.ws.rs.*;

/**
 *
 * @author m.moreno
 */

@Path("pago")
@Produces("application/json")
@Consumes("application/json")

public class PagoResource {
    
    @POST
    public PagoDetailDTO createPago (PagoDetailDTO pago){
        return null;
    }
    
    @GET
    public List<PagoDetailDTO> getPagos(){
        return null;
    }
    
    @GET
    @Path("{id: \\d+}")
    public PagoDetailDTO getPagoId(@PathParam("id") Long id){
        return null;
    }
    
    
    @PUT 
    @Path("{estado: \\d+}")
    public PagoDetailDTO updateEstado(@PathParam("estado") String estado, PagoDetailDTO pago){
        return null;
    }
    
    @DELETE
    @Path("{id : \\d+}")
    public void eliminarPago(@PathParam("id") long id)
    {
    }
}
