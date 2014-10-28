package com.mycompany.server;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 */
@Path("/tests")
@Produces("application/json")
@Consumes("application/json")
public interface TestResource {
    @GET
    @Path("/items/")
    List<Item> getItems();

    @GET
    @Path("/items/{id}/")
    Item getItem(@PathParam("id") String id);

    @PUT
    @Path("/items/")
    Response updateItem(Item item);

    @POST
    @Path("/items/")
    Response addItem(Item item);

    @DELETE
    @Path("/items/{id}/")
    Response deleteItem(@PathParam("id") String id);
}
