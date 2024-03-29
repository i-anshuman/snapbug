package com.snapbug.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString(doNotUseGetters = true)
public class PageDTO<P> {
  private Long totalElements;
  private Integer totalPages;
  private P content;
}
