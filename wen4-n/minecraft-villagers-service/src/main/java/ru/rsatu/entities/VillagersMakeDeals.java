package ru.rsatu.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class VillagersMakeDeals {
    Long id;

    @ManyToOne
    @JoinColumn(name="villager_id")
    private Villager villager;

    @ManyToOne
    @JoinColumn(name="deal_id")
    private Deal deal;
}
