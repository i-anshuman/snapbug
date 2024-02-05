package com.snapbug.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@Builder
@ToString(doNotUseGetters = true)
public class UserDTO {
  private Long id;
  private String fullname;
  private String email;
  private String username;
  private String password;
  private LocalDateTime joinDate;
  private String role;
}
