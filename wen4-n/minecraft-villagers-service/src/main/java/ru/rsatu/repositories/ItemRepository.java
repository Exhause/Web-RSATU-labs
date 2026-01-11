package ru.rsatu.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import ru.rsatu.entities.Item;

import java.util.List;

@ApplicationScoped
public class ItemRepository implements PanacheRepository<Item> {
    public Item createItem(Item item) {
        persist(item);
        return item;
    }

    public List<Item> getByIds(List<Long> ids) {
        return list("id in ?1", ids);
    }
}
