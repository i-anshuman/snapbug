package com.snapbug.dtos;

import com.snapbug.entities.IssueType;
import com.snapbug.entities.Screen;
import com.snapbug.entities.Severity;
import com.snapbug.entities.Status;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@Builder
@ToString(doNotUseGetters = true)
public class IssueDTO {
  private Long id;
  private String title;
  private String description;
  private String expectation;
  private Screen screen;
  private LocalDateTime reportedOn;
  private Status status;
  private IssueType type;
  private Severity severity;
}
