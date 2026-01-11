package ru.rsatu.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ru.rsatu.dtos.ItemDto;
import ru.rsatu.dtos.ItemSaveDto;
import ru.rsatu.services.ItemService;

import java.util.List;

@Path("/items")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ItemResource {
    @Inject
    private ItemService itemService;

    @POST
    public ItemDto createItem(ItemSaveDto itemSaveDto) {
        return itemService.createItem(itemSaveDto);
    }

    @GET
    public List<ItemDto> getAllItems() {
        return itemService.getAllItems();
    }

    @DELETE
    @Path("/{id}")
    public void deleteItem(@PathParam("id") Long id) {
        itemService.deleteItem(id);
    }
}
