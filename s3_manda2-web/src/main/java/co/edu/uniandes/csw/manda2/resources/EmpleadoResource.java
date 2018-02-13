/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.resources;

import co.edu.uniandes.csw.manda2.dtos.ClienteDetailDTO;
import co.edu.uniandes.csw.manda2.dtos.EmpleadoDetailDTO;
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
@Path("empleados")
@Consumes("application/json")
@Produces("application/json")
public class EmpleadoResource {


    @GET
    public List<EmpleadoDetailDTO> getEmpleados(){
        return null;
    }
    
    @GET
    @Path("{cedula : \\d+}")
    public EmpleadoDetailDTO getEmpleado(@PathParam ("cedula") String cedula){
        return null;
    }
    
    
    @POST
    public EmpleadoDetailDTO createEmpleado( EmpleadoDetailDTO cliente){
        return null;
    }
    
    @PUT
    @Path("{cedula : \\d+}")
    public EmpleadoDetailDTO updateEmpleado (@PathParam("cedula") String cedula, ClienteDetailDTO servicio ){
        return null;
    }
    
    @DELETE
    @Path("{cedula : \\d+}")
    public void deleteEmpleado( @PathParam("cedula") String cedula ){
        
    }
}
