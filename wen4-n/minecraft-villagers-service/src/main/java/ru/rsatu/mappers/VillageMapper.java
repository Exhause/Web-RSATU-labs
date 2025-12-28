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

    @Mapping(target = "villagers", ignore = true)
    VillageDto toDto(Village village);

    @Mapping(target = "villagers", source = "villagers")
    void enrichDtoWithVillagers(@MappingTarget VillageDto villageDto, List<Villager> villagers);

    Village fromSaveDto(VillageSaveDto villageSaveDto);
}
