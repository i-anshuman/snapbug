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
public class ScreenCreationDTO {
  @NotBlank(message = "{validation.sub-module.name}")
  private String name;

  @NotNull(message = "{validation.sub-module.id}")
  @Positive(message = "{validation.sub-module.id.valid}")
  private Long subModule;
}
