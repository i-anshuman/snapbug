package com.snapbug.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "issue_status")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Status {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "status_id")
  private Long id;

  @Column(name = "status_name", length = 15, nullable = false, unique = true)
  private String name;
}
