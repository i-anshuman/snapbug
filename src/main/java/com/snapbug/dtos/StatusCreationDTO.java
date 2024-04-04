package com.snapbug.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(doNotUseGetters = true)
public class StatusCreationDTO {
  @NotBlank(message = "{validation.status.name}")
  private String name;
}
