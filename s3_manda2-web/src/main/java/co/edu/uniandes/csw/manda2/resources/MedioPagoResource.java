/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.resources;
import co.edu.uniandes.csw.manda2.dtos.MedioPagoDTO;
import java.util.List;
import javax.ws.rs.*;

/**
 *
 * @author m.moreno
 */

 @Path("mediospago")
@Produces("application/json")
@Consumes("application/json")
public class MedioPagoResource {
    
    

    
    @GET
    @Path("{id: \\d+}")
    public MedioPagoDTO getMedioPago(@PathParam("id") long id){
        return null;
    }
    
    
    @GET
    public List<MedioPagoDTO> getMediosPago(){
        return null;
    }
    
    
    @POST
    public MedioPagoDTO createMedioPago(MedioPagoDTO medioPago){
        return null;
    }
    
    @PUT
    @Path("{id : \\d+}")
    public MedioPagoDTO updateMedioPago(@PathParam("id") long id, MedioPagoDTO medioPago){
        return null;
    }
    
    @DELETE
    @Path("{id : \\d+}")
    public void deleteMedioPago(@PathParam("id") long id){
        
    }
 
}