package ru.sferum.bookmvp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sferum.bookmvp.dto.DealDto;
import ru.sferum.bookmvp.dto.ProductsDto;
import ru.sferum.bookmvp.service.DealService;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("/market/deal")
@RequiredArgsConstructor
public class DealController {

    private final DealService service;

    @PostMapping
    public void makeDeal(@RequestBody @Valid DealDto dealDto) {
        service.makeDeal(dealDto);
    }
}
