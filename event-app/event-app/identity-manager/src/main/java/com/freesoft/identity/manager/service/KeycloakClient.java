package com.freesoft.identity.manager.service;

import com.freesoft.identity.manager.web.rest.dto.UserAccountDTO;

public interface KeycloakClient {

    void signUp(UserAccountDTO userAccountDTO);

    void login();

    void logout();
}
