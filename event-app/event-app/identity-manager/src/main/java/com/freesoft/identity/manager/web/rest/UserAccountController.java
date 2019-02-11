package com.freesoft.identity.manager.web.rest;

import com.freesoft.identity.manager.service.UserAccountService;
import com.freesoft.identity.manager.service.dto.UserAccountDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/api/account")
public class UserAccountController {

    private final UserAccountService userAccountService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAccount(@Valid UserAccountDTO userAccountDTO) {
        userAccountService.registerAccount(userAccountDTO);
    }
}
