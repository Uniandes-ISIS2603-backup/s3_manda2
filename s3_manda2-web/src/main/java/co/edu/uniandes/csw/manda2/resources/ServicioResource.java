/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.resources;

import co.edu.uniandes.csw.manda2.dtos.ServicioDetailDTO;
import java.util.List;
import javax.ws.rs.*;

/**
 *
 * @author da.ramos
 */
@Path("servicios")
public class ServicioResource {
    
    @GET
    public List<ServicioDetailDTO> getServicios(){
        return null;
    }
    
    /**
     *
     * @param id
     * @return
     */
    @GET
    @Path("{id : \\d+}")
    public ServicioDetailDTO getServicio(@PathParam ("id") long id){
        return null;
    }
    
    
    @POST
    public ServicioDetailDTO createServicio( ServicioDetailDTO servicio){
        return null;
    }
    
    @PUT
    @Path("{id : \\d+}")
    public ServicioDetailDTO updateServicio( @PathParam("id") long id, ServicioDetailDTO servicio ){
        return null;
    }
    
    @DELETE
    @Path("{id : \\d+}")
    public void deleteServicio( @PathParam("id") long id ){
        
    }
}
