package ru.rsatu.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.rsatu.dtos.DealDto;
import ru.rsatu.dtos.DealSaveDto;
import ru.rsatu.entities.Deal;
import ru.rsatu.entities.Item;

import java.util.List;


@Mapper(componentModel = "cdi",
        uses = {
                ItemMapper.class
        })
public interface DealMapper {
    DealDto toDto(Deal deal, List<Item> requestedItems);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "givenItem", source = "givenItem")
    Deal fromSaveDtoToTransient(DealSaveDto dealSaveDto, Item givenItem);

    @Mapping(target = "id", source = "dealSaveDto.id")
    @Mapping(target = "givenItem", source = "givenItem")
    Deal fromSaveDto(DealSaveDto dealSaveDto, Item givenItem);
}
