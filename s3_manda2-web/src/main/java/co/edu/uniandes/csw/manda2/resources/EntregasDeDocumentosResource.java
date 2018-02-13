/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.resources;

import co.edu.uniandes.csw.manda2.dtos.EntregasDeDocumentosDTO;
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

@Path("entregasDeDocumentosResource")
@Produces("application/json")
@Consumes("application/json")
/**
 *
 * @author dv.gonzalez10
 */
public class EntregasDeDocumentosResource {
    
     @GET
    public List<EntregasDeDocumentosDTO> getEntregasDeDocumentos(){
        return new ArrayList <> ();
    }
    
    @GET
    @Path("{id : \\d+}")
    public EntregasDeDocumentosDTO getEntregaDeDocumentos(@PathParam("id") long id){
        return null;
    }
    
     @POST
    public EntregasDeDocumentosDTO createEntregasDeDocumentos( EntregasDeDocumentosDTO entregasDeDocumentos){
        return entregasDeDocumentos;
    }
    
    @PUT
    @Path("{id : \\d+}")
    public EntregasDeDocumentosDTO updateEntregasDeDocumentos( @PathParam("id") long id, EntregasDeDocumentosDTO  entregasDeDocumentos ){
        return entregasDeDocumentos;

    }
    
    @DELETE
    @Path("{id : \\d+}")
    public void deleteEntregasDeDocumentos( @PathParam("id") Long id ){
        
    }
}
