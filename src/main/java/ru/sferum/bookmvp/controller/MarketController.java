package ru.sferum.bookmvp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sferum.bookmvp.dto.ProductsDto;
import ru.sferum.bookmvp.service.MarketService;

@RestController
@RequestMapping("/market")
@RequiredArgsConstructor
public class MarketController {

    private final MarketService service;

    @GetMapping
    public ProductsDto getMarketInfo() {
        return service.getMarketRange();
    }
}
