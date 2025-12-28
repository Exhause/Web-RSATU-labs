package ru.rsatu.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
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
    DealDto toDto(Deal deal);

    @Mapping(target = "requestedItems", source = "requestedItems")
    void enrichDtoWithRequestedItems(@MappingTarget DealDto dealDto, List<Item> requestedItems);

    @Mapping(target = "givenItem", ignore = true)
    Deal fromSaveDto(DealSaveDto dealSaveDto);

    @Mapping(target = "givenItem", source = "givenItem")
    void enrichWithGivenItem(@MappingTarget Deal deal, Item givenItem);
}
