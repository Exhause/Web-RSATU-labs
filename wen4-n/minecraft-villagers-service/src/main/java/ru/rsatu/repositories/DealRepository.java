package ru.rsatu.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import ru.rsatu.entities.Deal;

@ApplicationScoped
public class DealRepository implements PanacheRepository<Deal> {
    public Deal createDeal(Deal deal) {
        persist(deal);
        return deal;
    }

    public Deal updateDeal(Deal newDeal) {
        Deal deal = findById(newDeal.getId());

        deal.setExperienceAmount(newDeal.getExperienceAmount());
        deal.setTradesPerCycle(newDeal.getTradesPerCycle());
        deal.setGivenItem(newDeal.getGivenItem());

        return deal;
    }
}
