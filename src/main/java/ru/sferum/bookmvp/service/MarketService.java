package ru.sferum.bookmvp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sferum.bookmvp.dto.ProductsDto;
import ru.sferum.bookmvp.mapper.ProductMapper;
import ru.sferum.bookmvp.model.Product;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MarketService {

    private final ProductMapper mapper;
    private static List<Product> ASSORTMENT;

    public void setASSORTMENT(List<Product> products) {
        ASSORTMENT = products;
    }

    public ProductsDto getMarketRange() {
        if (ASSORTMENT == null)
            throw new RuntimeException("No assortment provided");
        else
            return new ProductsDto(
                    ASSORTMENT.stream()
                            .filter(p -> p.getAmount() > 0)
                            .map(mapper::fromEntityToDto)
                            .toList());
    }

    public Product getFromStock(int id, int amount) {
        return ASSORTMENT.stream()
                .filter(p -> p.getId() == id && p.getAmount() >= amount)
                .findAny()
                .orElseThrow(() -> new RuntimeException("No such book in assortment"));
    }
}
