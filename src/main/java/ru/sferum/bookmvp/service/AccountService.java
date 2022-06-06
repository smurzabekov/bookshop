package ru.sferum.bookmvp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sferum.bookmvp.dto.AccountDto;
import ru.sferum.bookmvp.mapper.AccountMapper;
import ru.sferum.bookmvp.model.Account;
import ru.sferum.bookmvp.model.Product;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountMapper mapper;
    private static Account ACCOUNT;

    public void setBalance(int money) {
        ACCOUNT = Account.builder()
                .books(new ArrayList<>())
                .balance(money)
                .build();
    }

    public AccountDto getAccountInfo() {
        return mapper.fromEntityToDto(ACCOUNT);
    }

    public void buyNew(Product product) {
        if (ACCOUNT.getBalance() >= (product.getAmount() * product.getPrice()))
            ACCOUNT.addProduct(product);
        else throw new RuntimeException("not enough money");
    }
}
