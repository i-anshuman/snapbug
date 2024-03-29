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
public class IssueCreationDTO {

  @NotBlank(message = "{validation.issue.title}")
  private String title;

  @NotBlank(message = "{validation.issue.description}")
  private String description;

  @NotBlank(message = "{validation.issue.expectation}")
  private String expectation;

  @NotNull(message = "{validation.issue.module}")
  @Positive(message = "{validation.issue.module.valid}")
  private Long module;

  @NotNull(message = "{validation.issue.submodule}")
  @Positive(message = "{validation.issue.submodule.valid}")
  private Long submodule;

  @NotNull(message = "{validation.issue.screen}")
  @Positive(message = "{validation.issue.screen.valid}")
  private Long screen;

  @NotNull(message = "{validation.issue.type}")
  @Positive(message = "{validation.issue.type.valid}")
  private Long type;

  @NotNull(message = "{validation.issue.severity}")
  @Positive(message = "{validation.issue.severity.valid}")
  private Long severity;
}
