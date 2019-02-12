package com.freesoft.identity.manager.web.rest;

import com.freesoft.identity.manager.web.rest.dto.UserAccountDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.freesoft.identity.manager.util.TestUtil.json;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserAccountControllerValidationIT {

    private static final String BLANK = null;
    private static final String INVALID_EMAIL_ADDRESS = "INVALID_EMAIL_ADDRESS";
    private static final String TOO_SHORT_PASSWORD = "ABC";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_validation_blank_first_name() throws Exception {
        mockMvc.perform(post("/api/account/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json(UserAccountDTO.builder()
                        .firstName(BLANK)
                        .lastName("test")
                        .email("test@gmail.com")
                        .password("Password")
                        .confirmPassword("Password")
                        .build())))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.fieldErrors", hasSize(1)))
                .andExpect(jsonPath("$.fieldErrors[0].field", is("firstName")))
                .andExpect(jsonPath("$.fieldErrors[0].message", not(isEmptyString())));
    }

    @Test
    public void test_validation_blank_last_name() throws Exception {
        mockMvc.perform(post("/api/account/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json(UserAccountDTO.builder()
                        .firstName("test")
                        .lastName(BLANK)
                        .email("test@gmail.com")
                        .password("Password")
                        .confirmPassword("Password")
                        .build())))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.fieldErrors", hasSize(1)))
                .andExpect(jsonPath("$.fieldErrors[0].field", is("lastName")))
                .andExpect(jsonPath("$.fieldErrors[0].message", not(isEmptyString())));
    }

    @Test
    public void test_validation_blank_email() throws Exception {
        mockMvc.perform(post("/api/account/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json(UserAccountDTO.builder()
                        .firstName("test")
                        .lastName("test")
                        .email(BLANK)
                        .password("Password")
                        .confirmPassword("Password")
                        .build())))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.fieldErrors", hasSize(1)))
                .andExpect(jsonPath("$.fieldErrors[0].field", is("email")))
                .andExpect(jsonPath("$.fieldErrors[0].message", not(isEmptyString())));
    }

    @Test
    public void test_validation_invalid_email() throws Exception {
        mockMvc.perform(post("/api/account/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json(UserAccountDTO.builder()
                        .firstName("test")
                        .lastName("test")
                        .email(INVALID_EMAIL_ADDRESS)
                        .password("Password")
                        .confirmPassword("Password")
                        .build())))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.fieldErrors", hasSize(1)))
                .andExpect(jsonPath("$.fieldErrors[0].field", is("email")))
                .andExpect(jsonPath("$.fieldErrors[0].message", not(isEmptyString())));
    }

    @Test
    public void test_validation_blank_password() throws Exception {
        mockMvc.perform(post("/api/account/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json(UserAccountDTO.builder()
                        .firstName("test")
                        .lastName("test")
                        .email("test@gmail.com")
                        .password(BLANK)
                        .confirmPassword("Password")
                        .build())))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.fieldErrors", hasSize(1)))
                .andExpect(jsonPath("$.fieldErrors[0].field", is("password")))
                .andExpect(jsonPath("$.fieldErrors[0].message", not(isEmptyString())));
    }

    @Test
    public void test_validation_invalid_password() throws Exception {
        mockMvc.perform(post("/api/account/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json(UserAccountDTO.builder()
                        .firstName("test")
                        .lastName("test")
                        .email("test@gmail.com")
                        .password(TOO_SHORT_PASSWORD)
                        .confirmPassword("Password")
                        .build())))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.fieldErrors", hasSize(1)))
                .andExpect(jsonPath("$.fieldErrors[0].field", is("password")))
                .andExpect(jsonPath("$.fieldErrors[0].message", not(isEmptyString())));
    }

    @Test
    public void test_validation_blank_confirmation_password() throws Exception {
        mockMvc.perform(post("/api/account/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json(UserAccountDTO.builder()
                        .firstName("test")
                        .lastName("test")
                        .email("test@gmail.com")
                        .password("Password")
                        .confirmPassword(BLANK)
                        .build())))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.fieldErrors", hasSize(1)))
                .andExpect(jsonPath("$.fieldErrors[0].field", is("confirmPassword")))
                .andExpect(jsonPath("$.fieldErrors[0].message", not(isEmptyString())));
    }

    @Test
    public void test_validation_invalid_confirmation_password() throws Exception {
        mockMvc.perform(post("/api/account/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json(UserAccountDTO.builder()
                        .firstName("test")
                        .lastName("test")
                        .email("test@gmail.com")
                        .password("Password")
                        .confirmPassword(TOO_SHORT_PASSWORD)
                        .build())))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.fieldErrors", hasSize(1)))
                .andExpect(jsonPath("$.fieldErrors[0].field", is("confirmPassword")))
                .andExpect(jsonPath("$.fieldErrors[0].message", not(isEmptyString())));
    }

    @Test
    //TODO: FIX IT
    public void test_validation_different_password_and_confirmation_password() throws Exception {
        mockMvc.perform(post("/api/account/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json(UserAccountDTO.builder()
                        .firstName("test")
                        .lastName("test")
                        .email("test@gmail.com")
                        .password("Password_1")
                        .confirmPassword("Password_2")
                        .build())))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.fieldErrors", hasSize(1)))
                .andExpect(jsonPath("$.fieldErrors[0].field", is("confirmPassword")))
                .andExpect(jsonPath("$.fieldErrors[0].message", not(isEmptyString())));
    }
}
