package com.snapbug.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString(doNotUseGetters = true, exclude = "password")
public class UserCreationDTO {

  @NotBlank(message = "{validation.user.name}")
  private String name;

  @NotBlank(message = "{validation.user.email}")
  @Email(message = "{validation.user.email.invalid}")
  private String email;

  @NotBlank(message = "{validation.user.username}")
  private String username;

  @NotBlank(message = "{validation.user.password}")
  private String password;

  @NotNull(message = "{validation.user.role}")
  @Positive(message = "{validation.user.role.valid}")
  private Long role;
}
