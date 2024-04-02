package com.snapbug.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(doNotUseGetters = true)
public class ModuleCreationDTO {
  @NotBlank(message = "{validation.module.name}")
  private String name;
}
