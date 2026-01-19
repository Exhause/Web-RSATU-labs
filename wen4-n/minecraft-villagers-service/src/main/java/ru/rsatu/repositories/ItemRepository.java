package ru.rsatu.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.NotFoundException;
import ru.rsatu.entities.Item;

import java.util.List;

@ApplicationScoped
public class ItemRepository implements PanacheRepository<Item> {
    public Item createItem(Item item) {
        persist(item);
        return item;
    }

    public void updateItem(Item newItem) {
        getById(newItem.getId());
        getEntityManager().merge(newItem);
    }

    public Item getById(Long id) {
        Item item = findById(id);

        if (item == null) {
            throw new NotFoundException();
        }

        return item;
    }

    public List<Item> getByIds(List<Long> ids) {
        List<Item> result = list("id in ?1", ids);

        if (result.size() != ids.size()) {
            throw new NotFoundException();
        }

        return result;
    }
}
