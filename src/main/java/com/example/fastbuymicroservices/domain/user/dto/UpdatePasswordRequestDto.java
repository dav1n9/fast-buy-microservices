package com.example.fastbuymicroservices.domain.user.dto;

import lombok.Getter;

@Getter
public class UpdatePasswordRequestDto {
    private String currentPassword;
    private String newPassword;
}
