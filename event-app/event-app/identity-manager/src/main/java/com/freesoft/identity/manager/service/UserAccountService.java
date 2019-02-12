package com.freesoft.identity.manager.service;

import com.freesoft.identity.manager.web.rest.dto.UserAccountDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAccountService {

    private final KeycloakClient keycloakClient;

    public void registerAccount(UserAccountDTO userAccountDTO) {
        try {
            keycloakClient.signUp(userAccountDTO);
        } catch (Exception ex) {
            handleError(ex);
        }
    }

    private void handleError(Exception ex) {

    }
}
