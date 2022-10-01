package com.roicerbc.votaciones.dtos.request;

import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginDto {
    @NotNull()
    @NotEmpty()
    @Email()
    private String email;
    @NotNull()
    @NotEmpty()
    @Size(min = 8)
    private String password;
}