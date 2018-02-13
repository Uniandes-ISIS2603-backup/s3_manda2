/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.resources;

import co.edu.uniandes.csw.manda2.dtos.VueltasConDemoraEnOficinaDTO;
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


/**
 *
 * @author dv.gonzalez10
 */
@Path("vueltasConDemoraEnOficina")
@Produces("application/json")
@Consumes("application/json")
public class VueltasConDemoraEnOficinaResource {

    @GET
    public List<VueltasConDemoraEnOficinaDTO> getVueltasConDemoraEnOficina(){
        return new ArrayList <> ();
    }
    
    @GET
    @Path("{id : \\d+}")
    public VueltasConDemoraEnOficinaDTO getVueltaConDemoraEnOficina(@PathParam("id") long id){
        return null;
    }
    
    @POST
    public VueltasConDemoraEnOficinaDTO createVueltaConDemoraEnOficina( VueltasConDemoraEnOficinaDTO vueltaConDemoraEnOficina){
        return vueltaConDemoraEnOficina;
    }
    
    @PUT
    @Path("{id : \\d+}")
    public VueltasConDemoraEnOficinaDTO  updateVueltaConDemoraEnOficina( @PathParam("id") long id, VueltasConDemoraEnOficinaDTO  vueltaConDemoraEnOficina ){
        return vueltaConDemoraEnOficina;

    }
    
    
    @DELETE
    @Path("{id : \\d+}")
    public void deleteVueltaConDemoraEnOficina( @PathParam("id") Long id ){
        
    }
    
}
