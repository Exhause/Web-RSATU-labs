package ru.rsatu.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import ru.rsatu.entities.Deal;
import ru.rsatu.entities.DealsRequestItems;
import ru.rsatu.entities.Item;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ApplicationScoped
public class DealsRequestItemsRepository implements PanacheRepository<DealsRequestItems> {
    public Map<Deal, List<Item>> getRequestedItems() {
        List<DealsRequestItems> dealsRequestItemsList = listAll();

        return dealsRequestItemsList
                .stream()
                .collect(Collectors.groupingBy(
                        DealsRequestItems::getDeal,
                        Collectors.mapping(DealsRequestItems::getItem, Collectors.toList())
                ));
    }

    public List<Item> getRequestedItemsByDealId(Long dealId) {
        return list("deal_id = ?1", dealId)
                .stream()
                .map(DealsRequestItems::getItem)
                .toList();
    }

    public void addRequestedItems(Deal deal, List<Item> itemList) {
        for (Item item : itemList) {
            DealsRequestItems dealsRequestItems = new DealsRequestItems();
            dealsRequestItems.setDeal(deal);
            dealsRequestItems.setItem(item);
            persist(dealsRequestItems);
        }
    }

    public void deleteRequestedItemsByDealId(Long dealId) {
        delete("deal_id = ?1", dealId);
    }
}
