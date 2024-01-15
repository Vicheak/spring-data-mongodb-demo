package com.vicheak.coreapp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record UserDto(String id,
                      @NotBlank
                      String username,
                      @NotBlank
                      String gender,
                      @NotBlank
                      String birthDate) {
}
