package ru.rsatu.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.rsatu.dtos.DealDto;
import ru.rsatu.dtos.VillagerDto;
import ru.rsatu.dtos.VillagerSaveDto;
import ru.rsatu.dtos.VillagerShortDto;
import ru.rsatu.entities.Village;
import ru.rsatu.entities.Villager;

import java.util.List;

@Mapper(componentModel = "cdi",
        uses = {
                DealMapper.class
        })
public interface VillagerMapper {
    VillagerShortDto toShortDto(Villager villager);

    VillagerDto toDto(Villager villager, List<DealDto> deals);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "village", source = "village")
    @Mapping(target = "name", source = "villagerSaveDto.name")
    Villager fromSaveDtoToTransient(VillagerSaveDto villagerSaveDto, Village village);

    @Mapping(target = "id", source = "villagerSaveDto.id")
    @Mapping(target = "village", source = "village")
    @Mapping(target = "name", source = "villagerSaveDto.name")
    Villager fromSaveDto(VillagerSaveDto villagerSaveDto, Village village);
}
