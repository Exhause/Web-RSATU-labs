package ru.rsatu.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.NotFoundException;
import ru.rsatu.entities.Village;

@ApplicationScoped
public class VillageRepository implements PanacheRepository<Village> {
    public Village createVillage(Village village) {
        persist(village);
        return village;
    }

    public void updateVillage(Village newVillage) {
        Village village = getById(newVillage.getId());

        village.setName(newVillage.getName());
    }

    public Village getById(Long id) {
        Village village = findById(id);

        if (village == null) {
            throw new NotFoundException();
        }

        return village;
    }
}
