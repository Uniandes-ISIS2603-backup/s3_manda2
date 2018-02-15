/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.resources;
import co.edu.uniandes.csw.manda2.dtos.ClienteDetailDTO;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
/**
 *
 * @author na.caceres
 */
@Path("clientes")
@Consumes("application/json")
@Produces("application/json")
@RequestScoped
public class ClienteResource {
    
    @GET
    public List<ClienteDetailDTO> getClientes(){
        return new ArrayList<>();
    }
    
    @GET
    @Path("{cedula : \\d+}")
    public ClienteDetailDTO getCliente(@PathParam ("cedula") String cedula){
        return null;
    }
    
    
    @POST
    public ClienteDetailDTO createCliente( ClienteDetailDTO cliente){
        return null;
    }
    
    @PUT
    @Path("{cedula : \\d+}")
    public ClienteDetailDTO updateCliente (@PathParam("cedula") String cedula, ClienteDetailDTO servicio ){
        return null;
    }
    
    @DELETE
    @Path("{cedula : \\d+}")
    public void deleteCliente( @PathParam("cedula") String cedula ){
        
    }
}
