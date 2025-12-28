package ru.rsatu.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @ManyToOne
    @JoinColumn(name = "given_item_id")
    private Item givenItem;
}