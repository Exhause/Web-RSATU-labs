package ru.rsatu.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.rsatu.dtos.VillageDto;
import ru.rsatu.dtos.VillageSaveDto;
import ru.rsatu.dtos.VillageShortDto;
import ru.rsatu.entities.Village;
import ru.rsatu.entities.Villager;

import java.util.List;

@Mapper(componentModel = "cdi",
        uses = {
                VillagerMapper.class
        })
public interface VillageMapper {
    VillageShortDto toShortDto(Village village);

    VillageDto toDto(Village village, List<Villager> villagers);

    @Mapping(target = "id", ignore = true)
    Village fromSaveDtoToTransient(VillageSaveDto villageSaveDto);

    Village fromSaveDto(VillageSaveDto villageSaveDto);

    List<VillageShortDto> toShortDtoList(List<Village> village);
}
