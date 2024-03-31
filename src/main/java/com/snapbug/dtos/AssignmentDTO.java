package com.snapbug.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString(doNotUseGetters = true)
public class AssignmentDTO {

  @NotNull(message = "{validation.assignment.issue}")
  @Positive(message = "{validation.assignment.issue.valid}")
  private Long issueId;

  @NotNull(message = "{validation.assignment.user}")
  @Positive(message = "{validation.assignment.user.valid}")
  private Long userId;
}
