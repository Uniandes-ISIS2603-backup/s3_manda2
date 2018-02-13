/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.resources;
import co.edu.uniandes.csw.manda2.dtos.BilleteraDetailDTO;
import java.util.List;
import javax.ws.rs.*;
/**
 *
 * @author m.moreno
 */

@Path("billeteras")
@Produces("application/json")
@Consumes("application/json")

public class BilleteraResource {
    
    @GET
    @Path("{cedula: \\d+}")
    public BilleteraDetailDTO getSaldo(@PathParam("cedula") String cedula){
        return null;
    }
    
    
    @GET
    public BilleteraDetailDTO getBilletera(){
        return null;
    }
    
    
    @POST
    public BilleteraDetailDTO createBilletera(BilleteraDetailDTO billetera){
        return null;
    }
    
    @PUT
    @Path("{cedula : \\d+}")
    public BilleteraDetailDTO updateBilletera(@PathParam("cedula") String cedula, BilleteraDetailDTO billtera){
        return null;
    }
    
    @DELETE
    @Path("{cedula : \\d+}")
    public void deleteBilletera(@PathParam("cedula") String cedula){
        
    }
 
}
