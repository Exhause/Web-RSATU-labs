package ru.rsatu.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import ru.rsatu.dtos.VillageDto;
import ru.rsatu.dtos.VillageSaveDto;
import ru.rsatu.dtos.VillageShortDto;
import ru.rsatu.dtos.VillagerSaveDto;
import ru.rsatu.entities.Village;
import ru.rsatu.entities.Villager;
import ru.rsatu.mappers.VillageMapper;
import ru.rsatu.repositories.VillageRepository;
import ru.rsatu.repositories.VillagerRepository;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class VillageService {
    @Inject
    private VillageRepository villageRepository;

    @Inject
    private VillagerRepository villagerRepository;

    @Inject
    private VillageMapper villageMapper;

    @Transactional
    public VillageDto createVillage(VillageSaveDto villageSaveDto) {
        return villageMapper.toDto(
                villageRepository.createVillage(
                        villageMapper.fromSaveDtoToTransient(villageSaveDto)
                ),
                new ArrayList<>()
        );
    }

    public List<VillageShortDto> getAllVillages() {
        return villageMapper.toShortDtoList(villageRepository.listAll());
    }

    public VillageDto getVillageById(Long villageId) {
        Village village = villageRepository.getById(villageId);

        List<Villager> villagerList = villagerRepository.getVillagersByVillageId(villageId);

        return villageMapper.toDto(village, villagerList);
    }

    @Transactional
    public VillageDto updateVillage(VillageSaveDto villageSaveDto) {
        villageRepository.updateVillage(villageMapper.fromSaveDto(villageSaveDto));

        return getVillageById(villageSaveDto.getId());
    }

    @Transactional
    public void deleteVillage(Long id) {
        villageRepository.deleteById(id);
    }
}
