package com.snapbug.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "issue_severity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Severity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "severity_id")
  private Long id;

  @Column(name = "severity_name", length = 15, nullable = false, unique = true)
  private String name;
}
