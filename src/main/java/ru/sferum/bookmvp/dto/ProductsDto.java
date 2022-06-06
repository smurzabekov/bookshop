package ru.sferum.bookmvp.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductsDto {
    private final List<ProductDto> products;
}
