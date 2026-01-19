package ru.rsatu.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ru.rsatu.dtos.VillagerDto;
import ru.rsatu.dtos.VillagerSaveDto;
import ru.rsatu.services.VillagerService;

@Path("/villagers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VillagerResource {
    @Inject
    private VillagerService villagerService;

    @POST
    public VillagerDto createVillager(VillagerSaveDto villagerSaveDto) {
        return villagerService.createVillager(villagerSaveDto);
    }

    @POST
    @Path("/{villagerId}/deals/{dealId}")
    public void addDealToVillager(@PathParam("villagerId") Long villagerId, @PathParam("dealId") Long dealId) {
        villagerService.addDealToVillager(villagerId, dealId);
    }

    @GET
    @Path("/{id}")
    public VillagerDto getVillagerById(@PathParam("id") Long villagerId) {
        return villagerService.getVillagerById(villagerId);
    }

    @PUT
    public VillagerDto updateVillager(VillagerSaveDto villagerSaveDto) {
        return villagerService.updateVillager(villagerSaveDto);
    }

    @DELETE
    @Path("/{villagerId}/deals/{dealId}")
    public void removeDealFromVillager(@PathParam("villagerId") Long villagerId, @PathParam("dealId") Long dealId) {
        villagerService.removeDealFromVillager(villagerId, dealId);
    }

    @DELETE
    @Path("/{id}")
    public void deleteVillager(@PathParam("id") Long id) {
        villagerService.deleteVillager(id);
    }
}
