package by.roman.test.dto;

import by.roman.test.enumerate.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @NotBlank
    @Length(max = 40)
    private String surName;

    @NotBlank
    @Length(max = 20)
    private String name;

    @NotBlank
    @Length(max = 40)
    private String middleName;

    @NotBlank
    @Length(max = 50)
    @Email
    private String email;

    @NotNull
    private Role role;
}
