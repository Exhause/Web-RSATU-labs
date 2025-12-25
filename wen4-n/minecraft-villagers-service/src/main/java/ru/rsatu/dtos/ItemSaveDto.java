package ru.rsatu.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ItemSaveDto {

    private Long id;
    private String name;
    private int quantity;
}
