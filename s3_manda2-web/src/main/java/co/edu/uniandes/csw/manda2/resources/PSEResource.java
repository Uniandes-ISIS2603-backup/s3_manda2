/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.resources;


import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import co.edu.uniandes.csw.manda2.dtos.PSEDTO;
/**
 *
 * @author na.caceres
 */
@Path("pses")
@Produces("application/json")
@Consumes("application/json")

public class PSEResource {

    @GET
    public List<PSEDTO> getPSEs() {
        return null;
    }

    @GET
    @Path("{id : \\d+}")
    public PSEDTO getPSE(@PathParam("id") long id) {
        return null;
    }

    @POST
    public PSEDTO createPSE(PSEDTO pse) {
        return null;
    }

    @PUT
    @Path("{id : \\d+}")
    public PSEDTO updatePSE(@PathParam("id") long id, PSEDTO pse) {
        return null;
    }

    @DELETE
    @Path("{id : \\d+}")
    public void deletePSE(@PathParam("id") long id) {

    }
}
