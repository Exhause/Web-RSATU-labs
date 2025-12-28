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
    public Long createItem(ItemSaveDto itemSaveDto) {
        return itemRepository.createItem(itemMapper.fromSaveDto(itemSaveDto));
    }

    public List<ItemDto> getAllItems() {
        return itemRepository
                .listAll()
                .stream()
                .map(item -> itemMapper.toDto(item))
                .toList();
    }

    @Transactional
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
