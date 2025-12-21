package ru.rsatu.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "villagers")
@Getter
@Setter
@NoArgsConstructor
public class Villager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Код жителя

    private String name;
    
    private int tradeLevel;

    private String profession;

    @ManyToOne
    @JoinColumn(name = "village_id")
    private Village village;

    @ManyToMany(mappedBy = "villagers")
    private List<Deal> deals;
}
