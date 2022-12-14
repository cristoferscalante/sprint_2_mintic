package com.roicerbc.votaciones.dtos.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PermissionResponseDto {

    private String url;
    private String method;
}
