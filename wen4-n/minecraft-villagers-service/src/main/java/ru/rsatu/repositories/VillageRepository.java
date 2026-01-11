package ru.rsatu.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import ru.rsatu.entities.Village;

@ApplicationScoped
public class VillageRepository implements PanacheRepository<Village> {
    public Village createVillage(Village village) {
        persist(village);
        return village;
    }

    public void updateVillage(Village newVillage) {
        Village village = findById(newVillage.getId());

        village.setName(newVillage.getName());
    }
}
