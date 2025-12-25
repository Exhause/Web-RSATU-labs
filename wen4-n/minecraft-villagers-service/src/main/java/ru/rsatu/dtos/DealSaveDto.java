package ru.rsatu.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DealSaveDto {
    private Long id;

    private int experienceAmount;
    private int tradesPerCycle;

    private List<Long> requestedItemsIds;
    private Long givenItem;
}
