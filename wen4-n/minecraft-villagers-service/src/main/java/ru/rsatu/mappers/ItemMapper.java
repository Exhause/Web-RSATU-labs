package ru.rsatu.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.rsatu.dtos.ItemDto;
import ru.rsatu.dtos.ItemSaveDto;
import ru.rsatu.entities.Item;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface ItemMapper {
    ItemDto toDto(Item item);

    @Mapping(target = "id", ignore = true)
    Item fromSaveDtoToTransient(ItemSaveDto itemSaveDto);

    Item fromSaveDto(ItemSaveDto itemSaveDto);

    List<ItemDto> toDtoList(List<Item> itemList);
}
