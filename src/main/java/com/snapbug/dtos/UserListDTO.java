package com.snapbug.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString(doNotUseGetters = true)
public class UserListDTO {
  private Long id;
  private String name;
  private String username;
  private String role;
}
