package ru.rsatu.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import ru.rsatu.entities.Item;

@ApplicationScoped
public class ItemRepository implements PanacheRepository<Item> {
    public Long createItem(Item item) {
        persist(item);
        return item.getId();
    }
}
