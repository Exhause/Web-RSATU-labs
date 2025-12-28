package ru.rsatu.mappers;

import org.mapstruct.Mapper;
import ru.rsatu.dtos.ItemDto;
import ru.rsatu.dtos.ItemSaveDto;
import ru.rsatu.entities.Item;

@Mapper(componentModel = "cdi")
public interface ItemMapper {
    ItemDto toDto(Item item);

    Item fromSaveDto(ItemSaveDto itemSaveDto);
}
