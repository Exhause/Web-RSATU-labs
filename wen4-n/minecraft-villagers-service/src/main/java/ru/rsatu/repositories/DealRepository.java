package ru.rsatu.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.NotFoundException;
import ru.rsatu.entities.Deal;

@ApplicationScoped
public class DealRepository implements PanacheRepository<Deal> {
    public Deal createDeal(Deal deal) {
        persist(deal);
        return deal;
    }

    public void updateDeal(Deal newDeal) {
        getById(newDeal.getId());
        getEntityManager().merge(newDeal);
    }

    public Deal getById(Long id) {
        Deal deal = findById(id);

        if (deal == null) {
            throw new NotFoundException();
        }

        return deal;
    }
}
