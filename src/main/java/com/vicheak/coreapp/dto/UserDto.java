package com.vicheak.coreapp.dto;

import jakarta.validation.constraints.NotBlank;

public record UserDto(@NotBlank
                      String username,
                      @NotBlank
                      String gender,
                      @NotBlank
                      String birthDate) {
}
