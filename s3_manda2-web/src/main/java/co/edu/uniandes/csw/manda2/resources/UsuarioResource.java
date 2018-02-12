/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.resources;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import co.edu.uniandes.csw.manda2.dtos.UsuarioDTO;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

/**
 *
 * @author n.bello
 */
@Path("Usuarios")
@Consumes("application/json")
@Produces("application/json")
public class UsuarioResource {
    @GET
    public List<UsuarioDTO> getUsuarios()
    {
        return null;
    }
    @GET
    @Path ("{cedula : \\d+}")
    public UsuarioDTO getUsuario (@PathParam ("cedula") String cedula)
    {
        retrun null;
    }
     @POST
    public UsuarioDTO createUsuario( UsuarioDTO usuario){
        return null;
    }
    
    @PUT
    @Path("{cedula : \\d+}")
    public UsuarioDTO updateUsuario (@PathParam("cedula") String cedula){
        return null;
    }
    
    @DELETE
    @Path("{cedula : \\d+}")
    public void deleteUsuario( @PathParam("cedula") String cedula ){
        
    }
}
