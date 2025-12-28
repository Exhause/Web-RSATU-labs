package ru.rsatu.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.rsatu.dtos.VillagerDto;
import ru.rsatu.dtos.VillagerSaveDto;
import ru.rsatu.dtos.VillagerShortDto;
import ru.rsatu.entities.Deal;
import ru.rsatu.entities.Villager;

import java.util.List;

@Mapper(componentModel = "cdi",
        uses = {
                DealMapper.class
        })
public interface VillagerMapper {
    VillagerShortDto toShortDto(Villager villager);

    VillagerDto toDto(Villager villager);

    @Mapping(target = "villagerDto.deals", source = "deals")
    void enrichDtoWithDeals(@MappingTarget VillagerDto villagerDto, List<Deal> deals);

    Villager fromSaveDto(VillagerSaveDto villagerSaveDto);
}
