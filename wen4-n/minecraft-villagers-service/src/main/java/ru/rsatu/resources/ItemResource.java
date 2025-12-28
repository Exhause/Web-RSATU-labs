package ru.rsatu.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ru.rsatu.dtos.ItemSaveDto;
import ru.rsatu.services.ItemService;

import java.util.Map;

@Path("/items")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ItemResource {
    @Inject
    private ItemService itemService;

    @POST
    public Response createItem(ItemSaveDto itemSaveDto) {
        return Response
                .status(Response.Status.CREATED)
                .entity(Map.of("id", itemService.createItem(itemSaveDto)))
                .build();
    }

    @GET
    public Response getAllItems() {
        return Response
                .ok(itemService.getAllItems())
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteItem(@PathParam("id") Long id) {
        return Response
                .ok()
                .build();
    }
}
