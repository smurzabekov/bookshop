package ru.sferum.bookmvp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sferum.bookmvp.dto.DealDto;
import ru.sferum.bookmvp.mapper.DealMapper;
import ru.sferum.bookmvp.model.Deal;
import ru.sferum.bookmvp.model.Product;

@Service
@RequiredArgsConstructor
public class DealService {
    private final AccountService accountService;
    private final MarketService marketService;
    private final DealMapper mapper;

    public void makeDeal(DealDto dealDto) {
        Deal deal = mapper.fromDtoToEntity(dealDto);
        Product soldBook = marketService.getFromStock(deal.getBookId(), deal.getAmount());
        accountService.buyNew(soldBook);
    }
}
