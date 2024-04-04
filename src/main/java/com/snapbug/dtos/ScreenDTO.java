package com.snapbug.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString(doNotUseGetters = true)
public class ScreenDTO {
  @NotNull(message = "{validation.screen.id}")
  @Positive(message = "{validation.screen.id.valid}")
  private Long id;

  @NotBlank(message = "{validation.screen.name}")
  private String name;

  @NotNull(message = "{validation.screen.sub-module}")
  private SubModuleDTO subModule;
}
