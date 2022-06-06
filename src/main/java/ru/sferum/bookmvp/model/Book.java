package ru.sferum.bookmvp.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class Book {

    @NotBlank
    @NotNull
    public final String name;

    @NotBlank
    @NotNull
    public final String author;
}
