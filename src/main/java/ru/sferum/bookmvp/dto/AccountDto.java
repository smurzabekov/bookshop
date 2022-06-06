package ru.sferum.bookmvp.dto;

import lombok.Data;

import java.util.List;

@Data
public class AccountDto {
    private final List<ProductNoPriceDto> books;
    private final int balance;
}
