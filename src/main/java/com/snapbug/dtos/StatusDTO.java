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
public class StatusDTO {

  @NotNull(message = "{validation.status.id}")
  @Positive(message = "{validation.status.id.valid}")
  private Long id;

  @NotBlank(message = "{validation.status.name}")
  private String name;
}
