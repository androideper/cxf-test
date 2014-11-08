package com.mycompany.server;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
    Item getItem(@NotNull @PathParam("id") String id);

    @PUT
    @Path("/items/")
    Response updateItem(@Valid Item item);

    @POST
    @Path("/items/")
    Response addItem(@Valid Item item);

    @DELETE
    @Path("/items/{id}/")
    Response deleteItem(@NotNull @PathParam("id") String id);
}
