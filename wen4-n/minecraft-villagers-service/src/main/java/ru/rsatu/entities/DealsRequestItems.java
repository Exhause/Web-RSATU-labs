package ru.rsatu.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DealsRequestItems {
    Long id;

    @ManyToOne
    @JoinColumn(name="deal_id")
    private Deal deal;

    @ManyToOne
    @JoinColumn(name="item_id")
    private Item item;
}
