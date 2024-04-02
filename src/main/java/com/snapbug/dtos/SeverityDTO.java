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
public class SeverityDTO {

  @NotNull(message = "{validation.severity.id}")
  @Positive(message = "{validation.severity.id.valid}")
  private Long id;

  @NotBlank(message = "{validation.severity.name}")
  private String name;
}
