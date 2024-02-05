package com.snapbug.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString(doNotUseGetters = true, exclude = "password")
public class AuthenticationDTO {

  @NotBlank(message = "{validation.user.username}")
  private String username;

  @NotBlank(message = "{validation.user.password}")
  private String password;
}
