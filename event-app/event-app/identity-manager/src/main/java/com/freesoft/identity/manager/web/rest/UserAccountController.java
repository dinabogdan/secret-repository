package com.freesoft.identity.manager.web.rest;

import com.freesoft.identity.manager.service.UserAccountService;
import com.freesoft.identity.manager.web.rest.dto.UserAccountDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
public class UserAccountController {

    private final UserAccountService userAccountService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAccount(@RequestBody @Valid UserAccountDTO userAccountDTO) {
        userAccountService.registerAccount(userAccountDTO);
    }
}
