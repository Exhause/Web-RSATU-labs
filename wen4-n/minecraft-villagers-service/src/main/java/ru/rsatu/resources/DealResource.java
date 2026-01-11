package ru.rsatu.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ru.rsatu.dtos.DealDto;
import ru.rsatu.dtos.DealSaveDto;
import ru.rsatu.services.DealService;

import java.util.List;

@Path("/deals")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DealResource {
    @Inject
    private DealService dealService;

    @POST
    public DealDto createDeal(DealSaveDto dealSaveDto) {
        return dealService.createDeal(dealSaveDto);
    }

    @GET
    public List<DealDto> getAllDeals() {
        return dealService.getAllDeals();
    }

    @PUT
    public DealDto updateDeal(DealSaveDto dealSaveDto) {
        return dealService.updateDeal(dealSaveDto);
    }

    @DELETE
    @Path("/{id}")
    public void deleteDeal(@PathParam("id") Long id) {
        dealService.deleteDeal(id);
    }
}
