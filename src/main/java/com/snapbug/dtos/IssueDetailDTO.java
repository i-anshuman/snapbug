package com.snapbug.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@Builder
@ToString(doNotUseGetters = true)
public class IssueDetailDTO {
  private final Long id;
  private final String title;
  private final String description;
  private final String expectation;
  private final LocalDateTime reportedOn;
  private final String status;
  private final String severity;
  private final String type;
  private final String screen;
  private final String subModule;
  private final String module;
  private final String reporter;
}
