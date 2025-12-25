package ru.rsatu.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class VillagerSaveDto {
    private Long id;
    private int tradeLevel;
    private String profession;
    private List<Long> deals;
}
