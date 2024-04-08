package com.snapbug.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Set;

@Data
@Builder
@ToString(doNotUseGetters = true)
public class RoleDetailsDTO {
  private Long id;
  private String name;
  private Set<PermissionDTO> permissions;
}
