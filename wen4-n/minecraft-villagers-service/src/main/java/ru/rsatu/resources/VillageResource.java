package ru.rsatu.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ru.rsatu.dtos.VillageDto;
import ru.rsatu.dtos.VillageSaveDto;
import ru.rsatu.dtos.VillageShortDto;
import ru.rsatu.services.VillageService;

import java.util.List;

@Path("/villages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VillageResource {
    @Inject
    private VillageService villageService;

    @POST
    public VillageDto createVillage(VillageSaveDto villageSaveDto) {
        return villageService.createVillage(villageSaveDto);
    }

    @GET
    public List<VillageShortDto> getAllVillages() {
        return villageService.getAllVillages();
    }

    @GET
    @Path("{id}")
    public VillageDto getVillageById(@PathParam("id") Long villageId) {
        return villageService.getVillageById(villageId);
    }

    @PUT
    public VillageDto updateVillage(VillageSaveDto villageSaveDto) {
        return villageService.updateVillage(villageSaveDto);
    }

    @DELETE
    @Path("{id}")
    public void deleteVillage(@PathParam("id") Long id) {
        villageService.deleteVillage(id);
    }
}
