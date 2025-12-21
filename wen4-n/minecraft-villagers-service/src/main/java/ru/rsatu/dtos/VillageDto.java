package ru.rsatu.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class VillageDto {

    private Long id;
    private String name;
    private List<VillagerShortDto> villagers;
}