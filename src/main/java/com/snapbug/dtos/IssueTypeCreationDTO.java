package com.snapbug.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(doNotUseGetters = true)
public class IssueTypeCreationDTO {
  @NotBlank(message = "{validation.issue-type.name}")
  private String name;
}
