package ru.rsatu.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import ru.rsatu.dtos.DealDto;
import ru.rsatu.dtos.DealSaveDto;
import ru.rsatu.entities.Deal;
import ru.rsatu.entities.Item;
import ru.rsatu.mappers.DealMapper;
import ru.rsatu.repositories.DealRepository;
import ru.rsatu.repositories.DealsRequestItemsRepository;
import ru.rsatu.repositories.ItemRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class DealService {
    @Inject
    private DealRepository dealRepository;

    @Inject
    private ItemRepository itemRepository;

    @Inject
    private DealsRequestItemsRepository dealsRequestItemsRepository;

    @Inject
    private DealMapper dealMapper;

    @Transactional
    public DealDto createDeal(DealSaveDto dealSaveDto) {
        Item givenItem = itemRepository.getById(dealSaveDto.getGivenItemId());
        List<Item> requestedItems = itemRepository.getByIds(dealSaveDto.getRequestedItemsIds());

        final Deal deal = dealRepository.createDeal(
                dealMapper.fromSaveDtoToTransient(dealSaveDto, givenItem)
        );

        dealsRequestItemsRepository.addRequestedItems(deal, requestedItems);

        return dealMapper.toDto(
                deal,
                requestedItems
        );
    }

    public List<DealDto> getAllDeals() {
        Map<Deal, List<Item>> requestedItemsByDeal = dealsRequestItemsRepository.getRequestedItems();

        return dealRepository
                .listAll()
                .stream()
                .map(deal -> dealMapper.toDto(deal, requestedItemsByDeal.getOrDefault(deal, new ArrayList<>())))
                .toList();
    }

    public DealDto getDealById(Long dealId) {
        return dealMapper.toDto(
                dealRepository.getById(dealId),
                dealsRequestItemsRepository.getRequestedItemsByDealId(dealId)
        );
    }

    @Transactional
    public DealDto updateDeal(DealSaveDto dealSaveDto) {
        Item givenItem = itemRepository.getById(dealSaveDto.getGivenItemId());
        List<Item> requestedItems = itemRepository.getByIds(dealSaveDto.getRequestedItemsIds());

        dealRepository.updateDeal(
                dealMapper.fromSaveDto(dealSaveDto, givenItem)
        );

        final Deal deal = dealRepository.getById(dealSaveDto.getId());

        dealsRequestItemsRepository.deleteRequestedItemsByDealId(deal.getId());
        dealsRequestItemsRepository.addRequestedItems(deal, requestedItems);

        return dealMapper.toDto(
                deal,
                requestedItems
        );
    }

    @Transactional
    public void deleteDeal(Long id) {
        dealsRequestItemsRepository.deleteRequestedItemsByDealId(id);
        dealRepository.deleteById(id);
    }
}
