package ru.sferum.bookmvp.dto;

import lombok.Data;

@Data
public class ProductNoPriceDto {
    private final BookDto book;
    private final int amount;
}
