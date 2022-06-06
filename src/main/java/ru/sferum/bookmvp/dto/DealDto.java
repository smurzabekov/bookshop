package ru.sferum.bookmvp.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class DealDto {
    @Min(0)
    @Max(Integer.MAX_VALUE)
    private final int bookId;

    @Min(0)
    @Max(Integer.MAX_VALUE)
    private final int amount;
}
