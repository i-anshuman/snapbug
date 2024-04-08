package com.snapbug.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString(doNotUseGetters = true)
public class RolePermissionDTO {
  @NotNull(message = "{validation.role.id}")
  @Positive(message = "{validation.role.id.valid}")
  private Long roleId;

  @NotNull(message = "{validation.permission.id}")
  @Positive(message = "{validation.permission.id.valid}")
  private Long permissionId;
}
