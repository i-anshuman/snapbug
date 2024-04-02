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
public class IssueTypeDTO {
  @NotNull(message = "{validation.issue-type.id}")
  @Positive(message = "{validation.issue-type.id.valid}")
  private Long id;

  @NotBlank(message = "{validation.issue-type.name}")
  private String name;
}
