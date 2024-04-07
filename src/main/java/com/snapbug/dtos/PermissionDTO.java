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
public class PermissionDTO {
  @NotNull(message = "{validation.permission.id}")
  @Positive(message = "{validation.permission.id.valid}")
  private Long id;

  @NotBlank(message = "{validation.permission.name}")
  private String name;
}
