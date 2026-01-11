package ru.rsatu.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import ru.rsatu.dtos.DealDto;
import ru.rsatu.dtos.VillagerDto;
import ru.rsatu.dtos.VillagerSaveDto;
import ru.rsatu.entities.Deal;
import ru.rsatu.entities.Item;
import ru.rsatu.entities.Village;
import ru.rsatu.entities.Villager;
import ru.rsatu.mappers.DealMapper;
import ru.rsatu.mappers.VillagerMapper;
import ru.rsatu.repositories.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class VillagerService {
    @Inject
    private VillageRepository villageRepository;

    @Inject
    private VillagerRepository villagerRepository;

    @Inject
    private DealRepository dealRepository;

    @Inject
    private VillagersMakeDealsRepository villagersMakeDealsRepository;

    @Inject
    private DealsRequestItemsRepository dealsRequestItemsRepository;

    @Inject
    private VillagerMapper villagerMapper;

    @Inject
    private DealMapper dealMapper;

    @Transactional
    public VillagerDto createVillager(VillagerSaveDto villagerSaveDto) {
        Village village = villageRepository.findById(villagerSaveDto.getVillageId());

        return villagerMapper.toDto(
                villagerRepository.createVillager(
                        villagerMapper.fromSaveDto(villagerSaveDto, village)
                ),
                new ArrayList<>()
        );
    }

    @Transactional
    public void addDealToVillager(Long villagerId, Long dealId) {
        Villager villager = villagerRepository.findById(villagerId);
        Deal deal = dealRepository.findById(dealId);
        villagersMakeDealsRepository.addDeal(villager, deal);
    }

    @Transactional
    public void removeDealFromVillager(Long villagerId, Long dealId) {
        villagersMakeDealsRepository.removeDeal(villagerId, dealId);
    }

    public VillagerDto getVillagerById(Long villagerId) {
        Villager villager = villagerRepository.findById(villagerId);
        List<Deal> dealList = villagersMakeDealsRepository.getDealsByVillagerId(villagerId);

        Map<Deal, List<Item>> requestedItemsByDeal = dealsRequestItemsRepository.getRequestedItems();

        List<DealDto> dealDtoList = dealList
                .stream()
                .map(deal -> dealMapper.toDto(deal, requestedItemsByDeal.getOrDefault(deal, new ArrayList<>())))
                .toList();

        return villagerMapper.toDto(villager, dealDtoList);
    }

    @Transactional
    public VillagerDto updateVillager(VillagerSaveDto villagerSaveDto) {
        Village village = villageRepository.findById(villagerSaveDto.getVillageId());

        villagerRepository.updateVillager(villagerMapper.fromSaveDto(villagerSaveDto, village));

        return getVillagerById(villagerSaveDto.getId());
    }

    @Transactional
    public void deleteVillager(Long id) {
        villagerRepository.deleteById(id);
    }
}
