package ru.rsatu.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import ru.rsatu.dtos.ItemDto;
import ru.rsatu.dtos.ItemSaveDto;
import ru.rsatu.mappers.ItemMapper;
import ru.rsatu.repositories.ItemRepository;

import java.util.List;

@ApplicationScoped
public class ItemService {
    @Inject
    private ItemRepository itemRepository;

    @Inject
    private ItemMapper itemMapper;

    @Transactional
    public ItemDto createItem(ItemSaveDto itemSaveDto) {
        return itemMapper.toDto(
                itemRepository.createItem(
                        itemMapper.fromSaveDtoToTransient(itemSaveDto)
                )
        );
    }

    public List<ItemDto> getAllItems() {
        return itemMapper.toDtoList(itemRepository.listAll());
    }

    @Transactional
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
