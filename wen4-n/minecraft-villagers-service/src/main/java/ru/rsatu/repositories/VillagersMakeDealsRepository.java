package ru.rsatu.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import ru.rsatu.entities.*;

import java.util.List;

@ApplicationScoped
public class VillagersMakeDealsRepository implements PanacheRepository<VillagersMakeDeals> {
    public void addDeal(Villager villager, Deal deal) {
        VillagersMakeDeals villagersMakeDeals = new VillagersMakeDeals();
        villagersMakeDeals.setVillager(villager);
        villagersMakeDeals.setDeal(deal);
        persist(villagersMakeDeals);
    }

    public List<Deal> getDealsByVillagerId(Long villagerId) {
        return list("villager_id = ?1", villagerId)
                .stream()
                .map(VillagersMakeDeals::getDeal)
                .toList();
    }

    public void removeDeal(Long villagerId, Long dealId) {
        delete("villager_id = ?1 and deal_id = ?2", villagerId, dealId);
    }
}
