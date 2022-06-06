package ru.sferum.bookmvp.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
public class Account {
    private final List<Product> books;

    @NotNull
    @Min(0)
    @Max(Integer.MAX_VALUE)
    private final int balance;

    public void addProduct(Product product){
        books.add(product);
    }

}
