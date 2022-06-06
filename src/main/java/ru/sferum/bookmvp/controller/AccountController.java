package ru.sferum.bookmvp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sferum.bookmvp.dto.AccountDto;
import ru.sferum.bookmvp.service.AccountService;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService service;

    @GetMapping
    public AccountDto getAccountInfo(){
        return service.getAccountInfo();
    }
}
