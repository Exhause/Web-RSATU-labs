package ru.rsatu.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "deals")
@Getter
@Setter
@NoArgsConstructor
public class Deal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Код сделки

    private int experienceAmount;
    private int tradesPerCycle;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "villager_id")
    )
    private List<Villager> villagers;

    // Предметы, которые ЗАПРАШИВАЮТСЯ
    @ManyToMany
    @JoinTable(
            name = "deal_requested_items",
            joinColumns = @JoinColumn(name = "deal_id")
    )
    private List<Item> requestedItems;

    // Предмет, который ОТДАЕТСЯ
    @ManyToOne
    @JoinTable(
            name = "deal_given_items",
            joinColumns = @JoinColumn(name = "deal_id")
    )
    private Item givenItem;
}