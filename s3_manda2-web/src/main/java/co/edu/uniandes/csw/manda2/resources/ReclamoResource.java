/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.resources;

import co.edu.uniandes.csw.manda2.dtos.ReclamoDetailDTO;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author n.bello
 */
@Path("servicios")
@Consumes("application/json")
@Produces("application/json")
public class ReclamoResource {
    @GET
    public List<ReclamoDetailDTO> getReclamos(){
        return null;
    }
    
    @GET
    @Path("{numero : \\d+}")
    public ReclamoDetailDTO getReclamo (@PathParam ("numero") String cedula){
        return null;
    }
    
    
    @POST
    public ReclamoDetailDTO createReclamo( ReclamoDetailDTO reclamo){
        return null;
    }
    
    @PUT
    @Path("{numero : \\d+}")
    public ReclamoDetailDTO updateReclamo (@PathParam("numero") String numero, ReclamoDetailDTO servicio ){
        return null;
    }
    
    @DELETE
    @Path("{cedula : \\d+}")
    public void deleteReclamo( @PathParam("cedula") String cedula ){
        
    }
}
