package com.snapbug.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(doNotUseGetters = true)
public class PermissionCreationDTO {
  @NotBlank(message = "{validation.permission.name}")
  private String name;
}
