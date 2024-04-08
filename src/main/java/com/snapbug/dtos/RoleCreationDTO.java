package com.snapbug.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(doNotUseGetters = true)
public class RoleCreationDTO {
  @NotBlank(message = "{validation.role.name}")
  private String name;
}
