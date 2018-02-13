/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.resources;

import co.edu.uniandes.csw.manda2.dtos.ComprasEnTiendaDTO;
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
 ** <pre>Clase que implementa el recurso "comprasEnTiendaResource".
 * URL: /api/comprasEnTiendaResource
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "comprasEnTiendaResource".</i>
 *
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio). 
 * </pre>
 * @author dv.gonzalez10
 */
@Path("comprasEnTienda")
@Produces("application/json")
@Consumes("application/json")
public class ComprasEnTiendaResource {
    
     @GET
    public List<ComprasEnTiendaDTO> getComprasEnTienda(){
        return new ArrayList <> ();
    }
    
    @GET
    @Path("{id : \\d+}")
    public ComprasEnTiendaDTO getComprasEnTienda(@PathParam("id") long id){
        return null;
    }
    
    @POST
    public ComprasEnTiendaDTO createComprasEnTienda( ComprasEnTiendaDTO comprasEnTienda){
        return comprasEnTienda;
    }
    
    @PUT
    @Path("{id : \\d+}")
    public ComprasEnTiendaDTO  updateComprasEnTienda( @PathParam("id") long id, ComprasEnTiendaDTO  comprasEnTienda ){
        return comprasEnTienda;

    }
    
    
    @DELETE
    @Path("{id : \\d+}")
    public void deleteComprasEnTienda( @PathParam("id") Long id ){
        
    }
    
}
