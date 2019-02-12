package com.freesoft.identity.manager.web.rest.dto;

import com.freesoft.identity.manager.web.rest.validator.FieldMatch;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Builder
@FieldMatch(
        first = "password",
        second = "confirmPassword",
        message = "{validation.constraints.register.passwordConfirmPassword.DontMatch}")
@NoArgsConstructor
@AllArgsConstructor
public class UserAccountDTO {

    @NotEmpty(message = "{validation.constraints.register.firstName.NotEmpty}")
    private String firstName;

    @NotEmpty(message = "{validation.constraints.register.lastName.NotEmpty}")
    private String lastName;

    @Email(message = "{validation.constraints.register.email.Email}")
    @NotEmpty(message = "{validation.constraints.register.email.NotEmpty}")
    private String email;

    @NotEmpty(message = "{validation.constraints.register.password.NotEmpty}")
    @Length(min = 5, message = "{validation.constraints.register.password.Length}")
    private String password;

    @NotEmpty(message = "{validation.constraints.register.confirmPassword.NotEmpty}")
    @Length(min = 5, message = "{validation.constraints.register.confirmPassword.Length}")
    private String confirmPassword;
}
