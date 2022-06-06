package ru.sferum.bookmvp.dto;

import lombok.Data;

@Data
public class ProductDto {
    private final int id;
    private final BookDto book;
    private final int price;
    private final int amount;
}
