
import co.edu.uniandes.csw.manda2.DTOS.OrganizacionDetailsDTO;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.Path;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cvtrujillo
 */
@Path ("organizacion")
public class OrganizacionResource 
{
    
    @GET
    @Path("{id : \\\\d+}")
    public List<OrganizacionDetailsDTO> getOrganizacion()
    {
        return null;
    }
    @POST
    public OrganizacionDetailsDTO crearOrganizacion(OrganizacionDetailsDTO servicio)
    {
        return null;
    }
     
    /**
     *
     * @param 
     * @param id
     * @param organizacion
     * @return
     */
    @PUT
    @Path("{id : \\\\d+}")
          
    public OrganizacionDetailsDTO actualizarOrganizacion(@PathParam("id") long id, OrganizacionDetailsDTO organizacion)
    {
        return null;
    }
    
    @DELETE
    @Path("{id : \\\\d+}")
    public void eliminarOrganizacion(@PathParam("id")Long id,OrganizacionDetailsDTO organizacion)
    {
    }
    
    
    

    
}
