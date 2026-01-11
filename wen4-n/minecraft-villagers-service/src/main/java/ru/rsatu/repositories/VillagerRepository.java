package ru.rsatu.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.NotFoundException;
import ru.rsatu.entities.Villager;

import java.util.List;

@ApplicationScoped
public class VillagerRepository implements PanacheRepository<Villager> {
    public Villager createVillager(Villager villager) {
        persist(villager);
        return villager;
    }

    public void updateVillager(Villager newVillager) {
        Villager villager = getById(newVillager.getId());

        villager.setVillage(newVillager.getVillage());
        villager.setName(newVillager.getName());
        villager.setProfession(newVillager.getProfession());
        villager.setTradeLevel(newVillager.getTradeLevel());
    }

    public List<Villager> getVillagersByVillageId(Long villageId) {
        return list("village.id = ?1", villageId);
    }

    public Villager getById(Long id) {
        Villager villager = findById(id);

        if (villager == null) {
            throw new NotFoundException();
        }

        return villager;
    }
}
