package com.snapbug.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Builder
@ToString(doNotUseGetters = true)
public class AuthenticatedUserDTO {
  private Long id;
  private String token;
  private String username;
  private String role;
  private List<String> authority;
}
