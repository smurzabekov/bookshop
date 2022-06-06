package ru.sferum.bookmvp.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class Product {
    @NotNull
    private final int id;

    private final Book book;

    @NotNull
    @Min(0)
    @Max(Integer.MAX_VALUE)
    private final int price;

    @NotNull
    @Min(0)
    @Max(Integer.MAX_VALUE)
    private final int amount;
}
