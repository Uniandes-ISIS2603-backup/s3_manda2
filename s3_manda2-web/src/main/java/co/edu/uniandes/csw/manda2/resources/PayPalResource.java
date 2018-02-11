/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.resources;

import co.edu.uniandes.csw.manda2.dtos.PayPalDTO;
import java.util.List;
import javax.ws.rs.*;

/**
 *
 * @author da.ramos
 */
@Path("paypal")
@Produces("application/json")
@Consumes("application/json")
public class PayPalResource {
    
    @GET
    public List<PayPalDTO> getPayPals(){
        return null;
    }
    
    @GET
    @Path("{id : \\d+}")
    public PayPalDTO getPayPal(@PathParam("id") long id){
        return null;
    }
    
    @POST
    public PayPalDTO createPayPal(PayPalDTO payPal){
        return null;
    }
    
    @PUT
    @Path("{id : \\d+}")
    public PayPalDTO updatePayPal(@PathParam("id") long id, PayPalDTO payPal){
        return null;
    }
    
    @DELETE
    @Path("{id : \\d+}")
    public void deletePayPal(@PathParam("id") long id){
        
    }
}
