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
public class RoleDTO {
  @NotNull(message = "{validation.role.id}")
  @Positive(message = "{validation.role.id.valid}")
  private Long id;

  @NotBlank(message = "{validation.role.name}")
  private String name;
}
